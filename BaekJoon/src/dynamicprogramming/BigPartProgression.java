package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigPartProgression {
	/**
	 * 백준 11055 가장 큰 증가 부분 수열 (https://www.acmicpc.net/problem/11055)
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] map = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp : 각 원소의 가장 큰 증가 부분 수열 합
		//점화식 : dp[i] = max(dp[i], dp[i-1] + map[i]
		
		dp[1] = map[1];
		
		int result = dp[1];
		for (int i=2; i<=n; i++) {
			dp[i] = map[i];
			for (int j=1; j<i; j++) {
				if (map[i] > map[j]) {
					dp[i] = Math.max(dp[i], dp[j] + map[i]);
				}
			}
			result = Math.max(result, dp[i]);
		}
		
		
		System.out.println(result);
	}//main
}








