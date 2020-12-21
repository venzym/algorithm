package practice;

import java.util.Scanner;

public class OneTwoThreeSum3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] result = new long[n];
		long[] dp = new long[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		int num = 0;
		for (int i=0; i<n; i++) {
			num = sc.nextInt();
			
			if (num > 3) {
				for (int j=4; j<=num; j++) {
					dp[j] = (dp[j-1] + dp[j-2] + dp[j-3])%1000000009;
				}
			}
			
			result[i] = dp[num];
		}
		
		for (long i : result) {
			System.out.println(i);
		}
	}
}












