package practice;

import java.util.Scanner;

public class OneTwoThreeSum5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] result = new long[n];
		long[][] dp = new long[1000001][4];
		
		dp[1][1] = 1;
		
		dp[2][2] = 1;
		
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		int num;
		for (int i=0; i<n; i++) {
			num = sc.nextInt();
			
			if (num > 3) {
				for (int j=4; j<=num; j++) {
					dp[j][1] = (dp[j-1][2] + dp[j-1][3]) % 1000000009;
					dp[j][2] = (dp[j-2][1] + dp[j-2][3]) % 1000000009;
					dp[j][3] = (dp[j-3][1] + dp[j-3][2]) % 1000000009;
				}
			}
			
			result[i] = (dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009;
		}
		
		for (int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
}
















