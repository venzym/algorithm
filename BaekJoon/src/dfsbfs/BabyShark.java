package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark {
	
	private static int n;
	private static int[][] map;
	private static int[][] time;
	private static boolean[][] visit;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int sharkX = 0;
	private static int sharkY = 0;
	private static int sharkSize = 2;
	
	private static int minX, minY, minD;
	private static int eatCnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1][n+1];
		time = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		StringTokenizer st;
		int fishCnt = 0;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
				} else if (map[i][j] > 0 && map[i][j] < 9) {
					fishCnt++;
				}
				
			}
		}
		
		int result = 0;
		if (fishCnt == 0) {
			//물고기 없을 때
			result = 0;
		} else if (fishCnt == 1) {
			//물고기 1마리 있을 때
			
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if (map[i][j] > 0 && map[i][j] < 9) {
						result = singleFish(i,j,0);
					}
				}
			}
			
		} else {
			//물고기 여러마리 있을 때
			
			for (int fish=0; fish<fishCnt; fish++) {
				
				minX = Integer.MAX_VALUE; 
				minY = Integer.MAX_VALUE;
				minD = Integer.MAX_VALUE;
				
				for (int i=1; i<=n; i++) {
					for (int j=1; j<=n; j++) {
						time[i][j] = -1;
					}
				}
				
				bfs(sharkX, sharkY);
				
				if (minX != Integer.MAX_VALUE && minY != Integer.MIN_VALUE) {
					result += minD;
					eatCnt++;
					
					if (eatCnt == sharkSize) {
						sharkSize++;
						eatCnt = 0;
					}
					
					map[minX][minY] = 0;
					sharkX = minX;
					sharkY = minY;
				} //if
				
			}//while
			
		}
		
		System.out.println(result);
		
	}//main

	private static void bfs(int x, int y) {
		
		Queue<Shark> q = new LinkedList<Shark>();
		q.add(new Shark(x, y));
		map[x][y] = 0;
		time[x][y] = 0;
		
		while (!q.isEmpty()) {
			
			Shark shark = q.remove();
			
			int qx = shark.x;
			int qy = shark.y;
			
			System.out.println("qx :: " + qx + " , qy :: " + qy);
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] > sharkSize || time[nx][ny] != -1) {
					continue;
				}
				
				time[nx][ny] = time[qx][qy] + 1;
				
				//동일한 크기는 그냥 지나가기만 하기 때문에 +1만 하면 됨.
				if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
					//물고기 존재하고, 상어보다 작을 때
					if (time[nx][ny] < minD) {
						minX = nx;
						minY = ny;
						minD = time[nx][ny];
					} else if (time[nx][ny] == minD) {
						//동일한 거리가 여러개일 때
						
						if (nx < minX) {
							//맨 위쪽부터 먹기
							minX = nx;
							minY = ny;
						} else if (nx == minX) {
							//맨 위가 여러개일 때 맨 왼쪽부터 먹기
							if (ny < minY) {
								minX = nx;
								minY = ny;
							}
						}
						
					}
				}//if

				q.add(new Shark(nx, ny));
			}
			
		}//while
		
	}

	private static int singleFish(int x, int y, int time) {
		
		Queue<Shark> q = new LinkedList<Shark>();
		q.add(new Shark(sharkX, sharkY, time));
		visit[sharkX][sharkY] = true;
		
		int cnt = 0;
		while (!q.isEmpty()) {
			
			Shark shark = q.remove();
			
			int qx = shark.x;
			int qy = shark.y;
			int qTime = shark.time;
			
			if (qx == x && qy == y) {
				cnt = qTime;
				break;
			}
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] > sharkSize) {
					continue;
				}
				
				if (!visit[nx][ny] && map[nx][ny] <= sharkSize) {
					visit[nx][ny] = true;
					if (map[nx][ny] < sharkSize) {
						map[nx][ny] = 0;
					}
					q.add(new Shark(nx, ny, qTime + 1));
				}
			}
			
		}
		
		return cnt;
		
	}//singleFish
	
}

class Shark {
	int x, y, time;
	
	public Shark(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Shark(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}











