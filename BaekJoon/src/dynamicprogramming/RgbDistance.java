package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RgbDistance {
	/**
	 * 백준 1149 RGB거리 (https://www.acmicpc.net/problem/1149)
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//집 n개
		//빨강, 초록, 파랑
		//최솟값
		//N번 색은 N-1색과 달라야 함
		//N번 색은 N-1, N+1색과 달라야 함
		
		//N개의 줄에 빨강, 초록, 파랑으로 칠하는 비용이 1줄에 한개씩 주어짐
		//ex) 1번줄 : 빨강(26), 초록(40), 파랑(83)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[][] map = new int[n+1][n+1];
		
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//dp : 각 위치와 색상에서 최소값
		int[][] dp = new int[n+1][n+1];
		
		dp[1][1] = map[1][1];
		dp[1][2] = map[1][2];
		dp[1][3] = map[1][3];
		
		for (int i=2; i<=n; i++) {
			//i번쨰 집은 i-1, i+1 색과 달라야 한다.
			dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + map[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + map[i][2];
			dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][3];
		}
		
		int result = Math.min(dp[n][1], Math.min(dp[n][2], dp[n][3]));
		
		System.out.println(result);
	}
}









