package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin1_2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] map = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(reader.readLine());
		}
		
		int[] dp = new int[k+1];
		
		dp[0] = 1;
		
		for (int i=1; i<=n; i++) {
			for (int j=map[i]; j<=k; j++) {
				dp[j] = dp[j] + dp[j - map[i]];
			}
		}
		
		System.out.println(dp[k]);
		
	}
}










