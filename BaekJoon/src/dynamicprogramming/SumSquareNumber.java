package dynamicprogramming;

import java.util.Scanner;

public class SumSquareNumber {
	/**
	 * 백준 1699 제곱수의 합 (https://www.acmicpc.net/problem/1699)
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//dp : i일 때 가질 수 있는 항의 최소개수
		int[] dp = new int[n+1];
		
		//점화식
		//i번째 수에서 제곱수를 뺀 후 +1 해준다.
		//빼는 제곱수는 개수 1로 취급
		//dp[i] = min(dp[i], dp[i-j^2]+1)
		
		for (int i=1; i<=n; i++) {
			dp[i] = i;
			for (int j=1; j*j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		System.out.println(dp[n]);
		
	}//main
}









