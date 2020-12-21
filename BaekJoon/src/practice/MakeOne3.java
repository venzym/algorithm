package practice;

import java.util.Scanner;

public class MakeOne3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		
		//dp : 각 정수별 1 만들기 위해 연산을 사용하는 최소 횟수
		
		for (int i=2; i<=n; i++) {
			dp[i] = dp[i-1]+1;
			
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}

			if (i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
		}
		
		System.out.println(dp[n]);
		
	}
}










