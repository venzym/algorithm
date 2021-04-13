package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Observation {
    /**
     * 백준 15683 감시(https://www.acmicpc.net/problem/15683)
     */
    private static int n,m;
    private static int[][] map;
    private static boolean[][] visit;

    private static ArrayList<Node> list = new ArrayList<>();

    private static int cnt = Integer.MAX_VALUE;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {

        //NxM 직사각형
        //k개의 CCTV 설치

        //5종류

        //벽 통과 불가능

        //회전 가능. -> 90도 방향향
        //ex) 2번의 경우 <> -> 위아래로 변경 가능

        //사각 지대의 최소 크기
        //= 0 개수 세기

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) {
                    //CCTV 리스트
                    list.add(new Node(i,j, map[i][j]));
                }
            }
        }

        //각 CCTV 별 가능한 방향 찾기
        //1번 : dx(0, 1, 2, 3) 총 4방향 가능
        //2번 : <>(1, 3), 상하(0,2) 총 2방향 가능
        //3번 : 상우(0,1), 우하(1,2), 하좌(2,3), 좌상(3,0) 총 4방향 가능
        //4번 : 좌상우(3,0,1), 상우하(0,1,2), 우하좌(1,2,3), 하좌상(2,3,0) 총 4방향 가능
        //5번 : 상우하좌 1번만 가능
        set_direction(0);

        System.out.println(cnt);
    }

    private static void set_direction(int d) {

        if (d == list.size()) {
            cnt = Math.min(cnt, find());
            return;
        }

        Node node = list.get(d);
        int lx = node.x;
        int ly = node.y;
        int l_num = node.num;

        int[][] temp = new int[n][m];

        //나중에 1, 3, 4 합쳐도 될 듯!

        if (l_num == 1) {
            //1번 : dx(0, 1, 2, 3) 총 4방향 가능
            for (int i=0; i<4; i++) {
                //변경된 map 복사하기
                array_copy1(temp);

                spread(i, lx, ly);
                set_direction(d+1);

                //재귀 후 원상복귀
                array_copy2(temp);
            }
        } else if (l_num == 2) {
            //2번 : <>(1, 3), 상하(0,2) 총 2방향 가능
            for (int i=0; i<2; i++) {
                array_copy1(temp);

                spread(i, lx, ly);
                spread(i+2, lx, ly);
                set_direction(d + 1);

                array_copy2(temp);
            }

        } else if (l_num == 3) {
            //3번 : 상우(0,1), 우하(1,2), 하좌(2,3), 좌상(3,0) 총 4방향 가능
            for (int i=0; i<4; i++) {
                array_copy1(temp);

                spread(i, lx, ly);
                spread((i+1)%4, lx, ly);
                set_direction(d + 1);

                array_copy2(temp);
            }
        } else if (l_num == 4) {
            //4번 : 좌상우(3,0,1), 상우하(0,1,2), 우하좌(1,2,3), 하좌상(2,3,0) 총 4방향 가능
            for (int i=0; i<4; i++) {
                array_copy1(temp);

                spread(i, lx, ly);
                spread((i+1)%4, lx, ly);
                spread((i+2)%4, lx, ly);
                set_direction(d+1);

                array_copy2(temp);
            }
        } else if (l_num == 5) {
            //5번 : 상우하좌 1번만 가능
            array_copy1(temp);

            spread(0, lx, ly);
            spread(1, lx, ly);
            spread(2, lx, ly);
            spread(3, lx, ly);
            set_direction(d+1);

            array_copy2(temp);
        }

    }//set_direction

    private static void array_copy1(int[][] temp) {
        for (int i=0; i<n; i++) {
            temp[i] = map[i].clone();
        }
    }//array_copy1

    private static void array_copy2(int[][] temp) {
        for (int i=0; i<n; i++) {
            map[i] = temp[i].clone();
        }
    }//array_copy2

    private static int find() {

        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }//find

    private static void spread(int d, int lx, int ly) {

        int nx = 0;
        int ny = 0;

        nx = lx + dx[d];
        ny = ly + dy[d];

        if (isValid(nx, ny)) {
            return;
        }

        map[nx][ny] = -1;

        spread(d, nx, ny);

    }//spread

    private static boolean isValid(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 6;
    }

    static class Node {
        int x, y, num;

        Node (int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}








