package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Banner {
	/**
	 * 백준 14716 현수막 (https://www.acmicpc.net/problem/14716)
	 */
	private static int m, n;
	private static int[][] map;
	private static boolean[][] visit;

	private static int[] dx = { -1, 0, 1, 0, -1, 1, 1, -1 };// 상,우,좌,하,우상,우하,좌하,좌상
	private static int[] dy = { 0, 1, 0, -1, 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException {

		// 글자가 몇개
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[m + 1][n + 1];
		visit = new boolean[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					result++;
					//bfs(i, j);
					dfs(i, j);
				}
			}
		}
		
		System.out.println(result);

	}

	private static void dfs(int x, int y) {

		visit[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 1 || ny < 1 || nx > m || ny > n) {
				continue;
			}
			
			if (!visit[nx][ny] && map[nx][ny] == 1) {
				dfs(nx,ny);
			}
		}
		
	}//dfs

	private static void bfs(int x, int y) {

		Queue<Letter> q = new LinkedList<>();
		q.add(new Letter(x, y));
		visit[x][y] = true;

		while (!q.isEmpty()) {

			Letter l = q.remove();
			int qx = l.x;
			int qy = l.y;

			for (int i = 0; i < dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];

				if (nx < 1 || ny < 1 || nx > m || ny > n) {
					continue;
				}

				if (!visit[nx][ny] && map[nx][ny] == 1) {
					visit[nx][ny] = true;
					q.add(new Letter(nx, ny));
				}

			} // while

		} // dfs

	}
	static class Letter {
		int x, y;
		
		public Letter(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}// Letter
}

