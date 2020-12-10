package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreeSum5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		long[][] dp = new long[100001][4];
		long[] result = new long[n];
		//[][1] : 1로 끝나는 값 개수
		//[][2] : 2로 끝나는 값 개수
		//[][3] : 3으로 끝나는 값 개수
		
		dp[1][1] = 1;
		
		dp[2][2] = 1;
		
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		//기존 점화식
		//dp[i] = dp[i-1] + dp[i-2] + dp[i-3] (1,2,3으로 이루어짐)
		
		//새로운 점화식
		//1, 2, 3을 2차원 배열로 나누어 더해줌
		
		//ex) 7 - 6이 되는 경우의수 + 1,2,3
		
		for (int i=4; i<=100000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
		}
		
		int num = 0;
		for (int i=0; i<n; i++) {
			num = Integer.parseInt(reader.readLine());
			result[i] = (dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009;
		}
		
		for (int i=0; i<n; i++) {
			System.out.println(result[i]);
		}
		
	}//main
}












