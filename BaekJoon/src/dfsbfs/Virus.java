package dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Virus {
	private static int cnt;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //컴퓨터의 수
		int m = sc.nextInt(); //컴퓨터 쌍의 수
		
		boolean[] visit = new boolean[n+1]; //방문처리
		
		ArrayList<Integer>[] list = new ArrayList[n+1]; //인접리스트
		
		for (int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		//값 입력
		for (int i=0; i<m; i++) { 
			int a1 = sc.nextInt();
			int a2 = sc.nextInt();
			
			list[a1].add(a2);
			list[a2].add(a1);
		}
		
		//오름차순 정렬
		for (int i=1; i<list.length; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(1, list, visit);
		
		System.out.println(cnt);
	}

	private static void dfs(int v, ArrayList<Integer>[] list, boolean[] visit) {
		
		visit[v] = true;
		//System.out.print(v + " ");
		
		for (int i : list[v]) {
			if (!visit[i]) {
				visit[i] = true;
				cnt++;
				dfs(i, list, visit);
			}
		}
		
	}
}












