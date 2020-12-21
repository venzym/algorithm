package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sticker2 {
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
			
			//dp : 각 스티커에서 점수의 최댓값
			//dp[1][i] = max(dp[2][j-1], dp[2][j-2]) + map[1][i]
			//dp[2][i] = max(dp[1][j-1], dp[1][j-2]) + map[2][i]
			
			dp[1][1] = map[1][1];
			dp[2][1] = map[2][1];
			
			int result = Math.max(dp[1][1], dp[2][1]);
			
			for (int i=2; i<=n; i++) {
				dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + map[1][i];
				dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[2][i];
				
				result = Math.max(result, Math.max(dp[1][i], dp[2][i]));
			}
			
			sb.append(result + "\n");
			
		}//while
		
		System.out.print(sb);
		
	}
}










