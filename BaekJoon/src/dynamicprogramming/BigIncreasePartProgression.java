package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigIncreasePartProgression {
	/**
	 * 백준 11053 가장 긴 증가하는 부분 수열(https://www.acmicpc.net/problem/11053)
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] map = new int[n];
		int[] dp = new int[n]; //각 순서마다 부분 수열 최대 길이
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=0; i<n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1;
		for (int i=1; i<n; i++) {
			dp[i] = 1; //자신
			for (int j=0; j<i; j++) {
				if (map[i] > map[j] && dp[j]+1 > dp[i]) {
					//이전 값보다 크고, 길이가 더 긴 경우
					int a = dp[j] + 1;
					System.out.println("i :: " + i + " , j ::" + j + " , dp[j]+1 :: " + a + " , dp[i] :: " + dp[i] );
					dp[i] = dp[j]+1;
				}
			}
		}
		
		int result = 0;
		for (int i=0; i<dp.length; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
		
	}//main
}//PartProgression








