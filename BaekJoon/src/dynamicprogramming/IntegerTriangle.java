package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {
	/**
	 * 백준 1932 정수 삼각형 (https://www.acmicpc.net/problem/1932)
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[][] map = new int[n+1][n+1];
		
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n+1][n+1];
		
		dp[1][1] = map[1][1];
		
		for (int i=2; i<=n; i++) {
			for (int j=1; j<=i; j++) {
				if (j == 1) {
					dp[i][j] = dp[i-1][j] + map[i][j];
				} else if (j == n) {
					dp[i][j] = dp[i-1][j-1] + map[i][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + map[i][j];
				}
			}
		}
		int result = 0;
		for (int i=1; i<=n; i++) {
			result = Math.max(result, dp[n][i]);
		}
		System.out.println(result);
	}//main
}










