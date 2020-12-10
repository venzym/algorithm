package dynamicprogramming;

import java.util.Scanner;

public class Pivonachi {
	/**
	 * 백준 2748 피보나치 (https://www.acmicpc.net/problem/2748)
	 */
	private static long[] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		dp = new long[n+1];
		
		System.out.println(cycle(n));
		
	}//main

	private static long cycle(int n) {
		
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		if (dp[n] != 0) return dp[n];
		
		return dp[n] = cycle(n-1) + cycle(n-2);
	}
}
