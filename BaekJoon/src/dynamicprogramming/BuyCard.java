package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyCard {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//돈을 최대한 많이 지불해 N개 구매
		
		//4가지 종류, 1 5 6 7
		
		//map : n개의 카드팩을 사기 위한 비용
		//dp : n개의 파드팩을 사기 위한 최대 비용
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		

		int n = Integer.parseInt(reader.readLine());
	
		int[] map = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp[i-j] + map[j]
		//i-j개 구하는 최대가격에서 j개 사기위한 비용을 더한다.
		
		dp[0]=0;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + map[j]);
			}
		}
		
		System.out.println(dp[n]);
		
	}//main
}//BuyCard












