package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotSimulation {
    /**
     * 백준 2174 로봇 시뮬레이션 (https://www.acmicpc.net/problem/2174)
     */
    private static int a,b;
    private static int[][] map;

    //북서동남
    private static int[] dx = {-1,0,0,1};
    private static int[] dy = {0,-1,1,0};

    private static Robot[] robot;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        //L : 왼쪽으로 90도 회전
        //R : 오른쪽으로 90도 회전
        //F : 앞으로 한 칸 이동

        //초기방향 : NWES(북서동남)

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        map = new int[b+1][a+1];

        st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());//각 로봇 초기 위치
        int m = Integer.parseInt(st.nextToken());//명령

        robot = new Robot[n+1];


        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            int d = 0;
            //북서동남
            if (dir == 'N') {
                d = 0;
            } else if (dir == 'W') {
                d = 1;
            } else if (dir == 'E') {
                d = 2;
            } else {
                d = 3;
            }

            y = (b+1)- y; //핵심... 후

            map[y][x] = i;
            robot[i] = new Robot(y,x,d);//n : 로봇 번호
        }

//        print();

        boolean flag = true;
        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(reader.readLine());
            int index = Integer.parseInt(st.nextToken());
            char order = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());

            if (!action(index, order, repeat)) {
                break;
            }
        }

        if (sb.length() == 0) {
            System.out.println("OK");
        } else {
            System.out.println(sb);
        }


    }

    private static void print() {
        for (int i=1; i<=b; i++) {
            for (int j=1; j<=a; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean action(int index, char order, int repeat) {
        //로봇번호, 명령, 반복횟수

        for (int i=0; i<repeat; i++) {
            //L : 왼쪽90도
            //R : 오른쪽90도
            //F : 직진
            Robot temp = robot[index];
            int x = temp.x;
            int y = temp.y;
            int dir = temp.dir;

//            print();

            if (order == 'F') {
                //직진
                if (!move(index, x, y, dir)) {
                    //이동 불가능할 때
                    return false;
                }

            } else if (order == 'L') {
                //왼쪽 90도
                dir = setLeft(index, dir);
                robot[index] = new Robot(x, y, dir);
            } else {
                //R
                //오른쪽 90도
                dir = setRight(index, dir);
                robot[index] = new Robot(x, y, dir);
            }
        }

        return true;
    }//action

    private static boolean move(int index, int x, int y, int dir) {

        map[x][y] = 0;
        x += dx[dir];
        y += dy[dir];

        if (x < 1 || y < 1 || x > b || y > a) {
            sb.append(String.format("Robot %d crashes into the wall", index));
            return false;
        }
        if (map[x][y] != 0 && map[x][y] != index) {
            sb.append(String.format("Robot %d crashes into robot %d", index, map[x][y]));
            return false;
        }

        map[x][y] = index;
        robot[index] = new Robot(x,y,dir);

        return true;

    }//move

    private static int setRight(int index, int dir) {

        //북서동남
        //0 1 2 3

        switch (dir) {
            case 0:
                return 2;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 1;
        }

        return dir;
    }//setRight

    private static int setLeft(int index, int dir) {
        //방향설정

        //북서동남
        //0 1 2 3
        switch (dir) {
            case 0:
                return 1;
            case 1:
                return 3;
            case 2:
                return 0;
            case 3:
                return 2;
        }
        return dir;
    }//setLeft

    static class Robot {
        int x, y, dir;
        Robot (int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

}















