package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PuyoPuyo {
	/**
	 * 백준 11559 뿌요뿌요 (https://www.acmicpc.net/problem/11559)
	 */
	
	private static char[][] map = new char[12][6];
	private static boolean[][] visit = new boolean[12][6];
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		
		//여러 색깔
		
		//아래로 떨어짐 -> while
		
		//같은 색 뿌요가 4개이상 상하좌우로 연결되어 있으면 한꺼번에 없어짐
		//-> 좌우상하 탐색시 매개변수로 자신의 색깔 보내기
		//-> 같은친구 있으면 계속 탐색하기, 없으면 끝내고 있으면 모두 .으로 변경한다.
		
		//없어지면 위에 뿌요들이 아래로 떨어짐
		//while문 반복
		
		//터질수 있는 뿌요가 여러개 있다면 동시에 터져야 함
		//색깔을 매개변수로 보내 비교하기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<12; i++) {
			String input = reader.readLine();
			char[] c = input.toCharArray();
			for (int j=0; j<6; j++) {
				map[i][j] = c[j];
			}
		}
		
		int result = 0;
		
		//연쇄
		while (true) {
			visit = new boolean[12][6];
			
			//연산 했는지 안했는지 체크
			boolean flag = false;
			
			//같은 것 찾는 연산
			for (int i=0; i<12; i++) {
				for (int j=0; j<6; j++) {
					if (!visit[i][j] && map[i][j] != '.') {
						cnt = 1;
						
						if (findCnt(i,j, map[i][j])) {
							//같은 색의 뿌요 개수 4개 이상일 때 제거하기
							flag = true;
							bfs(i,j,map[i][j]);
						}
						
					}
				}
			}
			
			if (flag) {
				//연쇄증가
				result++;
			} else {
				//연쇄가 없다면 탈출
				break;
			}
			
			gravity();
			
//			//아래로 1칸씩 이동
//			while (true) {
//				//내려갈 친구들 있는지 체크
//				boolean check = false;
//				
//				//중력!!
//				check = gravity(check);
//				
//				if (!check) {
//					//내려갈 친구들 없으면 탈출
//					break;
//				}
//				
//			}
			
		}
		
		System.out.println(result);
	}

	private static void gravity() {
		
		//아래서부터 위로 중력실행
		for (int i=11; i>0; i--) {
			for (int j=5; j>=0; j--) {
				if (map[i][j] == '.' && map[i-1][j] != '.') {
//					check = true;
					map[i][j] = map[i-1][j];
					map[i-1][j] = '.';
				}
			}
		}
//		return check;
	}

	private static void bfs(int x, int y, char color) {
		
		Queue<Puyo> q = new LinkedList<Puyo>();
		
		q.add(new Puyo(x, y));
		
		while (!q.isEmpty()) {
			Puyo py = q.remove();
			
			int qx = py.x;
			int qy = py.y;
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6 || map[nx][ny] != color) {
					continue;
				}
				
				if (visit[nx][ny] && map[nx][ny] == color) {
					//이전 개수셀 때 방문했고 색상이 같으면 .으로 변경(터뜨리기)
					map[nx][ny] = '.';
					q.add(new Puyo(nx, ny));
				}
			}
			
		}
		
	}

	private static boolean findCnt(int x, int y, char color) {
		
		visit[x][y] = true;
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6 || map[nx][ny] != color) {
				continue;
			}
			
			if (!visit[nx][ny] && map[nx][ny] == color) {
				//인접한 곳중 색상이 같으면 카운트+1
				cnt++;
				findCnt(nx, ny, color);
			}
		}
		
		if (cnt >= 4) {
			return true;
		}
		return false;
		
	}
}


class Puyo {
	int x, y;
	
	public Puyo(int x, int y) {
		this.x = x;
		this.y = y;
	}
}








