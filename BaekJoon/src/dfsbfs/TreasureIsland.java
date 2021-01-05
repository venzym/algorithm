package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreasureIsland {
    /**
     * 백준 2589 보물섬 (https://www.acmicpc.net/problem/2589)
     */

    private static int row, col;
    private static char[][] map;
    private static boolean[][] visit;

    private static int time;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        //육지 - L
        //바다 - W
        //상하좌우 이웃한 육지로만 이동 가능
        //한 칸 이동시 한 시간

        //보물 - 서로 최단거리, 가장 긴 시간이 걸리는 육지 두 곳
        //거리, 시간 두 개 구해야 함

        //같은 곳 한번만 가능

        //풀이
        //L마다 최단거리에 있는 L을 찾는다.
        //-> 이후, 시간을 구한다.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row+1][col+1];
        visit = new boolean[row+1][col+1];

        for (int i=1; i<=row; i++) {
            char[] array = reader.readLine().toCharArray();
            for (int j=1; j<=col; j++) {
                map[i][j] = array[j-1];
            }
        }

        int result = 0;

        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                if (map[i][j] == 'L') {
                    visit = new boolean[row+1][col+1];
                    time = 0;
                    bfs(i,j);//가까운 친구 찾기
                    result = Math.max(result, time);
                }
            }
        }

        System.out.println(result);


    }//main

    private static void bfs(int x, int y) {

        Queue<Treasure> q = new LinkedList<>();
        q.add(new Treasure(x,y));
        visit[x][y] = true;

        int distance = Integer.MAX_VALUE;

        int targetX = 0, targetY = 0;

        while (!q.isEmpty()) {

            Treasure tres = q.remove();
            int qx = tres.x;
            int qy = tres.y;

            targetX = qx;
            targetY = qy;

            for (int i=0; i<4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx<1 || ny<1 || nx>row || ny>col) {
                    continue;
                }

                if (!visit[nx][ny] && map[nx][ny] == 'L') {
                    visit[nx][ny] = true;
                    q.add(new Treasure(nx, ny));
                }
            }


        }//while

        //최단거리, 최대시간
        //distance 보다 거리가 같거나 가까운 경우 갱신
        time = Math.max(time, calTime(x, y, targetX, targetY));//시간계산

    }//bfs

    private static int calTime(int x, int y, int targetX, int targetY) {

        Queue<Treasure> q = new LinkedList<>();
        boolean[][] timeVisit = new boolean[row+1][col+1];

        q.add(new Treasure(x,y,0));
        timeVisit[x][y] = true;

        int result = 0;

        while (!q.isEmpty()) {

            Treasure t = q.remove();
            int qx = t.x;
            int qy = t.y;
            int qt = t.time;

            if (qx == targetX && qy == targetY) {
                result = qt;
                break;
            }

            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 1 || ny < 1 || nx > row || ny > col) {
                    continue;
                }

                if (!timeVisit[nx][ny] && map[nx][ny] == 'L') {
                    timeVisit[nx][ny] = true;
                    q.add(new Treasure(nx,ny,qt+1));
                }
            }

        }//while

        return result;


    }//calTime

    static class Treasure {
        int x, y, time;

        Treasure (int x, int y) {
            this.x = x;
            this.y = y;
        }

        Treasure (int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
