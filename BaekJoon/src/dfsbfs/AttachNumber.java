package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AttachNumber {
	private static int n;
	private static int[][] map;
	private static boolean[][] visit;
	private static int cnt;
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1][n+1];
		visit = new boolean[n+1][n+1];
		
		//행렬입력
		for (int i=1; i<=n; i++) {
			String[] temp = (reader.readLine()).split("");
			for (int j=0; j<temp.length; j++) {
				map[i][j+1] = Integer.parseInt(temp[j]);
			}
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();

		//단지개수
		int sum = 0;
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					//방문x, 1인경우 탐색
					cnt = 0;
					dfs(i,j);
					result.add(cnt);
					sum++;
				}
			}
		}
		
		//오름차순 정렬
		Collections.sort(result);
		result.add(0, sum);
		
		for (int i : result) {
			System.out.println(i);
		}
		
	}

	private static void dfs(int x, int y) {
		
		//처음 방문하는곳 방문처리, 개수+1
		visit[x][y] = true;
		cnt++;
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			//범위 넘어가면 넘기기
			if (nx < 1 || ny < 1 || nx > n || ny > n) {
				continue;
			}
			
			//방문x, 1이면 방문처리 후 주변 탐색
			if (!visit[nx][ny] && map[nx][ny] == 1) {
				visit[nx][ny] = true;
				dfs(nx, ny);
			}
			
		}
		
	}
}
