package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartTaxi {
	/**
	 * 백준 19238 스타트 택시 (https://www.acmicpc.net/problem/19238)
	 */
	
	private static int n, m, fuel;
	
	private static int[][] map; //태울 승객 & 벽
	private static int[][] time; //이동 시간(연료)
	private static boolean[][] visit; //탐색시 방문
	
	private static int minX, minY, minT; //최소 행, 열
	private static int man; //승객번호
	
	private static int taxiX, taxiY; //택시 행, 열
	
	private static int[] dx = { -1, 0, 1, 0 }; //상우하좌
	private static int[] dy = { 0, 1, 0, -1 };
	
	//목적지 (승객번호, 승객정보)
	private static HashMap<Integer, Taxi> destination = new HashMap<Integer, Taxi>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		time = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1; //벽
				}
			}
		}
		
		st = new StringTokenizer(reader.readLine());
		taxiX = Integer.parseInt(st.nextToken());
		taxiY = Integer.parseInt(st.nextToken());
		
		for (int i=1; i<=m; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int departX = Integer.parseInt(st.nextToken());
			int departY = Integer.parseInt(st.nextToken());
			
			map[startX][startY] = i;
			destination.put(i, new Taxi(departX, departY));
		}
		
		for (int cus=0; cus<m; cus++) {
			
			//최소 행,열 최대값 넣기
			minX = minY = minT = Integer.MAX_VALUE;
			man = 0; //승객번호 초기화
			
			//시간배열 초기화
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					time[i][j] = -1;
				}
			}
			
			//가장 가까운 승객 찾기
			bfs();
			
			//승객이 있는데 승객까지 못가는 경우
			//승객이 없어서 승객까지 못가는 경우
			
			if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				System.out.println("손님 - " + "minX ::  " + minX + " , minY :: " + minY + " , minD :: " + minT + " , man :: " + man + " , fuel :: " + fuel);

				fuel -= minT;
				
				//손님 찾아가다 연료 떨어진 경우
				if (fuel < 0) {
					fuel = -1;
					break;
				}
				
				//손님 위치로 이동
				taxiX = minX;
				taxiY = minY;
				
				//시간초기화
				for (int i=1; i<=n; i++) {
					for (int j=1; j<=n; j++) {
						time[i][j] = -1;
					}
				}
				
				//방문 초기화
				visit = new boolean[n + 1][n + 1];
				
				if (delievery()) {
					fuel -= minT;
					System.out.println("손님3 - " + "minX ::  " + minX + " , minY :: " + minY + " , minD :: " + minT + " , man :: " + man + " , fuel :: " + fuel);
					
					if (fuel < 0) {
						fuel = -1;
						break;
					}
					
					//연료 2배 충전
					fuel += minT*2;
					
					//도착지로 위치 변경
					taxiX = minX;
					taxiY = minY;
					
				} else {
					fuel = -1;
					break;
				}
				
				
			} else {
				//손님 못찾은 경우
				fuel = -1;
				break;
			}
			
		}//while
		
		System.out.println(fuel);
		
	}

	private static void bfs() {
		
		//출발지에 승객이 있는 경우
		if (map[taxiX][taxiY] > 0)  {
			minT = 0;
			man = map[taxiX][taxiY];
			return;
		}
		
		Queue<Taxi> q = new LinkedList<Taxi>();
		q.add(new Taxi(taxiX, taxiY));
		time[taxiX][taxiY] = 0;
		visit[taxiX][taxiY] = true;
		
		while (!q.isEmpty()) {
			
			Taxi taxi = q.remove();
			
			int tx = taxi.x;
			int ty = taxi.y;
			
			for (int i=0; i<dx.length; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];

				if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] == -1) {
					continue;
				}
				
				time[nx][ny] = time[tx][ty] + 1; //시간 +1 증가
				
				if (map[nx][ny] > 0) { //손님이 존재 할 때 행, 열 비교
					
					if (time[nx][ny] < minT) {
						//거리가 가까운 새로운 손님
						minX = nx;
						minY = ny;
						minT = time[nx][ny];
						man = map[nx][ny];
					} else if (time[nx][ny] == minT) {
						//거리가 같은 손님
						//행이 더 낮을 때
						if (nx < minX) {
							minX = nx;
							minY = ny;
							man = map[nx][ny];
						} else if (nx == minX) {
							//행이 같을 때
							//열이 더 낮을 때
							if (ny < minY) {
								minX = nx;
								minY = ny;
								man = map[nx][ny];
							}
						}
					}
					
				}
				
				if (!visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new Taxi(nx, ny));
				}
				
			}
		}
		
	}
	
	private static boolean delievery() {
		
		Queue<Taxi> q = new LinkedList<Taxi>();
		q.add(new Taxi(taxiX, taxiY));
		visit[taxiX][taxiY] = true;
		map[taxiX][taxiY] = 0;
		time[taxiX][taxiY] = 0;
		
		int x = destination.get(man).x;
		int y = destination.get(man).y;
		
		System.out.println("손님 - " + "minX ::  " + minX + " , minY :: " + minY + " , minD :: " + minT + " , man :: " + man + " , fuel :: " + fuel);
		
		while (!q.isEmpty()) {
			
			Taxi taxi = q.remove();
			
			int tx = taxi.x;
			int ty = taxi.y;
			System.out.println("손님2 - " + "tx ::  " + tx + " , ty :: " + ty + " , minD :: " + minT + " , man :: " + man + " , fuel :: " + fuel);

			if (tx == x && ty == y) {
				minX = tx;
				minY = ty;
				minT = time[tx][ty];
				destination.remove(man);
				return true;
			}
			
			for (int i=0; i<dx.length; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] == -1) {
					continue;
				}
				
				if (!visit[nx][ny] && map[nx][ny] >= 0) {
					visit[nx][ny] = true;
					time[nx][ny] = time[tx][ty] + 1;
					q.add(new Taxi(nx, ny));
				}
				
			}
			
		}//while
		
		return false;
	}//delivery
	
	
}//class









