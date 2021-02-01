package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheBiggestSquare {
    /**
     * 백준 1915 가장 큰 정사각형 (https://www.acmicpc.net/problem/1915)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][m+1];

        int max = Integer.MIN_VALUE;

        for (int i=1; i<=n; i++) {
            String input = reader.readLine();
            for (int j=1; j<=m; j++) {
                dp[i][j] = input.charAt(j-1) - '0';

                if (dp[i][j] == 0) {
                    continue;
                }


                int min = Integer.MAX_VALUE;

                if (min > dp[i-1][j]) {
                    min = dp[i-1][j];
                }

                if (min > dp[i-1][j-1]) {
                    min = dp[i-1][j-1];
                }

                if (min > dp[i][j-1]) {
                    min = dp[i][j-1];
                }

                dp[i][j] = min+1;


                if (max < dp[i][j]) {
                    max = dp[i][j];
                }


            }
        }


        System.out.println(max*max);
    }
}




















