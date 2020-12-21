package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheLoggestBitonicPartProgression {
	/**
	 * 백준 11054 가장 긴 바이토닉 부분 수열 (https://www.acmicpc.net/problem/11054)
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());

		int[] map = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		
		int index = 0;
		int max = 0;
		for (int i=1; i<=n; i++) {
			dp[i] = 1;
			for (int j=1; j<i; j++) {
				if (map[j] < map[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			
			if (dp[i] > dp[i-1]) {
				index = i;
			}
			
			max = Math.max(max, dp[i]);
		}
		
		for (int i=index+1; i<=n; i++) {
			dp[i] = 1;
			for (int j=index; j<i; j++) {
				if (map[i] < map[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		for (int i=1; i<=n; i++) {
			System.out.print(dp[i] + " ");
		}
		
	}
}









