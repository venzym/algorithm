package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Observation {
	/**
	 * 백준 15683 감시 (https://www.acmicpc.net/problem/15683)
	 */
	private static int n, m;
	private static int[][] map;
	private static ArrayList<CCTV> cctvList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					//cctv
					cctvList.add(new CCTV(map[i][j], i, j));
				}
			}
		}
		
		
		
		dfs(0, map);
		
	}
	
	private static void dfs(int count, int[][] temp) {
		int[][] visit = new int[n+1][m+1];
		
		if (count == cctvList.size()) {
			
		} else {
			CCTV cctv = cctvList.get(count);
			
			int num = cctv.num;
			int x = cctv.x;
			int y = cctv.y;
			
			switch (num) {
			case 1: //1번 - 4방향
				for (int i=0; i<4; i++) {
					for (int j=1; j<=n; j++) {
						//기존 배열 복사하기
						visit[i] = Arrays.copyOf(temp[i], m);
					}
					find(visit, y, x, i);
					dfs(count+1, visit);
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}
		
	}//dfs

	private static void find(int[][] visit, int x, int y, int direction) {
		
		switch (direction) {
		case 0://서
			for (int i=y; i>=0; i--) {
				if (map[x][i] == 6) {
					break;
				}
				visit[x][i] = 7;//탐색
			}
			break;
		case 1://북
			for (int i=x; i>=0; i--) {
				if (map[i][y] == 6) {
					break;
				}
				visit[i][y] = 7;
			}
			break;
		case 2://동
			for (int i=y; i<m; i++) {
				if (map[x][i] == 6) {
					break;
				}
				visit[x][i] = 7;
			}
			break;
		case 3://남
			for (int i=x; i<n; i++) {
				if (map[i][y] == 6) {
					break;
				}
				visit[i][y] = 7;
			}
			break;
		}
		
	}//find

	static class CCTV {
		int num, x, y;
		public CCTV(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}//CCTV
}









