package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyCard1_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] card = new int[n+1];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=1; i<=n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		
		dp[1] = card[1];
		
		for (int i=2; i<=n; i++) {
			dp[i] = card[i];
			for (int j=1; j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j] + card[j]);
			}
		}
		
		System.out.println(dp[n]);
		
	}
}












