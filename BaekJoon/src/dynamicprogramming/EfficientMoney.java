package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EfficientMoney {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] money = new int[n];
		for (int i=0; i<n; i++) {
			money[i] = Integer.parseInt(reader.readLine());
		}
		
		int[] dp = new int[m+1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		
		for (int i=0; i<n; i++) {
			for (int j=money[i]; j<=m; j++) { //단위수 ~ m 까지 비교
				if (dp[j-money[i]] != 10001) { //처음 2, 3에서 -2, -3했을 때 0은 0이므로 대입 가능
					dp[j] = Math.min(dp[j], dp[j-money[i]] + 1);
				}
			}
		}
		
		if (dp[m] == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[m]);
		}
		
	}//main
}//EfficientMoney
