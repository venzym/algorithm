package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumDisassemble {
	/**
	 * 백준 2225 합분해 (https://www.acmicpc.net/problem/2225)
	 */
	public static void main(String[] args) throws IOException {
		
		//0~N까지 정수 K개를 더해서 그 합이 N이 되는 경우의 수
		//0 + 1 + 2 + ... = N
		
		//순서 바뀐 경우도 다른 경우
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[k+1][n+1];//k개를 고른 합 N의 경우의 수
		
		//점화식
		//dp[k][n] = dp[k-1][n-p];
		
		for (int i=0; i<=n; i++) {
			dp[1][i] = 1; //1개 수로 i 만드는 방법은 1개(자신)
		}
		
		
		for (int i=2; i<=k; i++) {
			//i(k)개 수로 j(n)만드는 방법
			
			for (int j=0; j<=n; j++) {
				
				for (int p=0; p<=j; p++) {
//					System.out.println("i :: " + i + " , j :: " + j + " , dp :: " + dp[i-1][j-p]);
					dp[i][j] += dp[i-1][j-p];
					dp[i][j] %= 1000000000;
//					System.out.println("dp[i][j] :: " + dp[i][j]);
				}
			}
		}
		
		System.out.println(dp[k][n]);
		
	}
}









