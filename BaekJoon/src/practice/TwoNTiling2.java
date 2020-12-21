package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoNTiling2 {
	
	private static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		dp = new int[n+1];
		
		System.out.println(cycle(n));
		
	}//main

	private static int cycle(int n) {
		
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 3;
		}
		
		if (dp[n] != 0) {
			return dp[n];
		}
		
		return dp[n] = (cycle(n-1) + 2*cycle(n-2)) % 10007;
		
	}
}









