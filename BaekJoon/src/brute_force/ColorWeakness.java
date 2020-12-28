package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ColorWeakness {
    /**
     * 백준 10026 적록색약 (https://www.acmicpc.net/problem/10026)
     */
    private static int n;
    private static char[][] map;
    private static boolean[][] visit;
    private static boolean[][] visit2;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        map = new char[n+1][n+1];
        visit = new boolean[n+1][n+1];
        visit2 = new boolean[n+1][n+1];

        StringTokenizer st;
        for (int i=1; i<=n; i++) {
            char[] cArr = reader.readLine().toCharArray();
            for (int j=1; j<=n; j++) {
                map[i][j] = cArr[j-1];
            }
        }

        int normal = 0;
        int abNormal = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (!visit[i][j]) {
                    bfs(i,j,map[i][j], 0); //정상
                    normal++;
                }
                if (!visit2[i][j]) {
                    bfs(i,j,map[i][j], 1); //비정상
                    abNormal++;
                }
            }
        }

        System.out.println(normal + " " + abNormal);

    }

    private static void bfs(int x, int y, char color, int status) {
        Queue<Color> q = new LinkedList<>();
        q.add(new Color(x, y, color));
        if (status == 0) {
            //정상
            visit[x][y] = true;
        } else {
            //비정상
            visit2[x][y] = true;
        }

        while (!q.isEmpty()) {

            Color c = q.remove();
            int qx = c.x;
            int qy = c.y;
            int qColor = c.color;

            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n) {
                    continue;
                }

                if (status == 0) {
                    //정상 -> R,G,B 구분
                    if (map[nx][ny] != qColor) {
                        continue;
                    }

                    if (!visit[nx][ny] && map[nx][ny] == qColor) {
                        visit[nx][ny] = true;
                        q.add(new Color(nx,ny,map[nx][ny]));
                    }

                } else {
                    //비정상 -> (R,G) B 구분
                    if (qColor == 'R' || qColor == 'G') {
                        if (map[nx][ny] == 'B') {
                            continue;
                        }
                    } else if (qColor == 'B') {
                        if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                            continue;
                        }
                    }

                    if (!visit2[nx][ny]) {
                        visit2[nx][ny] = true;
                        q.add(new Color(nx,ny,map[nx][ny]));
                    }

                }

            }

        }//while

    }//bfs

    static class Color {
        int x, y;
        char color;
        Color (int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }//Color
}






