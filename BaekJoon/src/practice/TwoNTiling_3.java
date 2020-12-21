package practice;

import java.util.Scanner;

public class TwoNTiling_3 {
	private static int[] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new int[n+1];
		
		System.out.println(cycle(n));
		
	}//main
	
	private static int cycle(int n) {
		
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}
		
		if (dp[n] != 0) {
			return dp[n];
		}
		
		return dp[n] = (cycle(n-1) + cycle(n-2))%10007;
	}
}









