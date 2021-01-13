package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoZeroFourEight_2048 {
    /**
     * 백준 12100 2048(Easy) (https://www.acmicpc.net/problem/12100)
     */
    private static int n;
    private static int[][] map;
    private static int[][] temp;
    private static int[] direct;
    private static boolean[][] visit;

    private static int max = 0;

    private static int[] dx = {-1, 0, 1, 0};//상우하좌 <-> 하상좌우
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        map = new int[n+1][n+1];
        direct = new int[5];

        StringTokenizer st;
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(5,0);//5번
        System.out.println(max);

    }

    private static void dfs(int end, int index) {

        if (index == end) {

            //확인
            confirm();

        } else {
            for (int i=0; i<4; i++) {
                direct[index] = i;
                dfs(end, index+1);
            }
        }

    }//dfs

    private static void confirm() {

        temp = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            temp[i] = map[i].clone();
        }

        for (int d=0; d<direct.length; d++) {
            visit = new boolean[n+1][n+1];

            //하상좌우

            if (direct[d] == 0) {//상
                for (int i=1; i<=n; i++) {
                    for (int j=1; j<=n; j++) {
                        move(i,j,direct[d]);
                    }
                }
            } else if (direct[d] == 2) {//하
                for (int i=n; i>=1; i--) {
                    for (int j=1; j<=n; j++) {
                        move(i,j,direct[d]);
                    }
                }
            } else if (direct[d] == 1) {//우
                for (int i=n; i>=1; i--) {
                    for (int j=1; j<=n; j++) {
                        //오른쪽부터 봐야함 (j,i로 보내기)
                        move(j,i,direct[d]);
                    }
                }
            } else {//좌
                for (int i=1; i<=n; i++) {
                    for (int j=1; j<=n; j++) {
                       //왼쪽부터 봐야함
                        move(j,i,direct[d]);
                   }
               }
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (temp[i][j] > max) {
                    max = temp[i][j];
                }
            }
        }

    }//confirm

    private static void move(int x, int y, int dir) {

        if (temp[x][y] == 0) {
            return;
        }

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                return;
            }
            if (visit[nx][ny]) {
                return;
            }
            if (temp[nx][ny] == temp[x][y]) {
                //같을때 합치기
                visit[nx][ny] = true;
                temp[nx][ny] *= 2;
                temp[x][y] = 0;
                return;
            } else if (temp[nx][ny] != 0) {
                //같지 않고 다른 수가 있을 때 못합침
                return;
            }

            temp[nx][ny] = temp[x][y];
            temp[x][y] = 0;
            x = nx;
            y = ny;

        }

    }//move
}
