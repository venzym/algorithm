package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntSoldier {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] map = new int[n];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		for (int i=0; i<n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		
		dp[0] = 1;
		dp[1] = Math.max(map[0], map[1]);
		for (int i=2; i<n; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + map[i]);
		}
		
		System.out.println(dp[n-1]);
		
		
	}//main
}//class








