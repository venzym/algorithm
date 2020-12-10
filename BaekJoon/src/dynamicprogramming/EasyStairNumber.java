package dynamicprogramming;

import java.util.Scanner;

public class EasyStairNumber {
	/**
	 * 백준 10844 쉬운 계단 수 (https://www.acmicpc.net/problem/10844)
	 */
	public static void main(String[] args) {
		
		//45656
		//인접한 모든 자리수 차이 == 1 == 계단 수
		
		//dp : 길이가 N인 계단 수
		//2차원 배열로 각 길이마다 끝나는 수를 기준으로 개수 세기
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[][] dp = new long[n+1][10]; //0~9까지
		
		dp[1][0] = 0;
		for (int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i=2; i<=n; i++) {
			for (int j=0; j<=9; j++) {
				if (j==0) {
					dp[i][j] = dp[i-1][j+1];
				} else if (j==9) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
				}
			}
		}
		
		long sum = 0;
		for (int i=0; i<=9; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum%1000000000);
	}//main
}
















