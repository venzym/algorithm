package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark2 {
	private static int n;
	private static int[][] map;
	private static int[][] time;
	
	private static int sharkX, sharkY;
	private static int sharkSize = 2;
	
	private static int minX, minY, minD;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1][n+1];
		time = new int[n+1][n+1];
		
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
				}
			}
		}
		
		int result = 0;
		int eatCnt = 0;
		while (true) {
			minX = minY = minD = Integer.MAX_VALUE;
			
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					time[i][j] = -1;
				}
			}
			
			bfs();
			
			if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				result += minD;
				eatCnt++;
				
				if (sharkSize == eatCnt) {
					sharkSize++;
					eatCnt = 0;
				}
				
				map[minX][minY] = 0;
				sharkX = minX;
				sharkY = minY;
			} else {
				break;
			}
			
		}//while
		
		System.out.println(result);
		
	}//main

	private static void bfs() {
		
		Queue<Shark> q = new LinkedList<Shark>();
		q.add(new Shark(sharkX, sharkY));
		map[sharkX][sharkY] = 0;
		time[sharkX][sharkY] = 0;
		
		while (!q.isEmpty()) {
			
			Shark shark = q.remove();
			int qx = shark.x;
			int qy = shark.y;
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] > sharkSize || time[nx][ny] != -1) {
					continue;
				}
				
				time[nx][ny] = time[qx][qy] + 1;
				
				if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
					if (time[nx][ny] < minD) {
						minX = nx;
						minY = ny;
						minD = time[nx][ny];
					} else if (time[nx][ny] == minD) {
						if (nx < minX) {
							minX = nx;
							minY = ny;
						} else if (nx == minX) {
							if (ny < minY) {
								minX = nx;
								minY = ny;
							}
						}
					}
				}
				q.add(new Shark(nx, ny));
			}
		}
		
	}//bfs
}










