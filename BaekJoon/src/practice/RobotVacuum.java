package practice;

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
	private static int[] dy = {0, 1, 0, -1};
	
	private static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 가로
		m = Integer.parseInt(st.nextToken()); // 세로

		st = new StringTokenizer(reader.readLine());
		r = Integer.parseInt(st.nextToken())+1; // 로봇x
		c = Integer.parseInt(st.nextToken())+1; // 로봇y
		d = Integer.parseInt(st.nextToken()); // 로봇방향
		
		map = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt++;
		bfs();
		
		System.out.println(cnt);
		
	}

	private static void bfs() {
		
		Queue<Vacuum> q = new LinkedList();
		q.add(new Vacuum(r, c, d));
		visit[r][c] = true;
		
		while (!q.isEmpty()) {
			
			Vacuum vc = q.remove();
			
			int qx = vc.x;
			int qy = vc.y;
			int qd = vc.d;
			
			int nextWay = qd;
			boolean flag = false;
			
			for (int i=0; i<dx.length; i++) {
				nextWay = findLeft(nextWay);
				int nx = qx + dx[nextWay];
				int ny = qy + dy[nextWay];
				
				if (nx < 1 || ny < 1 || nx > n || ny > m) {
					continue;
				}
				
				if (!visit[nx][ny] && map[nx][ny] == 0) {
					visit[nx][ny] = true;
					cnt++;
					flag = true;
					q.add(new Vacuum(nx, ny, nextWay));
					break; //이동하면 후진하므로 중지
				}
			}
			
			if (!flag) {
				//이동할 곳이 없다면 뒤로 후진
				nextWay = backWay(nextWay);
				int nx = qx + dx[nextWay];
				int ny = qy + dy[nextWay];
				
				if (nx < 1 || ny < 1 || nx > n || ny > m) {
					return;
				}
				
				if (map[nx][ny] == 0) {
					//후진은 방향유지한채로 뒤로 이동
					q.add(new Vacuum(nx, ny, qd));
				}
			}
			
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

	private static int findLeft(int nextWay) {
		
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
	int x, y, d;
	Vacuum (int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}




