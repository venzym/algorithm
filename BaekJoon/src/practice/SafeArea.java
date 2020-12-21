package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeArea {
	private static int n;
	private static int[][] map;
	private static boolean[][] visit;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1][n+1];
		
		StringTokenizer st;
		
		int max = 0;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		int answer = 0;
		for (int height=1; height<=max; height++) {
			int cnt = 0;
			visit = new boolean[n+1][n+1];
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if (!visit[i][j] && map[i][j] >= height) {
						visit[i][j] = true;
						cnt++;
						dfs(height, i, j);
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
		
	}

	private static void dfs(int height, int x, int y) {
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 1 || ny < 1 || nx > n || ny > n) {
				continue;
			}
			
			if (!visit[nx][ny] && map[nx][ny] >= height) {
				visit[nx][ny] = true;
				dfs(height, nx, ny);
			}
		}
		
	}
}







