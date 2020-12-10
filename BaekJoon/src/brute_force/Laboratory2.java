package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory2 {
	/**
	 * 백준 17141 연구소2 (https://www.acmicpc.net/problem/17141)
	 */
	private static int n, m;
	private static int[][] map;
	private static boolean[] visit;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int result = Integer.MAX_VALUE;
	private static int val;
	
	private static ArrayList<Virus> virusList = new ArrayList();
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new Virus(i, j));
					map[i][j] = 0;
				}
			}
		}
		
		visit = new boolean[virusList.size()];
		
		dfs(0,0);
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result-1);
		}
		
	}//main
	
	private static void dfs(int start, int count) {
		
		if (count >= m) {
			
			//바이러스 퍼뜨리기
			spreadVirus();
			
			//최소시간 비교
			result = Math.min(result, val);
			
		} else {
			
			for (int i=start; i<virusList.size(); i++) {
				if (!visit[i]) {
					visit[i] = true;
					dfs(start+1, count+1);
					visit[i] = false;
				}
			}
			
		}
		
	}


	private static void spreadVirus() {

		Queue<Virus> q = new LinkedList();
		
		int[][] temp = new int[n+1][n+1];
		int[][] time = new int[n+1][n+1];
		
		for (int i=1; i<=n; i++) {
			temp[i] = map[i].clone();
		}
		
		//방문처리 한 바이러스에 진짜 바이러스
		for (int i=0; i<virusList.size(); i++) {
			if (visit[i]) {
				map[virusList.get(i).x][virusList.get(i).y] = 0;
				time[virusList.get(i).x][virusList.get(i).y] = 1;
				q.add(virusList.get(i));
			}
		}
		
		val = 0;
		
		while (!q.isEmpty()) {
			
			Virus virus = q.remove();
			int qx = virus.x;
			int qy = virus.y;
			int qt = time[qx][qy];
			
			val = Math.max(val, qt);
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > n || temp[nx][ny] != 0 || time[nx][ny] != 0) {
					continue;
				}
				
				//temp가 0이상이고, time이 0일 때
				if (temp[nx][ny] == 0 && time[nx][ny] == 0) {
					time[nx][ny] = qt + 1;
					temp[nx][ny] = 2;
					q.add(new Virus(nx, ny));
				}
			}
			
		}//while
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (temp[i][j] == 0	&& time[i][j] == 0) {
					val = Integer.MAX_VALUE;
					return;
				}
			}
		}
		
		
	}

	static class Virus {
		int x, y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}






