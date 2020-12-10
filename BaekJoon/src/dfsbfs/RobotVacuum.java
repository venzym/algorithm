package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RobotVacuum {
	/**
	 * 백준 14503 로봇청소기 (https://www.acmicpc.net/problem/14503)
	 */

	private static int n, m, r, c, d;
	private static int[][] map;
	private static boolean[][] visit;

	// 북(0) : -1, 0
	// 동(1) : 0, 1
	// 남(2) : 1, 0
	// 서(3) : 0, -1

	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1 , 0, -1};

	private static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken()); // 가로
		m = Integer.parseInt(st.nextToken()); // 세로

		st = new StringTokenizer(reader.readLine());
		r = Integer.parseInt(st.nextToken()); // 로봇x
		c = Integer.parseInt(st.nextToken()); // 로봇y
		d = Integer.parseInt(st.nextToken()); // 로봇방향

		map = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt++;
		visit[r][c] = true;
		bfs();
		
		System.out.println(cnt);
	}

	private static void bfs() {

		Queue<Vacuum> q = new LinkedList();
		q.add(new Vacuum(r, c, d));

		while (!q.isEmpty()) {

			Vacuum b = q.remove();
			int qx = b.r;
			int qy = b.c;
			int qd = b.d;

			int nextWay = qd;
			boolean flag = false;
			
			for (int i = 0; i < dx.length; i++) {
				nextWay = findWay(nextWay);
				int nx = qx + dx[nextWay];
				int ny = qy + dy[nextWay];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if (!visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					q.add(new Vacuum(nx, ny, nextWay));
					cnt++;
					flag = true;
					break; //이동하면 후진하므로 중지
				}
			}
			
			if (!flag) {
				//이동할 곳이 없다면 뒤로 후진
				nextWay = backWay(qd);
				int nx = qx + dx[nextWay];
				int ny = qy + dy[nextWay];
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					return;
				}
				
				if (map[nx][ny] == 0) {
					//후진은 방향유지한채로 뒤로 이동
					q.add(new Vacuum(nx, ny, qd));
				}
			}
			
//			System.out.println("---------------------");
//			for (int i=0; i<n; i++) {
//				for (int j=0; j<m; j++) {
//					if (visit[i][j]) {
//						System.out.print(1 + " ");
//					} else {
//						System.out.print(0 + " ");
//					}
//				}
//				System.out.println();
//			}

		}

	}

	private static int backWay(int nextWay) {
		
		// 북(0) : -1, 0 -> 남
		// 동(1) : 0, 1 -> 서
		// 남(2) : 1, 0 -> 북
		// 서(3) : 0, -1 -> 동
		
		switch (nextWay) {
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 1;
		}
		
		return 0;
	}

	private static int findWay(int nextWay) {

		// 북(0) : -1, 0 -> 서
		// 동(1) : 0, 1 -> 북
		// 남(2) : 1, 0 -> 동
		// 서(3) : 0, -1 -> 남

		switch (nextWay) {
		case 0:
			return 3;
		case 1:
			return 0;
		case 2:
			return 1;
		case 3:
			return 2;
		}

		return 0;
	}
}

class Vacuum {
	int r, c, d;

	Vacuum(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}
}
