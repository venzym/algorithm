package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartTaxi2 {

	private static int n, m, fuel;
	private static int[][] map; //벽&태울승객
	private static int[][] time; //시간&연료
	private static boolean[][] visit; //방문

	private static int minX, minY, minD; //x,y,연료
	private static int taxiX, taxiY; //택시위치
	private static int man; //승객

	private static int[] dx = { -1, 0, 1, 0 }; 
	private static int[] dy = { 0, 1, 0, -1 }; 
	
	//승객들의 도착지
	private static HashMap<Integer, Taxi> destination = new HashMap<Integer, Taxi>();

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		time = new int[n + 1][n + 1];
		visit = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = 401;// 벽
			}
		}

		String[] input = reader.readLine().split(" ");
		taxiX = Integer.parseInt(input[0]);
		taxiY = Integer.parseInt(input[1]);

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(reader.readLine());

			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int departX = Integer.parseInt(st.nextToken());
			int departY = Integer.parseInt(st.nextToken());

			map[startX][startY] = i; // 승객 위치
			destination.put(i, new Taxi(departX, departY)); // 목적지 위치
		}
		
		man = 0;
		for (int i=1; i<=m; i++) {
			
			minX = minY = minD = Integer.MAX_VALUE;
			
			//방문 초기화
			visit = new boolean[n + 1][n + 1];
			
			//시간 초기화
			for (int j=1; j<=n; j++) {
				for (int k=1; k<=n; k++) {
					time[j][k] = -1;
				}
			}
			
			//가까운 손님 찾기
			bfs();
			
			if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
//				System.out.println("손님 - " + "minX ::  " + minX + " , minY :: " + minY + " , minD :: " + minD);
				fuel -= minD;// 손님 태우러 이동(연료 소모)

				//손님 찾아가다 연료 떨어진 경우
				if (fuel < 0) {
					fuel = -1;
					break;
				}
				
				
				// 손님 위치로 갱신
				taxiX = minX;
				taxiY = minY;

				//시간 초기화
				for (int j = 1; j <= n; j++) {
					for (int k = 1; k <= n; k++) {
						time[j][k] = -1;
					}
				}
				
				visit = new boolean[n + 1][n + 1];
				
				//손님 목적지 배달
				//목적지 도달했을 때
				if (delivery()) {
					if (fuel < 0) {
						fuel = -1;
						break;
					}
					
					fuel += 2*minD;//연료 2배 충전
					
					//손님 내려다준 곳으로 위치 변경
					taxiX = minX;
					taxiY = minY;
				} else {
					//목적지 도달 실패했을 때
					fuel = -1;
					break;
				}
				
			} else {
				//가까운 승객을 찾을 수 없을 때
				fuel = -1;
				break;
			}//if
			
		}//for
		
		System.out.println(fuel);
		
	}

	private static boolean delivery() {
		
		
		//출발지와 도착지가 겹치는 경우
//		if (x == taxiX && y == taxiY) { 
//			minX = taxiX;
//			minY = taxiY;
//			minD = 0;
//			return true;
//		}

		//승객의(man) 목적지 추출
		int x = destination.get(man).x;
		int y = destination.get(man).y;
		
//		System.out.println("man :: " + man + " , x :: " + x + " , y :: " + y);
		
		Queue<Taxi> q = new LinkedList<Taxi>();
		q.add(new Taxi(taxiX, taxiY));
		time[taxiX][taxiY] = 0;
		map[taxiX][taxiY] = 0;
		visit[taxiX][taxiY] = true;
		
		//man이 목적지
		while (!q.isEmpty()) {
			
			Taxi taxi = q.remove();
			
			int qx = taxi.x;
			int qy = taxi.y;
			
			//목적지로 도착했을 때
			if (qx == x && qy == y) {
				//택시 위치 이동
				minX = qx;
				minY = qy;
				minD = time[qx][qy];
				fuel -= minD; //연료 감소
				destination.remove(man);
				return true;
			}
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] == 401) {
					continue;
				}
				
				if (!visit[nx][ny] && (map[nx][ny] >= 0 && map[nx][ny] < 401)) {
					visit[nx][ny] = true;
					time[nx][ny] = time[qx][qy] + 1;
					q.add(new Taxi(nx, ny));
				}
				
			}//for
			
		}//while
		
		return false;
		
	}

	private static void bfs() {
		//현재 위치에 태울 승객 있는 경우
		if (map[taxiX][taxiY] > 0 && map[taxiX][taxiY] < 401) {
			minX = taxiX;
			minY = taxiY;
			minD = 0;
			man = map[taxiX][taxiY];
			return;
		}
		
		Queue<Taxi> q = new LinkedList<Taxi>();
		q.add(new Taxi(taxiX, taxiY));
		time[taxiX][taxiY] = 0;
		visit[taxiX][taxiY] = true;
		
		while (!q.isEmpty()) {
			Taxi taxi = q.remove();
			
			int qx = taxi.x;
			int qy = taxi.y;
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] == 401) {
					continue;
				}
				
				time[nx][ny] = time[qx][qy] + 1;
				
				if (map[nx][ny] < 401 && map[nx][ny] > 0) {
					
					if (time[nx][ny] < minD) {
						//처음 방문 or 더 가까운곳
						minX = nx;
						minY = ny;
						minD = time[nx][ny];
						man = map[nx][ny];
					} else if (time[nx][ny] == minD) {
						//가까운곳 여러번 방문시
						if (nx < minX) {
							//더 낮은 행으로
							minX = nx;
							minY = ny;
							man = map[nx][ny];
						} else if (nx == minX) {
							//낮은 행이 여러개일 때
							if (ny < minY) {
								minX = nx;
								minY = ny;
								man = map[nx][ny];
							}
						}
					}
				}//if
				
				if (!visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new Taxi(nx, ny));
				}
				
			}//for
			
		}//while
		
	}//bfs
}

class Taxi {
	int x, y;
	
	public Taxi(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}













