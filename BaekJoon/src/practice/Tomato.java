package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
	private static int n,m;
	private static int[][] map;//확산 초가 반영된 행렬
	private static int[][] temp;//확산 상태가 반영된 행렬
	
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, -1, 0, 1};
	
	private static Queue<SubTomato> q = new LinkedList();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split(" ");
		
		n = Integer.parseInt(input[1]);
		m = Integer.parseInt(input[0]);
		
		map = new int[n+1][m+1];
		temp = new int[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			input = reader.readLine().split(" ");
			for (int j=1; j<=m; j++) {
				temp[i][j] = Integer.parseInt(input[j-1]);
				
				map[i][j] = -1;
				
				if (temp[i][j] == 1) {
					map[i][j] = 0;
					q.add(new SubTomato(i, j));
				}
			}
		}
		
		bfs();
		
		//모든 토마토 익은 상태 - 모두 1 -> 0출력
		//토마토 익지 못하는 상황 - 0이 한개라도 존재 -> -1출력
		
		int zeroCnt = 0;
		int second = 0;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (temp[i][j] == 0) zeroCnt++;
				
				second = Math.max(second, map[i][j]);
			}
		}
		
		if (zeroCnt > 0) {
			System.out.print(-1);
		} else {
			System.out.print(second);
		}
	}

	private static void bfs() {
		
		while (!q.isEmpty()) {
			SubTomato st = q.remove();
			int x = st.x;
			int y = st.y;
			
			for (int i=0; i<dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > m) {
					continue;
				}
				
				if (map[nx][ny] == -1 && temp[nx][ny] == 0) {
					temp[nx][ny] = 1;
					map[nx][ny] = map[x][y]+1;
					q.add(new SubTomato(nx, ny));
				}
			}
		}
		
	}
}

class SubTomato {
	int x;
	int y;
	
	SubTomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}






