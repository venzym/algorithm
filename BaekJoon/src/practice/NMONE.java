package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NMONE {
	private static int n, m;
	private static int[] map;
	private static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[m];
		visit = new boolean[n+1];
		
		dfs(0);
		
	}

	private static void dfs(int start) {
		
		if (start == m) {
			
			for (int i=0; i<m; i++) {
				System.out.println(map[i]);
			}
			
		} else {
			
			for (int i=1; i<=n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					map[start] = i;
					dfs(start+1);
					visit[i] = false;
				}
			}
			
		}
	}
}
