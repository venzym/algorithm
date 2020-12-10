package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS2 {
	/**
	 * 백준 9252 LCS2 (https://www.acmicpc.net/problem/9252)
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split("");
		char[] first = new char[input.length+1];
		for (int i=1; i<first.length; i++) {
			first[i] = input[i-1].charAt(0);
		}
		
		input = reader.readLine().split("");
		char[] second = new char[input.length+1];
		for (int i=1; i<second.length; i++) {
			second[i] = input[i-1].charAt(0);
		}
		
		int[][] dp = new int[first.length+1][second.length+1];
		
		for (int i=1; i<first.length; i++) {
			for (int j=1; j<second.length; j++) {
				if (first[i] == second[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[first.length-1][second.length-1]);
		
	}
}
