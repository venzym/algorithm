package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UphillRoadNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {

		//오름차순
		//인접한 수가 같아도 오름차순
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[][] dp = new int[n+1][10];
		
		//점화식
		//끝자리를 기준으로 2차원 배열
		//n=1 -> 모두 1개
		//dp[i][j] = dp[i-1][j] + dp[i][j-1]
		
		//길이 1은 모두 1개씩
		for (int i=0; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i=1; i<=n; i++) {
			dp[i][0] = 1;
			for (int j=1; j<=9; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007;
			}
		}
		
		int result = 0;
		for (int i=0; i<=9; i++) {
			result += dp[n][i];
		}
		
		System.out.println(result % 10007);
		
	}//main
}












