package dynamicprogramming;

import java.util.Scanner;

public class PinaryNumber {
	/**
	 * 백준 2193 이친수 (https://www.acmicpc.net/problem/2193)
	 */
	public static void main(String[] args) {
		
		//1. 0으로 시작하지 않는다.
		//2. 1이 두 번 연속으로 나타나지 않는다. (ex) 11)
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//dp : i자리에서 가능한 이친수의 개수
		//90 입력시 2880067194370816120 int범위 초과
		long[] dp = new long[n+1];
		
		//규칙
		//1,1,2,3,5,.... - 피보나치와 동일하게 증가
		
		dp[0] = 0;
		dp[1] = 1;
		for (int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
		
	}//main
}












