package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SandCastle {
    /**
     * 백준 10711 모래성 (https://www.acmicpc.net/problem/10711)
     */
    private static int h,w;
    private static char[][] map;
    private static boolean[][] visit;

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};//상, 상우, 우, 우하, 하, 하좌, 좌, 좌상
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};//상, 상우, 우, 우하, 하, 하좌, 좌, 좌상

    private static Queue<Location> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        //2차원 격자단위
        //1~9사이로 표현
        //8방향을 봐서 모래성이 쌓여있지 않는 부분의 개수가 자기보다 튼튼하거나 같은 경우 파도에 의해 무너질 수 있다.
        //그 이외는 무너지지 않는다.
        //무너진 경우 모래성이 쌓여있지 않은 것이다.
        //언젠가는 깎이고 깎여서 한가지 형태로 수렴할 것이다.

        //수렴되려면 파도가 몇번 처야하는지 구해보자

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h+1][w+1];
        visit = new boolean[h+1][w+1];
        //. -> -1 처리

        for (int i=1; i<=h; i++) {
            String input = reader.readLine();
            for (int j=1; j<=w; j++) {
                map[i][j] = input.charAt(j-1);
            }
        }

        int num = 0;
        int cnt = 0;
        for (int i=1; i<=h; i++) {
            for (int j=1; j<=w; j++) {
                if (map[i][j] == '.') {
                    continue;
                }

                num = map[i][j] - '0';

                if (num == 9) {
                    //9면 절대 무너지지 않는다.
                    continue;
                }

                //. 개수 파악
                cnt = checkCnt(i,j);

                if (cnt >= num) {
                    q.add(new Location(i,j));
                    visit[i][j] = true;
                }

            }
        }

        System.out.println(wave());

    }

    private static int checkCnt(int x, int y) {

        int cnt = 0;

        for (int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (map[nx][ny] == '.') {
                cnt++;
            }
        }

        return cnt;
    }//checkCnt

    private static int wave() {

        int time=0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                Location l = q.remove();

                int qx = l.x;
                int qy = l.y;

                map[qx][qy] = '.';

                for (int i=0; i<dx.length; i++) {
                    int nx = qx + dx[i];
                    int ny = qy + dy[i];

                    if (nx < 1 || ny < 1 || nx > h || ny > w) {
                        continue;
                    }

                    if (map[nx][ny] == '.') {
                        continue;
                    }

                    int num = map[nx][ny]-'0';
                    if (!visit[nx][ny] && checkCnt(nx,ny) >= num) {
                        q.add(new Location(nx, ny));
                        visit[nx][ny] = true;
                    }
                }


            }//while

            time++;
        }//while

        return time;
    }//wave

    static class Location {
        int x, y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}









