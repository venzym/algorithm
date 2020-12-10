package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoNTiling {

	private static int[] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//[n-1] + [n-2]
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1];
		
		System.out.println(dp(n));
		
	}

	private static int dp(int n) {
		
		if (n == 1) return 1;
		if (n == 2) return 2;
		
		if (map[n] != 0) return map[n];
		
		return map[n] = (dp(n-1) + dp(n-2)) % 10007;
	}
}
