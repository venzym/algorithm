package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OrganicCabbage {
	private static int n, m, k;
	private static int[][] map;
	private static boolean[][] visit;
	
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i=0; i<num; i++) {

			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			
			map = new int[n+1][m+1];
			visit = new boolean[n+1][m+1];
			
			for (int j=0; j<k; j++) {
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				
				map[a1+1][a2+1] = 1;
			}
			
			int cnt = 0;
			
			for (int j=1; j<=n; j++) {
				for (int o=1; o<=m; o++) {
					if (!visit[j][o] && map[j][o] == 1) {
						bfs(j, o);
						cnt++;
					}
				}
			}
			result.add(cnt);
		}
		
		for (int i : result) {
			System.out.println(i);
		}
		
	}

	private static void bfs(int x, int y) {
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		qx.add(x);
		qy.add(y);
		visit[x][y] = true;
		
		while (!qx.isEmpty()) {
			
			int num1 = qx.poll();
			int num2 = qy.poll();
			
			for (int i=0; i<dx.length; i++) {
				int nx = num1 + dx[i];
				int ny = num2 + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > m) {
					continue;
				}
				
				if (!visit[nx][ny] && map[nx][ny] == 1) {
					visit[nx][ny] = true;
					qx.add(nx);
					qy.add(ny);
				}
			}
			
		}
		
	}
}












