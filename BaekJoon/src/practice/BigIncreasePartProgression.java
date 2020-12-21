package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigIncreasePartProgression {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] map = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		//점화식
		//

		int result = 0;
		for (int i=1; i<=n; i++) {
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










