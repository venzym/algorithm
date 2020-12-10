package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tetromino {
	private static int n, m;
	private static int[][] map;
	private static boolean[][] visit;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int max = 0;
	
	public static void main(String[] args) throws IOException {

		//겹치면 x
		//도형 모두 연결
		//변끼리 연결
		//-> dfs
		
		//정사각형 4개를 이어 붙인 폴리오미노
		//4개!!
		
		//n*m 
		
		//수들의 최대 합
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				visit[i][j] = true;
				dfs(i,j,map[i][j],1);
				checkTetro(i,j);
				visit[i][j] = false;
			}
		}
		
		System.out.println(max);
		
	}

	private static void checkTetro(int x, int y) {
		
		int sum = map[x][y];
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 1 || ny < 1 || nx > n || ny > m) {
				continue;
			}
			
			sum += map[nx][ny];
			cnt++;
			min = Math.min(min, map[nx][ny]);
		}
		
		if (cnt == 4) {
			sum -= min;
		}
		
		max = Math.max(max, sum);
		
	}//checkTetro

	private static void dfs(int x, int y, int num, int count) {
		
		if (count >= 4) {
			max = Math.max(max, num);
		} else {
			
			for (int i=0; i<dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > m) {
					continue;
				}
				
				if (!visit[nx][ny]) {
					visit[nx][ny] = true;
					dfs(nx, ny, num + map[nx][ny], count+1);
					visit[nx][ny] = false;
				}
			}
			
		}
		
	}

	static class Tetro {
		int x, y, count;
		public Tetro(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
}












