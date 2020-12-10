package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoNTiling2 {
	
	private static int[] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1];
		
		System.out.println(dp(n));
		
	}

	private static int dp(int n) {
		
		if (n == 1) return 1;//가로 1일때 1가지만 가능
		if (n == 2) return 3;//가로 2일때 3가지(1+2) 가능
		
		if (map[n] != 0) return map[n];
		
		return map[n] = (dp(n-1) + 2*dp(n-2)) % 10007;
	}
}
