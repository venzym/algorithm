package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] dp = new int[n+1];
		
		for (int i=2; i<=n; i++) {
			
			dp[i] = dp[i-1] + 1; //1을 뺀 경우
			
			if (i%2 == 0) {
				//2로 나눠지는 경우
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
			
			if (i%3 == 0) {
				//3으로 나눠지는 경우
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			
		}
		
		System.out.println(dp[n]);
		
		
	}//main
}














