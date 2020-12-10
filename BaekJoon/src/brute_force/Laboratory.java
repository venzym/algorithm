package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory {
	/**
	 * 백준 14502 연구소 (https://www.acmicpc.net/problem/14502)
	 */
	
	private static int n, m;
	
	private static int[][] map; //기존배열
	private static int[][] temp; //계산위한배열
	private static boolean[][] visit;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int result = Integer.MIN_VALUE;
	
	private static ArrayList<Virus> virusLoc = new ArrayList<Virus>();
	
	private static Queue<Virus> virusQ = new LinkedList<Virus>();
	
	public static void main(String[] args) throws IOException {
		
		//n*m 직사각형
		//빈칸(0), 벽(1), 바이러스(2)
		//새로운 벽은 무조건 3개 세워야 함!
		
		//바이러스가 퍼지지 않는 안전 영역 크기의 최댓값!(0의 개수)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		temp = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusLoc.add(new Virus(i, j));
				}
			}
		}
		
		dfs(0); //카운트
		
		System.out.println(result);
		
	}//main

	private static void dfs(int count) {
		
		if (count == 3) {
			
			//계산할 배열로 옮겨 담기
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=m; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			//큐에 다시 넣기
			for (Virus virus : virusLoc) {
				virusQ.add(new Virus(virus.x, virus.y));
			}
			
			//바이러스 확산
			spreadVirus();
			
			//0 개수 세기
			result = Math.max(result, zeroCnt());
			
		} else {
			
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=m; j++) {
					if (map[i][j] == 0 && !visit[i][j]) {
						visit[i][j] = true;
						map[i][j] = 1; //벽세우기
						dfs(count+1); //재귀, 카운트+1
						map[i][j] = 0; //벽없애기
						visit[i][j] = false;
					}
				}
			}
			
		}
		
	}//dfs

	private static int zeroCnt() {
		
		int sum = 0;
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++) {
				if (temp[i][j] == 0) {
					sum++;
				}
			}
		}
		
		return sum;
		
	}//zeroCnt

	private static void spreadVirus() {
		
		while (!virusQ.isEmpty()) {
			
			Virus virus = virusQ.remove();
			int qx = virus.x;
			int qy = virus.y;
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > n || ny > m || temp[nx][ny] != 0) {
					continue;
				}
				
				if (temp[nx][ny] == 0) {
					temp[nx][ny] = 2;
					virusQ.add(new Virus(nx, ny));
				}
			}
			
		}
		
	}//spreadVirus

	static class Virus {
		int x, y;
		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}//Virus
}










