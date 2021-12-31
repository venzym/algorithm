package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSquare {

    /*
     * 백준 1051 숫자 정사각형(https://www.acmicpc.net/problem/1051)
     */
    private static int N, M;
    private static int result = 1;

    public static void main(String[] args) throws IOException {
        //꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = reader.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = map[i][j];
                for (int k = j + 1; k < M; k++) {
                    if (num == map[i][k]) {
                        checkSquare(map, num, i, j, k - j);
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static void checkSquare(int[][] map, int num, int row, int col, int length) {
        //오른쪽 위는 비교했음
        if (row + length >= N || col + length >= M) {
            return;
        }

        boolean flag = num == map[row + length][col];
        //왼쪽 아래
        //오른쪽 아래 비교하면 됨
        if (num != map[row + length][col + length]) {
            flag = false;
        }

        if (flag) {
            result = Math.max(result, ((length + 1) * (length + 1)));
        }
    }
}
