package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinualSum {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] map = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		//각 자리의 최대합
		int[] dp = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			dp[i] = map[i];
			if (dp[i] < dp[i-1] + map[i]) {
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







