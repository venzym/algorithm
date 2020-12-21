package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {
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
			//대각선 값 비교
			//dp : 각 원소에서 가질 수 있는 최댓값
			//dp[1][i] = max(dp[2][i-1], dp[2][i-2]) + map[i]
			//dp[2][i] = max(dp[1][i-1], dp[1][i-2]) + map[i]
			
			dp[1][1] = map[1][1];
			dp[2][1] = map[2][1];
			
			int result = 0;
			for (int i=2; i<=n; i++) {
				dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + map[1][i];
				dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[2][i];
			
				result = Math.max(result, Math.max(dp[1][i], dp[2][i]));
			}
			
			sb.append(result + "\n");
			
		}//while
		
		System.out.print(sb);
		
	}//main
}












