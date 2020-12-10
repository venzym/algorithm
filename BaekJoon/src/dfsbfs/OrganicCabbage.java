package dfsbfs;

import java.util.Scanner;

public class OrganicCabbage {
	private static int num, m, n, k;
	
	private static boolean[][] visit;
	private static int[][] map;
	
	private static int dx[] = {0, 1, -1, 0};
	private static int dy[] = {1, 0, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		for (int i=0; i<num; i++) {
			
			m = sc.nextInt(); //세로
			n = sc.nextInt(); //가로
			k = sc.nextInt(); //심어져 있는 위치의 개수
			
			visit = new boolean[m+1][n+1];
			
			map = new int[m+1][n+1];
			
			int sum = 0;

			for (int j=0; j<k; j++) {
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				
				map[a1+1][a2+1] = 1;
			}
			
			for (int j=1; j<=m; j++) {
				for (int o=1; o<=n; o++) {
					if (!visit[j][o] && map[j][o] == 1) {
//						dfs(0, j, o);
						//System.out.println("j :: " + j + " , o :: " + o);
						dfs(j, o);
						sum++;
					}
				}
			}
			
			
			System.out.println(sum);
		}
		
		
		
	}

	private static void dfs(int line, int row) {

		for (int i=0; i<dx.length; i++) {
			int nx = row + dx[i];
			int ny = line + dy[i];
			
			if (ny < 1 || nx < 1 || nx > n || ny > m) {
				//범위 넘어갈 때 패스
				continue;
			}
			
			if (!visit[ny][nx] && map[ny][nx] == 1) {
				//방문하지 않았고, 1인 경우 탐색
				visit[ny][nx] = true;
				dfs(ny, nx);
			}
		}
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
//	private static void dfs(int cnt, int line, int row) {
	
//	if (cnt == 1) {
//		//주변 개수 파악
//		distinct(line, row);
//	} else {
//		
//		for (int i=line; i<=m; i++) {
//			for (int j=row; j<=n; j++) {
//				if (!visit[i][j] && map[i][j] == 1) {
//					visit[i][j] = true;
//					dfs(cnt+1, i, j);
//				}
//			}
//		}
//		
//	}
	
	
	
	
	
//	private static void distinct(int line, int row) {
//		
//		//상하좌우 1있는지 찾는다.
//		//있으면 주변을 다시 탐색한다.
//		for (int i=0; i<dx.length; i++) {
//			int ny = line + dy[i];
//			int nx = row + dx[i];
//			
//			//상하좌우가 1보다 작거나 행렬보다 크면 넘긴다.
//			if (ny < 1 || nx < 1 || ny > m || nx > n) {
//				continue;
//			}
//		
//			if (map[ny][nx] == 1) {
//				//visit[ny][nx] = true;
//				if (sum == 0) {
//					sum++;
//				}
//				dfs(ny, nx);
//			} 
//			
//			
//		}
//		
//	}
//}











