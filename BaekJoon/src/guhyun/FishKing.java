package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FishKing {
	/**
	 * 백준 17143 낚시왕 (https://www.acmicpc.net/problem/17143)
	 */
	
	private static int r, c, m;
	private static int[][] map;
	
	private static int[] dx = {0, -1, 1, 0, 0}; //0, 상, 하, 우, 좌
	private static int[] dy = {0, 0, 0, 1, -1};
	
	private static HashMap<Integer, Shark> sharks = new HashMap();
	
	private static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		if (m == 0) {
			System.out.println(0);
			return;
		}
		
		map = new int[r+1][c+1];
		
		for (int i=0; i<m; i++) {
			
			st = new StringTokenizer(reader.readLine());
			
			Shark shark = new Shark();
			
			shark.x = Integer.parseInt(st.nextToken());
			shark.y = Integer.parseInt(st.nextToken());
			shark.speed = Integer.parseInt(st.nextToken());
			shark.dir = Integer.parseInt(st.nextToken());
			shark.size = Integer.parseInt(st.nextToken());
			
			int cases = 0;
			if (shark.dir <= 2) {
				//상하
				cases = (r-1)*2;
			} else {
				//우좌
				cases = (c-1)*2;
			}
			
			if (cases >= shark.speed) {
				shark.speed %= cases;
			}
			
			map[shark.x][shark.y] = shark.size;
			sharks.put(shark.size, shark);
		}//for
		
		for (int y=1; y<=c; y++) {
			fishShark(y);//상어잡기
			moveShark();//상어이동
		}
		
		System.out.println(result);
		
	}


	private static void fishShark(int y) {
		
		for (int x=1; x<=r; x++) {
			if (map[x][y] != 0) { //상어 존재할 때
				result += map[x][y]; //크기 더해주기
				sharks.remove(map[x][y]);
				map[x][y] = 0;
				return;
			}
		}
		
	}//fishShark()

	private static void moveShark() {
		
		int[][] temp = new int[r+1][c+1];
		Queue<Integer> failer = new LinkedList<Integer>();
		
		for (Integer key : sharks.keySet()) {
			
			//hashmap에 들어있는 샤크 한개씩 정보를 가져온다.
			Shark shark = sharks.get(key);
			
			map[shark.x][shark.y] = 0;
			
			for (int i=0; i<shark.speed; i++) {
				
				if (shark.dir == 1 && shark.x == 1) {
					shark.dir = 2;
				} else if (shark.dir == 2 && shark.x == r) {
					shark.dir = 1;
				} else if (shark.dir == 3 && shark.y == c) {
					shark.dir = 4;
				} else if (shark.dir == 4 && shark.y == 1) {
					shark.dir = 3;
				}
			
				shark.x += dx[shark.dir];
				shark.y += dy[shark.dir];
			}
			
			if (temp[shark.x][shark.y] == 0) {
				temp[shark.x][shark.y] = shark.size; 
			} else if (temp[shark.x][shark.y] < shark.size) {
				//현재가 이전값보다 클 때 이전값 잡아먹음
				failer.add(temp[shark.x][shark.y]);
				temp[shark.x][shark.y]= shark.size; 
			} else {
				//현재가 이전값보다 작을 때
				failer.add(shark.size);
			}
			
		}//shark
		
		while (!failer.isEmpty()) {
			sharks.remove(failer.poll());
		}
		
		for (Integer key : sharks.keySet()) {
			Shark shark = sharks.get(key);
			map[shark.x][shark.y]= temp[shark.x][shark.y]; 
		}
		
	}//moveShark()
	
}//FishKing

class Shark {
	int x, y, speed, dir, size;
}