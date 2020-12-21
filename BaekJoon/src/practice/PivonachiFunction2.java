package practice;

import java.util.Scanner;

public class PivonachiFunction2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] dp = new int[41][2];
		int[][] result = new int[n][2];
		
		dp[0][0] = 1;
		dp[1][1] = 1;
		
		for (int i=0; i<n; i++) {
			int input = sc.nextInt();
			
			if (input > 1) {
				for (int j=2; j<=input; j++) {
					dp[j][0] = dp[j-1][0] + dp[j-2][0];
					dp[j][1] = dp[j-1][1] + dp[j-2][1];
				}
			}
			result[i][0] = dp[input][0];
			result[i][1] = dp[input][1];
		}
		
		for (int i=0; i<n; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);
		}
				
	}//main
}









