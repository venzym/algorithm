package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
	private static int n, m;
	private static int[][] map;
	private static int[][] temp;
	
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, -1, 0, 1};
	
	private static Queue<SubTomato> q = new LinkedList();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//하루가 지나면 인접토마토는 익는다 (x, y 계산)
		//토마토가 모두 익는데 걸리는 요일 (배열에 0없을때까지 걸리는 count)
		
		//1 : 익은 토마토
		//0 : 익지 않은 토마토
		//-1 : 토마토가 들어있지 않은 칸 (x, y 예외처리 추가)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = reader.readLine().split(" ");
		
		m = Integer.parseInt(nm[0]); //가로
		n = Integer.parseInt(nm[1]); //세로
		
		temp = new int[n+1][m+1];//처음 입력값, 확산 표시, 나중에 0있는지 판별
		map = new int[n+1][m+1];//각 행렬별 확산시간
		
		for (int i=1; i<=n; i++) {
			String[] input = reader.readLine().split(" ");
			for (int j=1; j<=m; j++) {
				temp[i][j] = Integer.parseInt(input[j-1]);
				map[i][j] = -1;
				
				if (temp[i][j] == 1) {
					map[i][j] = 0;
					//1이 여러개 있으면 동시에 +해줘야 하기 때문에 큐에 다 넣은 후에 연산해야 한다.
					q.add(new SubTomato(i, j));
				}
			}
		}
		
		bfs();
		
		int zeroCnt = 0;
		int second = 0;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (temp[i][j] == 0) zeroCnt++;
				
				second = Math.max(second, map[i][j]);
				
				//System.out.print(temp[i][j] + " ");
			}
			//System.out.println();
		}
		
		if (zeroCnt > 0) {
			System.out.print("-1");
		} else {
			System.out.print(second);
		}
		
		
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			SubTomato num = q.remove();
			int qx = num.x;
			int qy = num.y;
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				//행렬 범위 밖이거나 1, -1일때 
				if (nx < 1 || ny < 1 || nx > n || ny > m) {
					continue;
				}
				
				//방문하지 않았고, 토마토가 존재할 때
				if (temp[nx][ny] == 0 && map[nx][ny] == -1) {
					temp[nx][ny] = 1;
					map[nx][ny] = map[qx][qy]+1;
					q.add(new SubTomato(nx, ny));
				}
			}
			
//			for (int i=1; i<=n; i++) {
//				for (int j=1; j<=m; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("--------------------");
		}
		
	}

//	private static void dfs(int x, int y) {
//
//		//방문처리
//		visit[x][y] = true;
//		
//		for (int i=0; i<dx.length; i++) {
//			int nx = x + dx[i];
//			int ny = y + dy[i];
//			
//			//행렬 범위 밖이거나 1, -1일때 
//			if (nx < 1 || ny < 1 || nx > n || ny > m || map[nx][ny] == 1 || map[nx][ny] == -1) {
//				continue;
//			}
//			
//			if (!visit[nx][ny]) {
//				visit[nx][ny] = true;
//				map[nx][ny] = map[x][y]+1;
//				dfs(nx,ny);
//			}
//			
//		}
//		
//	}
}

class SubTomato {
	int x;
	int y;
	
	SubTomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}







