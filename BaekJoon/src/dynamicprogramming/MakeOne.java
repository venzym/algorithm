package dynamicprogramming;

import java.util.Scanner;

public class MakeOne {
	public static void main(String[] args) {
		
		//X%5 == 0 -> 5로 나눈다
		//X%3 == 0 -> 3으로 나눈다
		//X%2 == 0 -> 2로 나눈다
		//X-1
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		//점화식
		//dp[i] = Math.min(dp[i-1], dp[i/2], dp[i/3]) + 1
		
		int[] dp = new int[n+1];
		
		for (int i=2; i<=n; i++) {
			
			//1을 뺀다
			dp[i] = dp[i-1] + 1;
			
			//2로 나눈다.
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			} 
			//3으로 나눈다.
			if (i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			} 
//			if (i%5 == 0) {
//				dp[i] = Math.min(dp[i], dp[i/5] + 1);
//			}
		}
		
		System.out.println(dp[n]);
		
	}//main
}//MakeOne











