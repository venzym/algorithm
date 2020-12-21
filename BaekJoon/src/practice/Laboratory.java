package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory {
	private static int n,m;
	private static int[][] map;
	private static int[][] temp;
	private static boolean[][] visit;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static ArrayList<Virus> virusLoc = new ArrayList();
	private static Queue<Virus> virusQ = new LinkedList();
	
	private static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		temp = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusLoc.add(new Virus(i, j));
				}
			}
		}
		
		dfs(0);
		
		System.out.println(result);
		
	}

	private static void dfs(int count) {
		
		if (count == 3) {
			 
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=m; j++) {
					temp[i][j] = map[i][j];
				}
			}
				
			for (Virus v : virusLoc) {
				virusQ.add(new Virus(v.x, v.y));
			}
			
			virus();
			
			result = Math.max(result, zeroCnt());
			
		} else {
			
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=m; j++) {
					if (map[i][j] == 0 && !visit[i][j]) {
						visit[i][j] = true;
						map[i][j] = 1;
						dfs(count+1);
						map[i][j] = 0;
						visit[i][j] = false;
					}
				}
			}
			
		}
		
		
	}

	private static int zeroCnt() {
		
		int sum = 0;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (temp[i][j] == 0) {
					sum++;
				}
			}
		}
		return sum;
	}

	private static void virus() {
		//바이러스 퍼지기
		
		while (!virusQ.isEmpty()) {
			Virus v = virusQ.remove();
			
			int qx = v.x;
			int qy = v.y;
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > m || temp[nx][ny] != 0) {
					continue;
				}
				
				if (temp[nx][ny] == 0) {
					temp[nx][ny] = 2;
					virusQ.add(new Virus(nx, ny));
				}
			}
		}
		
		
	}//virus
	
	static class Virus {
		int x, y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}











