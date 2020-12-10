package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato2 {
	private static int m,n,h;
	private static int[][][] map;
	private static int[][][] time;
	
	
	//위, 아래, 앞, 뒤, 오른쪽, 왼쪽
	private static int[] dz = {1, -1, 0, 0, 0, 0};
	private static int[] dx = {0, 0, 1, -1, 0, 0};
	private static int[] dy = {0, 0, 0, 0, 1, -1};
	
	private static Queue<SubTomato2> q = new LinkedList<SubTomato2>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h+1][n+1][m+1];
		time = new int[h+1][n+1][m+1];
		
		int zeroCnt = 0;
		for (int i=1; i<=h; i++) {
			//높이
	         for (int j=1; j<=n; j++) {
	        	 //세로
	            st = new StringTokenizer(reader.readLine());
	            for (int k=1; k<=m; k++) {
	            	//가로
	            	map[i][j][k] = Integer.parseInt(st.nextToken());
					
					time[i][j][k] = -1;
					
					if (map[i][j][k] == 0) zeroCnt++;
					
					if (map[i][j][k] == 1) {
						time[i][j][k] = 0;
						q.add(new SubTomato2(i, j, k));
					}
				}
			}
		}
		
		if (zeroCnt == 0) {
			System.out.print("0");
			return;
		}
		
		
		bfs();
		
		zeroCnt = 0;
		int second = 0;
		for (int i=1; i<=h; i++) {
			for (int j=1; j<=n; j++) {
				for (int k=1; k<=m; k++) {
					if (map[i][j][k] == 0) zeroCnt++;
					
					second = Math.max(second, time[i][j][k]);
				}
			}
		}
		
		if (zeroCnt > 0) {
			System.out.print("-1");
		} else {
			System.out.print(second);
		}
		
	}

	private static void bfs() {
		
		while (!q.isEmpty()) {
			SubTomato2 st = q.remove();
			int qz = st.z;
			int qx = st.x;
			int qy = st.y;
			
			for (int i=0; i<dx.length; i++) {
				int nz = qz + dz[i];
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nz < 1 || nx < 1 || ny < 1 || nz > h || nx > n || ny > m) {
					continue;
				}
				
				if (map[nz][nx][ny] == 0 && time[nz][nx][ny] == -1) {
					map[nz][nx][ny] = 1;
					time[nz][nx][ny] = time[qz][qx][qy] + 1;
					q.add(new SubTomato2(nz, nx, ny));
				}
			}
		}
		
	}
}	

class SubTomato2 {
	int z, x, y;
	public SubTomato2(int z, int x, int y) {
		this.z = z;
		this.x = x;
		this.y = y;
	}
}









