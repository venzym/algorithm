package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PermutaionCycle {
	private static int t;
	private static int n;
	private static boolean[] visit;
	private static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(reader.readLine());
		
		int[] result = new int[t];
		
		for (int i=0; i<t; i++) {
			
			n = Integer.parseInt(reader.readLine());
			
			visit = new boolean[n+1];
			list = new ArrayList[n+1];
			
			for (int j=0; j<=n; j++) {
				list[j] = new ArrayList<Integer>();
			}
			
			String[] str = reader.readLine().split(" ");
			for (int j=1; j<=n; j++) {
				list[j].add(Integer.parseInt(str[j-1]));
			}
			
			int cnt = 0;
			
			for (int j=1; j<=n; j++) {
				if (!visit[j]) {
					dfs(j);
					cnt++;
				}
			}
			
			result[i] = cnt;
		}
		
		for (int i : result) {
			System.out.println(i);
		}
		
	}

	private static void dfs(int start) {
		
		if (visit[start]) return;
		
		visit[start] = true;
		
		for (int i : list[start]) {
			if (!visit[i]) {
				dfs(i);
			}
		}
		
	}
}









