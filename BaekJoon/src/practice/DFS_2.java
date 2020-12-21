package practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		boolean[] visit = new boolean[n+1];
		
		ArrayList<Integer>[] list = new ArrayList[n+1];
		
		for (int i=1; i<=n; i++) {
			//1~n개까지 list 선언
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<m; i++) {
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			
			list[a1].add(a2);
			list[a2].add(a1);
		}
		
		for (int i=1; i<list.length; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(v, list, visit);
		System.out.println();
		Arrays.fill(visit, false);
		
		bfs(v, list, visit);
		
	}

	private static void bfs(int v, ArrayList<Integer>[] list, boolean[] visit) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(v);
		visit[v] = true;
		
		while (!q.isEmpty()) {
			
			v = q.poll();
			System.out.print(v + " ");
			
			for (int i : list[v]) {
				if (!visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
			
		}
		
	}

	private static void dfs(int v, ArrayList<Integer>[] list, boolean[] visit) {
		
		visit[v] = true;
		System.out.print(v + " ");
		
		for (int i : list[v]) {
			//v인접 노드 탐색
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, list, visit);
			}
		}
		
	}
}





