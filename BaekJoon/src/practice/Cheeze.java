package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Cheeze {
	private static int n,m;
	private static int[][] map;
	private static boolean[][] visit;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static ArrayList<Melt> list = new ArrayList<Melt>();
	
	public static void main(String[] args) throws IOException {
		
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
		
		//-1로 다 녹는 처리
		outerAir(1,1);
		
		int result = 0;
		while (true) {
			
			//0으로 녹은 치즈를 -1로 변환
			if (result > 0) {
				for (int i=0; i<list.size(); i++) {
					int x = list.get(i).x;
					int y = list.get(i).y;
					
					melting(x,y);
				}
				
			}
			
			list = new ArrayList<Melt>();
			
			boolean flag = false;
			
			//외부공기와 2개 인접된 부분 찾기
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=m; j++) {
					if (!visit[i][j] && map[i][j] == 1 && airCnt(i,j)) {
						//0으로 녹는 처리
						flag = true;
					}
				}
			}
			
			if (!flag) {
				break;
			} 
			
			result++;
			
		}
		
		System.out.println(result);
		
	}

	private static void melting(int x, int y) {
		
		map[x][y] = -1;
		visit[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 1 || ny < 1 || nx > n || ny > m) {
				continue;
			}
			
			if (!visit[nx][ny] && map[nx][ny] != 1) {
				melting(nx,ny);
			}
		}
		
		
	}

	private static boolean airCnt(int x, int y) {
		
		int cnt = 0;
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 1 || ny < 1 || nx > n || ny > m || map[nx][ny] == 1) {
				continue;
			}
			
			if (map[nx][ny] == -1) {
				cnt++;
			}
		}
		
		if (cnt >= 2) {
			map[x][y] = 0;
			list.add(new Melt(x, y));
			return true;
		}
		return false;
	}

	private static void outerAir(int x, int y) {
		
		map[x][y] = -1;
		visit[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 1 || ny < 1 || nx > n || ny > m || map[nx][ny] == 1) {
				continue;
			}
			
			if (map[nx][ny] == 0) {
				outerAir(nx, ny);
			}
		}
		
	}
}

class Melt {
	int x, y;
	
	public Melt(int x, int y) {
		this.x = x;
		this.y = y;
	}
}









