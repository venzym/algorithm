package dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsBfs {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		boolean[] visit = new boolean[n+1];
		ArrayList<Integer>[] list = new ArrayList[n+1];
		
		for (int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<m; i++) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			
			list[a1].add(a2);
			list[a2].add(a1);
		}
		
		for (int i=1; i<=n; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(v, list, visit);
		//Arrays.fill(visit, false);
		visit = new boolean[n+1];
		System.out.println();
		
		bfs(v, list, visit);
		
	}

	private static void bfs(int start, ArrayList<Integer>[] list, boolean[] visit) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;
		
		while (!q.isEmpty()) {
			int num = q.poll();
			System.out.print(num + " ");
			
			for (int i : list[num]) {
				if (!visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
		
		
	}

	private static void dfs(int start, ArrayList<Integer>[] list, boolean[] visit) {
		
		visit[start] = true;
		System.out.print(start + " ");
		
		for (int i : list[start]) {
			if (!visit[i]) {
				dfs(i, list, visit);
			}
		}
		
		
	}
}	


















