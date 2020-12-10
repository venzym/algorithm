package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaltDelivery {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		//dp : 킬로그램당 봉지의 최소 개수
		
		//3키로, 5키로 2개 종류
		
		int[] dp = new int[n+1];
		
		//보텀업
		for (int i=1; i<=n; i++) {
		
			if (i == 4 || i == 7) {
				dp[i] = -1;
			} else if (i%5 == 0) {
				dp[i] = i/5;
			} else if (i%5 == 1 || i%5 == 3) {
				dp[i] = (i/5) + 1;
			} else if (i%5 == 2 || i%5 == 4) {
				dp[i] = (i/5) + 2;
			}
		}
		
		System.out.println(dp[n]);
		
	}//main
}










