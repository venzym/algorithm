package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ChickenDelivery {
	private static int n, m;
	private static int[][] map;
	private static boolean[] visit;
	
	private static ArrayList<Chicken> chickenList = new ArrayList<>();
	private static ArrayList<Chicken> homeList = new ArrayList<>();
	
	private static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chickenList.add(new Chicken(i, j));
				} else if (map[i][j] == 1) {
					homeList.add(new Chicken(i,j));
				}
			}
		}
		
		visit = new boolean[chickenList.size()];
		
		dfs(0,0);
		
		System.out.println(result);
		
	}
	
	private static void dfs(int start, int count) {

		if (count == m) {
			
			chickenDistance();
			
		} else {
			
			for (int i=start; i<chickenList.size(); i++) {
				if (!visit[i]) {
					visit[i] = true;
					dfs(i+1, count+1);
					visit[i] = false;
				}
			}
			
		}
		
	}

	private static void chickenDistance() {
		
		int sum = 0;
		for (int i=0; i<homeList.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j=0; j<chickenList.size(); j++) {
				if (visit[j]) {
					int distance = Math.abs(homeList.get(i).x - chickenList.get(j).x) + Math.abs(homeList.get(i).y - chickenList.get(j).y);
					min = Math.min(min, distance);
				}
			}
			sum += min;
		}
		
		result = Math.min(result, sum);
		
	}//chickenDistance

	static class Chicken {
		int x, y;
		public Chicken(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}











