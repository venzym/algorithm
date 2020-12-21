package practice;

import java.util.Scanner;

public class GrapeWine {
	public static void main(String[] args) {
	
		//연속 3잔 불가능(2잔까지만)
		//포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야함
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] map = new int[n+1];
		int[] dp = new int[n+1];
		
		//dp : 각 원소당 마실 수 있는 포도주의 최대 양
		
		for (int i=1; i<=n; i++) {
			map[i] = sc.nextInt();
		}
		
		dp[1] = map[1];
		if (n >= 2) {
			dp[2] = dp[1] + map[2];
		}
		
		for (int i=3; i<=n; i++) {
			int temp1 = dp[i-2] + map[i];
			int temp2 = dp[i-3] + map[i-1] + map[i];
			
			dp[i] = Math.max(dp[i-1], Math.max(temp1, temp2));
		}
		System.out.println(dp[n]);
		
	}
}













