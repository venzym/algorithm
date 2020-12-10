package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			coin[i] = Integer.parseInt(reader.readLine());
		}
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;
		//0일땐 동전 개수 0
		//개수 셀 때 +1을 해주기 때문에 1을 넣어놓을 필요가 없다.
		
		//ex) 15원 개수 구할 때, 5원 3개 || 12원 1개 1원 3개 -> min 함수 필요
		for (int i=1; i<=n; i++) {
			for (int j=coin[i]; j<=k; j++) {
				dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1);
			}
		}
		
		if (dp[k] == Integer.MAX_VALUE-1) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
		
	}
}









