package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Move {
	/**
	 * 백준 11048 이동하기 (https://www.acmicpc.net/problem/11048)
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] maze = new int[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=m; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//dp : 각 위치에서 가질 수 있는 사탕 개수 최댓값
		int[][] dp = new int[n+1][m+1];
		
		for (int row=1; row<=n; row++) {
			for (int col=1; col<=m; col++) {
				int temp1 = dp[row-1][col];
				int temp2 = dp[row][col-1];
				int temp3 = dp[row-1][col-1];
				dp[row][col] = Math.max(temp1, Math.max(temp2, temp3)) + maze[row][col];
			}
		}
		
		System.out.println(dp[n][m]);
	}
}









