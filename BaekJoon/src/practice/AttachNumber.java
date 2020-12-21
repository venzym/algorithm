package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AttachNumber {
	private static int n;
	
	private static int dx[] = {0, 1, 0, -1};
	private static int dy[] = {1, 0, -1, 0};
	
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		int[][] map = new int[n+1][n+1];
		boolean[][] visit = new boolean[n+1][n+1];
		
		for (int i=1; i<=n; i++) {
			String[] str = reader.readLine().split("");
			for (int j=0; j<str.length; j++) {
				map[i][j+1] = Integer.parseInt(str[j]);
			}
		}
		
		int sum = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					cnt = 0;
					bfs(i, j, map, visit);
					sum++;
					list.add(cnt);
				}
			}
			
		}
		System.out.println(sum);
		
		Collections.sort(list);
		for (int i : list) {
			System.out.println(i);
		}
		
	}

	private static void bfs(int x, int y, int[][] map, boolean[][] visit) {
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.add(x);
		qy.add(y);
		visit[x][y] = true;
		cnt++;
		
		while (!qx.isEmpty()) {
			
			int num1 = qx.poll();
			int num2 = qy.poll();
			
			for (int i=0; i<dx.length; i++) {
				int nx = num1 + dx[i];
				int ny = num2 + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > n) {
					continue;
				}
				
				if (!visit[nx][ny] && map[nx][ny] == 1) {
					visit[nx][ny] = true;
					bfs(nx, ny, map, visit);
				}
			}
			
		}
		
	}
}









