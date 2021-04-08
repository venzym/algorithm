package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HumanMove {
    /**
     * 백준 16234 인구 이동(https://www.acmicpc.net/problem/16234)
     */
    private static int n, l, r;
    private static int[][] map;
    private static boolean[][] visit;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        //N*N 땅
        //[r][c]명이 산다
        //모든 국경은 정사각형

        //두 나라의 인구차가 L ~ R명 이면 하루 연다
        //하루 동안은 연합
        //연합 각 칸 인구수는 (연합 인구수) / (연합 이루는 칸의 개수)
        //연합을 해체하고, 모든 국경선을 닫는다.

        //인구 이동이 몇 번 발생하는지!

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());//n*n
        l = Integer.parseInt(st.nextToken());//l명이상
        r = Integer.parseInt(st.nextToken());//r명이하

        map = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean update = true;
        int result = 0;

        while (update) {
            update = false;

            visit = new boolean[n+1][n+1];
            int[][] status = new int[n+1][n+1];
            int[] sum = new int[2501];
            int[] count = new int[2501];
            int index = 0;

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (!visit[i][j]) {
                        index++;
                        bfs(i, j, status, sum, count, index);
                    }
                }
            }

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    int num = status[i][j];
                    int avg = sum[num] / count[num];
                    if (avg != map[i][j]) {
                        map[i][j] = avg;
                        update = true;
                    }
                }
            }

            if (update) {
                result++;
            }

        }//while

        System.out.println(result);

    }

    private static void bfs(int x, int y, int[][] status, int[] sum, int[] count, int index) {

        Queue<Population> q = new LinkedList<>();
        q.add(new Population(x, y, map[x][y]));
        visit[x][y] = true;

        while (!q.isEmpty()) {

            Population p = q.poll();
            int qx = p.x;
            int qy = p.y;
            int q_num = p.num;

            status[qx][qy] = index;
            count[index]++;
            sum[index] += map[qx][qy];

            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n) {
                    continue;
                }

                int minus = Math.abs(q_num - map[nx][ny]);

                if (!visit[nx][ny] && (minus >= l && minus <= r)) {
                    visit[nx][ny] = true;
                    q.add(new Population(nx, ny, map[nx][ny]));
                }
            }

        }//while

    }//bfs

    static class Population {
        int x, y, num;

        Population(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}