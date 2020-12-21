package practice;

import java.util.Scanner;

public class StairClimbing {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] stair = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			stair[i] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		
		dp[1] = stair[1];
		if (n > 1) {
			dp[2] = stair[1] + stair[2];
		}
		
		//점화식 : dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i])
		
		for (int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
		}
		
		System.out.println(dp[n]);
		
	}
}












