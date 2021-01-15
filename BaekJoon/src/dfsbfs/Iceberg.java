package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Iceberg {
    /**
     * 백준 2573 빙산 (https://www.acmicpc.net/problem/2573)
     */
    private static int n, m;
    private static int[][] map;
    private static int[][] temp;
    private static boolean[][] visit;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        //빙산 높이 표시
        //일년마다 동서남북 네 방향으로 붙어있는 0의 개수만큼 줄어듬
        //0보다 더 줄어들지는 않음

        //빙산이 두 덩어리 이상으로 분리되는 년도
        //전부 다 녹을때까지 두 덩어리이상 분리 안되면 0

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        temp = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                temp[i][j] = map[i][j];
            }
        }

        int year = 0;
        while (true) {

            int cnt = 0;
            visit = new boolean[n+1][m+1];

            for (int i=2; i<n; i++) {
                for (int j = 2; j < m; j++) {
                    if (!visit[i][j] && map[i][j]>0) {
                        //1년동안 변경전과 비교하기 위해 맵사용
                        cnt++;
                        dfs(i,j);
                    }
                }
            }

            if (cnt==0) {
                //빙산없으면 끝
                year = 0;
                break;
            }

            if (cnt > 1) {
                //덩어리가 2개 이상이면 끝
                break;
            }

            year++;

            for (int i=2; i<n; i++) {
                for (int j = 2; j < m; j++) {
                    if (map[i][j] > 0) {
                        melt(i,j);
                    }
                }
            }

            //연산결과 map으로 옮기기
            for (int i=2; i<n; i++) {
                map[i] = temp[i].clone();
            }

        }//while

        System.out.println(year);

    }

    private static void dfs(int x, int y) {

        visit[x][y] = true;

        for (int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || ny < 1 || nx > n || ny > m) {
                continue;
            }

            if (!visit[nx][ny] && map[nx][ny] > 0) {
                dfs(nx,ny);
            }

        }

    }//dfs

    private static void melt(int x, int y) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        visit[x][y] = true;

        while (!q.isEmpty()) {

            Pair p = q.remove();

            int qx = p.x;
            int qy = p.y;

            int zeroCnt = 0;
            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > m) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    zeroCnt++;
                }
            }

            temp[qx][qy] = temp[qx][qy] - zeroCnt > 0 ? temp[qx][qy] - zeroCnt : 0;

        }//while

    }//melt

    static class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
