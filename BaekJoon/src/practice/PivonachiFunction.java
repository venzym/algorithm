package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PivonachiFunction {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[][] dp = new int[41][2];
		int[][] result = new int[n][2];
		
		dp[0][0] = 1;//0일 때 0-1번 호출
		dp[1][1] = 1;//1일 대 1-1번 호출
		
		for (int i=0; i<n; i++) {
			int input = Integer.parseInt(reader.readLine());
			
			if (input > 1) {
				for (int j=2; j<=input; j++) {
					dp[j][0] = dp[j-2][0] + dp[j-1][0] ;
					dp[j][1] = dp[j-2][1] + dp[j-1][1];
				}
			}
			result[i][0] = dp[input][0];
			result[i][1] = dp[input][1];
		}
		
		for (int i=0; i<n; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);
		}
		
	}//main
}












