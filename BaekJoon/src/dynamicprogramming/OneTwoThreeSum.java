package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OneTwoThreeSum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		long[] result = new long[n];
		long[] dp = new long[1000001];
		
		//점화식
		//dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
		//1 - 1
		//2 - 2
		//3 - 4
		//4 - 7 (1+2+4)
		//5 - 13 (2+4+7)
		//...
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		int num = 0;
		for (int i=0; i<n; i++) {
			num = Integer.parseInt(reader.readLine());
			
			if (num >= 3) {
				for (int j=3; j<=num; j++) {
					dp[j] = (dp[j-1] + dp[j-2] + dp[j-3]) % 1000000009;
				}
			}
			result[i] = dp[num];
		}
		
		for (int i=0; i<n; i++) {
			System.out.println(result[i]);
		}
		
	}//main
}











