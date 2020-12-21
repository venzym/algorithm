package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Resign {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+2];
		
		for (int i=1; i<=n; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			if (i + t[i] <= n+1) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
		}
		
		int result = 0;
		for (int i=1; i<dp.length; i++) {
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
		
		
	}//main
}











