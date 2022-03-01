package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RepaintChess {

    /**
     * 백 1018 체스판 다시 칠하기(https://www.acmicpc.net/problem/1018)
     */
    private static int N, M, result = 64;
    private static char map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = temp.charAt(j - 1);
            }
        }

        for (int i = 1; i + 7 <= N; i++) {
            for (int j = 1; j + 7 <= M; j++) {
                result = Math.min(result, search(i, j));
            }
        }

        System.out.println(result);
    }

    static int search(int x, int y) {
        int cnt = 0;
        for (int i = x; i <= x + 7; i++) {
            for (int j = y; j <= y + 7; j++) {
                if ((i + j) % 2 == 0 && map[i][j] != 'B') {
                    //짝수
                    cnt++;
                }
                if ((i + j) % 2 == 1 && map[i][j] != 'W') {
                    //홀수
                    cnt++;
                }
            }
        }

        return Math.min(cnt, 64 - cnt);
    }
}
