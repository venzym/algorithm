package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE {
	/**
	 * 백준 13023 ABCDE (https://www.acmicpc.net/problem/13023)
	 */
	
	private static int n, m;
	private static ArrayList<Integer>[] list;
	private static boolean[] visit;
	
	private static boolean exist;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		for (int i=0; i<n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		visit = new boolean[n];
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(reader.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		for (int i=0; i<n; i++) {
			exist = false;
			visit = new boolean[n];
			dfs(i,0);
			
			if (exist) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}

	private static void dfs(int x, int count) {
		
		if (count == 4) {
			exist = true;
		} else {
			
			for (int i=0; i<list[x].size(); i++) {
				if (!visit[list[x].get(i)]) {
					visit[x] = true;
					dfs(list[x].get(i), count+1);
					if (exist) return;
					visit[x] = false;
				}
			}
			
		}
		
	}
}






