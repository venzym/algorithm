package practice;

import java.util.Scanner;

public class SumSquareNumber {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//각 원소별 제곱수 항의 최소 개수
		int[] dp = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			dp[i] = i;
			for (int j=1; j*j<=i; j++) {
				//제곱수
				//제곱수를 빼면 결과적으로 제곱수(1)을 더한것이다.
				//i가 j^2보다 작으면 제곱수를 뺼 수가 없다.
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}
		
		System.out.println(dp[n]);
		
	}//main
}
