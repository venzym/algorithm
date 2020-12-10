package dynamicprogramming;

import java.util.Scanner;

public class GrapeWine {
	public static void main(String[] args) {

		//포도주 잔 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 한다.
		//마신 후에는 원래 위치에 다시 놓아야 한다.
		//연속으로 놓여 있는 3잔을 마실 수는 없다.
		
		//1~n 포도주
		//가장 많은 양의 포도주 (max)
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] map = new int[n+1];
		for (int i=1; i<=n; i++) {
			map[i] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		
		//dp[i-2] + map[i] - 이전합과 한칸 띄기
		//dp[i-3] + map[i-1] + map[i] //2칸전과 띄고 이전값과 현재값 합
		
		dp[1] = map[1];
		if (n > 1) {
			dp[2] = map[1] + map[2];
		}
		
		for (int i=3; i<=n; i++) {
			int temp1 = dp[i-2] + map[i];
			int temp2 = dp[i-3] + map[i-1] + map[i];
			
			dp[i] = Math.max(dp[i-1], Math.max(temp1, temp2));
		}
		System.out.println(dp[n]);
	}//main
}














