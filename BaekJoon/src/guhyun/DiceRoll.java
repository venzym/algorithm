package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceRoll {
	/**
	 * 백준 14499 주사위 굴리기 (https://www.acmicpc.net/problem/14499)
	 */
	private static int n, m, x, y, k;
	private static int[][] map;
	private static int[] dice = new int[7];
	
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken())+1;
		y = Integer.parseInt(st.nextToken())+1;
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sb = new StringBuilder();
		
		st = new StringTokenizer(reader.readLine(), " ");
		int[] command = new int[k];
		for (int i=0; i<k; i++) {
			//k번만큼 명령 실행
			command[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<k; i++) {
			moveDice(command[i]);
		}
		
		System.out.print(sb);
		
	}

	private static void moveDice(int order) {
		//주사위 굴리기
		int temp;
		if (order == 1) {
			//동
			
			if (y+1 <= m) {
				temp = dice[5];
				
				dice[5] = dice[3];
				dice[3] = dice[6];
				dice[6] = dice[1];
				dice[1] = temp;
				
				y += 1;
				checkMap();
				sb.append(dice[1] + "\n");
			}
			
		} else if (order == 2) {
			//서
			
			if (y-1 > 0) {
				temp = dice[1];
				
				dice[1] = dice[6];
				dice[6] = dice[3];
				dice[3] = dice[5];
				dice[5] = temp;
				
				y -= 1;
				checkMap();
				sb.append(dice[1] + "\n");
			} 
			
		} else if (order == 3) {
			//북
			
			if (x-1 > 0) {
				temp = dice[1];
				
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = dice[4];
				dice[4] = temp;
				
				x -= 1;
				checkMap();
				sb.append(dice[1] + "\n");
			} 
			
		} else if (order == 4) {
			//남
			
			if (x+1 <= n) {
				temp = dice[1];
				
				dice[1] = dice[4];
				dice[4] = dice[3];
				dice[3] = dice[2];
				dice[2] = temp;
				
				x += 1;
				checkMap();
				sb.append(dice[1] + "\n");
			}
			
		}
 		
		
	}//moveDice

	private static void checkMap() {
		//지도 수와 주사위 바닥 비교
		if (map[x][y] == 0) {
			//지도 칸이 0일 때 주사위 바닥 수가 칸으로 복사된다.
			map[x][y] = dice[3];
		} else {
			//지도 칸이 0이 아닐 때 칸 바닥 수가 주사위 바닥으로 이동된다.
			dice[3] = map[x][y];
			map[x][y] = 0;
		}
		
		
	}//checkMap
}












