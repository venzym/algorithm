package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin1 {
	public static void main(String[] args) throws IOException {
	
		//n가지 종류의 동전
		//동전을 합해서 K원 만들기
		//경우의 수
		//동전 사용 제한 없음
		
		//순서 달라도 구성 같으면 같은 경우
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] map = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(reader.readLine());
		}
		
		//dp : 동전 i개 사용했을 때 가질 수 있는 경우의 수
		int[] dp = new int[k+1];
		
		//동전 공식 : dp[j] = dp[j] + dp[j-coin[i]]
		//coin[i]원으로 1~k까지 만들 수 있는 경우의 수를 누적해서 담는다.
		//ex) map[2] = 2, 
		//4원을 구하는 경우
		//dp[4] = dp[4] + dp[4-2] = dp[4] + dp[2]
		//기존 2원을 구하는 경우에서 2원을 사용하여 구하는 경우를 더한다.
		//2원에서 4원은 2원을 하나 더 추가하는 방법밖에 없다.
		
		dp[0] = 1;
		
		for (int i=1; i<=n; i++) {
			for (int j=map[i]; j<=k; j++) {
				dp[j] = dp[j] + dp[j - map[i]];
			}
		}
		System.out.println(dp[k]);
		
	}
}










