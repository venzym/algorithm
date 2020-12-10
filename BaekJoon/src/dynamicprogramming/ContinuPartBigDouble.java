package dynamicprogramming;

import java.util.Scanner;

public class ContinuPartBigDouble {
	/**
	 * 백준 2670 연속부분최대곱 (https://www.acmicpc.net/problem/2670)
	 */
	public static void main(String[] args) {
		
		//연속된 수들의 곱최대
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		double[] map = new double[n+1];
		for (int i=1; i<=n; i++) {
			map[i] = sc.nextDouble();
		}
		
		double[] dp = new double[n+1];
		
		double result = 0;
		double temp = 0;
		for (int i=1; i<=n; i++) {
			temp = map[i];
			dp[i] = Math.max(dp[i], temp);
			for (int j=i+1; j<=n; j++) {
				temp *= map[j];
				dp[i] = Math.max(dp[i], temp);
			}
			result = Math.max(result, dp[i]);
		}
		
		System.out.printf("%.3f", result);
		
	}
}












