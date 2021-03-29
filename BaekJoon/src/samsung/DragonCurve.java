package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DragonCurve {
    /**
     * 백준 15685 드래곤 커브(https://www.acmicpc.net/problem/15685)
     */
    public static void main(String[] args) throws IOException {

        //x축 오른쪽(->)
        //y축 아래

        //0세대 : 오른쪽(0)
        //1세대 : 시계방향으로 90도 회전(0, 1)
        //2세대 : (0, 1, 2, 1)
        //3세대 : (0, 1, 2, 1, 2, 3, 2, 1) 반대로 +1

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[][] map = new int[n][4];//4방향
        boolean[][] visit = new boolean[101][101];//x,y<=100

        ArrayList<Integer> direction = new ArrayList<>();

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());//시작 방향
            int g = Integer.parseInt(st.nextToken());//세대
            int end = (int)Math.pow(2, g);

            direction = new ArrayList<>();
            direction.add(d);
            visit[y][x] = true;

            //다음 세대 드래곤 쿼브
            reverse_dir(direction, g);

            move_curve(direction, visit, x, y);
        }

        int result = 0;
        for (int i=0; i<visit.length-1; i++) {
            for (int j=0; j<visit[i].length-1; j++) {
                if (visit[i][j] && visit[i][j+1] && visit[i+1][j] && visit[i+1][j+1]) {
                    result++;
                }
            }
        }
        System.out.println(result);

    }

    private static void move_curve(ArrayList<Integer> direction, boolean[][] visit, int x, int y) {

        //방향에 따른 이동
        for (int i=0; i<direction.size(); i++) {
            switch (direction.get(i)) {
                case 0:
                    visit[y][++x] = true;
                    break;
                case 1:
                    visit[--y][x] = true;
                    break;
                case 2:
                    visit[y][--x] = true;
                    break;
                case 3:
                    visit[++y][x] = true;
                    break;
            }
        }

    }//move_curve

    private static void reverse_dir(ArrayList<Integer> direction, int g) {

        //역순으로 1추가
        for (int i=0; i<g; i++) {
            for (int j=direction.size()-1; j>=0; j--) {
                switch (direction.get(j)) {
                    case 0:
                        direction.add(1);
                        break;
                    case 1:
                        direction.add(2);
                        break;
                    case 2:
                        direction.add(3);
                        break;
                    case 3:
                        direction.add(0);
                        break;
                }
            }
        }

    }//reverse_dir
}
