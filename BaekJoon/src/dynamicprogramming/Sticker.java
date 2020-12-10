package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sticker {
	/**
	 * 백준 9465 스티커 (https://www.acmicpc.net/problem/9465)
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(reader.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while (t-- > 0) {
			
			int n = Integer.parseInt(reader.readLine());
			
			int[][] map = new int[3][n+1];
			int[][] dp = new int[3][n+1];
			
			StringTokenizer st;
			for (int i=1; i<=2; i++) {
				st = new StringTokenizer(reader.readLine());
				for (int j=1; j<=n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//점화식
			//상하좌우는 안되니까 대각선을 생각 -1, -2 둘 다 고려 가능
			//다른 행의 열 -1, -2 확인 후 큰 것 자신과 더하기
			
			dp[1][1] = map[1][1];
			dp[2][1] = map[2][1];
			
			int max = 0;
			for (int i=2; i<=n; i++) {
				dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + map[1][i];
				dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[2][i];
				max = Math.max(max, Math.max(dp[1][i], dp[2][i]));
			}
			
			sb.append(max + "\n");
		}//while
		
		System.out.print(sb);
		
	}//main
}














