package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayCirculation {
	/**
	 * 백준 16926 배열 돌리기 1 (https://www.acmicpc.net/problem/16926)
	 */

	private static int n, m, r;
	private static int[][] map;
	
	private static int[] dx = {0, 1, 0, -1};//우상좌하
	private static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//총 돌려야 하는 네모 개수
		int num = Math.min(n, m)/2;
		
		for (int i=0; i<r; i++) {
			circulate(num);
		}
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}//main

	private static void circulate(int num) {
		
		for (int i=1; i<=num; i++) {
			//네모들의 왼쪽 맨위의 좌표는 1,1 || 2,2 || 3,3 || ...
			int x = i;
			int y = i;
			int temp = map[x][y]; //첫번째 값을 담아놓고 연산 후에 넣어준다.
			
			int index = 0;
			
			while (index < 4) {
				
				int nx = x + dx[index];
				int ny = y + dy[index];
				
				if (nx < i || ny < i || nx > n-i+1 || ny > m-i+1) {
					index++;
				} else {
					map[x][y] = map[nx][ny];
					
					x = nx;
					y = ny;
				}
				
			}//while
			map[i+1][i] = temp;
		}//for
		
	}//circulate()

}




