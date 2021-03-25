package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CrazyRobot {
    /**
     * 백준 1405 미친 로봇(https://www.acmicpc.net/problem/1405)
     */
    private static int n;

    private static double[] dir = new double[4];
    private static int[][] map = new int[30][30];

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static double result = 0;

    public static void main(String[] args) throws IOException {

        //N번의 행동
        //4개 방향 중 하나를 임의로 선택
        //같은 곳을 1번 이상 이동하지 않을 때 -> 로봇의 이동 경로가 단순하다.
        //시작 위치가 처음 방문한 곳
        //이동 경로가 단순할 확률

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i=0; i<4; i++) {
            dir[i] = Double.parseDouble(st.nextToken());
        }

        dfs(15, 15, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int x, int y, int count, double cal) {

        if (count == n) {
            //확률 더하기
            result += cal;

        } else {
            map[x][y] = 1;
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (map[nx][ny] == 1) {
                    continue;
                }
                dfs(nx, ny, count+1, cal * (dir[i] / 100));
                map[nx][ny] = 0;
            }
        }

    }//dfs
}
