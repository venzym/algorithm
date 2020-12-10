package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinualSum {
	/**
	 * 백준 1912 연속합 (https://www.acmicpc.net/problem/1912)
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] map = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp : 각 자리의 최대합
		int[] dp = new int[n+1];
		
		//이전 최대합 + 현재값 < 현재값 -> 최대값x
		//점화식
		//dp[i] = dp[i-1] + map[i]
		
		dp[1] = map[1];
		for (int i=2; i<=n; i++) {
			dp[i] = map[i];
			if (dp[i-1] + map[i] > map[i]) {
				dp[i] = dp[i-1] + map[i];
			}
		}
		
		int result = Integer.MIN_VALUE;
		for (int i=1; i<=n; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
		
	}//main
}











