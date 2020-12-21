package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark {

	private static int n;
	private static int[][] map;
	private static boolean[][] visit;
	private static int[][] time;
	
	private static int sharkX = 0;
	private static int sharkY = 0;
	private static int sharkSize = 2;
	private static int eatCnt = 0;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int minX, minY, minD;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1][n+1];
		time = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		StringTokenizer st;
		int fishCnt = 0;
		int fishX = 0;
		int fishY = 0;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
				} else if (map[i][j] > 0 && map[i][j] < sharkSize) {
					fishCnt++;
					fishX = i;
					fishY = j;
				}
			}
		}
		
		int result = 0;
		if (fishCnt == 0) {
			result = 0;
		} else if (fishCnt == 1) {
			result = singleFish(fishX, fishY);
		} else {
			
			while (true) {
				
				minX = Integer.MAX_VALUE;
				minY = Integer.MAX_VALUE;
				minD = Integer.MAX_VALUE;
				
				for (int i=1; i<=n; i++) {
					for (int j=1; j<=n; j++) {
						time[i][j] = -1;
					}
				}
				
				bfs();
				
				if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
					result += minD;
					eatCnt++;
					
					if (eatCnt == sharkSize) {
						sharkSize++;
						eatCnt = 0;
					}
					
					map[minX][minY] = 0;//잡아먹기
					sharkX = minX;
					sharkY = minY;
				} else {
					break;
				}
				
			}
			
			
		}
		
		System.out.println(result);
		
	}

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
				
				
				//크기가 같은 친구는 그냥 통과
				if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
					
					if (time[nx][ny] < minD) {
						//첫방문
						minX = nx;
						minY = ny;
						minD = time[nx][ny];
					} else if (time[nx][ny] == minD) {
						//여러번 방문
						if (nx < minX) {
							//nx가 더 위쪽이면
							minX = nx;
							minY = ny;
						} else if (nx == minX) {
							if (ny < minY) {
								minX = nx;
								minY = ny;
							}
						}
					}
				}//if
				q.add(new Shark(nx, ny));
			}//for
		}//while
	}//bfs

	private static int singleFish(int x, int y) {
		
		Queue<Shark> q = new LinkedList<Shark>();
		q.add(new Shark(sharkX, sharkY, 0));
		visit[sharkX][sharkY] = true;
		
		while (!q.isEmpty()) {
			
			Shark shark = q.remove();
			int qx = shark.x;
			int qy = shark.y;
			int qd = shark.dir;
			
			if (qx == x && qy == y) {
				return qd;
			}
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] > sharkSize) {
					continue;
				}
				
				if (!visit[nx][ny] && map[nx][ny] <= sharkSize) {
					visit[nx][ny] = true;
					q.add(new Shark(nx, ny, qd + 1));
				}
				
			}
			
		}
		
		return 0;
		
	}
	
}


class Shark {
	int x, y, dir;
	
	public Shark(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Shark(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}



