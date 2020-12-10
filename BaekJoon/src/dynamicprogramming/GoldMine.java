package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldMine {
	
	/**
	 * 나동빈 금광 (p.375)
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(reader.readLine());
		
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			
			StringTokenizer st = new StringTokenizer(reader.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] gold = new int[n+1][m+1];
			
			for (int i=1; i<=n; i++) {
				st = new StringTokenizer(reader.readLine());
				for (int j=1; j<=m; j++) {
					gold[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[n+1][m+1];
			
			for (int i=1; i<=n; i++) {
				dp[i][1] = gold[i][1];
			}
			
			int result = 0;
			for (int i=2; i<=m; i++) {
				for (int j=1; j<=n; j++) {
					int temp1, temp2, temp3;
					if (j == 1) {
						//첫줄
						temp1 = dp[j][i-1] + gold[j][i];
						temp2 = dp[j+1][i-1] + gold[j][i];
						dp[j][i] = Math.max(temp1, temp2);
					} else if (j == n) {
						//마지막줄
						temp2 = dp[j-1][i-1] + gold[j][i];
						temp3 = dp[j][i-1] + gold[j][i];
						dp[j][i] = Math.max(temp2, temp3);
					} else {
						//중간줄
						temp1 = dp[j-1][i-1] + gold[j][i];
						temp2 = dp[j][i-1] + gold[j][i];
						temp3 = dp[j+1][i-1] + gold[j][i];
						dp[j][i] = Math.max(temp1, Math.max(temp2, temp3));
					}
					result = Math.max(result, dp[j][i]);
				}
			}
			
			sb.append(result + "\n");
			
		}//while
		
		System.out.print(sb);
		
	}
}








