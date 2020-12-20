package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MovementPopulation {
	/**
	 * 백준 16234 인구 이동 (https://www.acmicpc.net/problem/16234)
	 */
	private static int N, L, R;
	private static int[][] map;
	private static boolean[][] visit;
	
	private static int[] sum;
	private static int[] count;
	private static int index;
	private static int[][] status;
	
	private static int[] dx = {0, 1, 0, -1};//우, 하, 좌, 상
	private static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean update = true;
		
		int result = 0;
		
		while (update) {
			update = false;
			
			visit = new boolean[N+1][N+1]; //bfs시 방문처리
			status = new int[N+1][N+1]; //인덱스 번호
			sum = new int[2501]; //인덱스당 합
			count = new int[2501]; //인덱스당 개수
			index = 0;
			
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (!visit[i][j]) {
						index++;
						bfs(i, j, status);
					}
				}
			}
			
			
			//국경이 이어지지 않으면 sum = 자신, count = 1 이기 때문에 그대로임
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					int num = status[i][j];
					int avg = sum[num] / count[num];
					if (map[i][j] != avg) {
						map[i][j] = avg;
						update = true;
					}
				}
			}
			
			if (update) {
				result++;
			}
		}
		
		System.out.println(result);
		
	}//main


	private static void bfs(int x, int y, int[][] status) {
		
		Queue<Population> q = new LinkedList<>();
		
		q.add(new Population(map[x][y], x, y));
		visit[x][y] = true;
		
		while (!q.isEmpty()) {
			Population pop = q.remove();
			
			int qn = pop.num;
			int qx = pop.x;
			int qy = pop.y;
			status[qx][qy] = index;
			count[index]++;
			sum[index] += map[qx][qy];
			
			for (int i=0; i<dx.length; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				
				if (nx < 1 || ny < 1 || nx > N || ny > N) {
					continue;
				}
				
				int minus = Math.abs(qn-map[nx][ny]);
				
				if (!visit[nx][ny] && minus >= L && minus <= R) {
					visit[nx][ny] = true;
					q.add(new Population(map[nx][ny], nx, ny));
				}
				
			}//for
			
		}//while
		
	}
	
	static class Population {
		int num, x, y;
		public Population(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
}












