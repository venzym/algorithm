package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ExploreMaze {
	private static int n, m;
	private static int[][] map;
	private static int[][] result;
	private static boolean[][] visit;

	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		// 1 - 이동 가능
		// 0 - 이동 불가능
		// 1,1에서 출발 -> N,M까지 이동
		// 최소칸 수 - bfs
		// 인접한 칸만 이동 가능

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] input = reader.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		map = new int[n + 1][m + 1];
		result = new int[n + 1][m + 1];
		visit = new boolean[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			input = reader.readLine().split("");
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(input[j - 1]);
			}
		}
		
		
		bfs(1, 1);
		
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				System.out.print(result[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.print(result[n][m]);
			
	}

	private static void bfs(int line, int row) {

		Queue<Miro> q = new LinkedList<Miro>();
		visit[line][row] = true;
		result[line][row] = 1;
		q.add(new Miro(line, row));

		while (!q.isEmpty()) {
			Miro miro = q.poll();
			int x = miro.x;
			int y = miro.y;

			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 1 || ny < 1 || nx > n || ny > m) {
					continue;
				}

				if (!visit[nx][ny] && map[nx][ny] == 1) {
					visit[nx][ny] = true;
					result[nx][ny] = result[x][y] + 1;
					q.add(new Miro(nx, ny));
				}
			}
		}

	}
}

class Miro {
	int x, y;

	Miro(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
