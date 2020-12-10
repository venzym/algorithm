package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PermutationCycle {
	private static ArrayList<Integer>[] map;
	private static boolean[] visit;
	private static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 12345678
		// 주어진 순열
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(reader.readLine());
		//int t = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			// t번
			int n = Integer.parseInt(reader.readLine());
			//int n = sc.nextInt();

			//인접리스트
			map = (ArrayList<Integer>[]) new ArrayList[n+1];
			visit = new boolean[n+1];
			cnt = 0;
			
			//초기화
			for (int j=0; j<=n; j++) {
				map[j] = new ArrayList<Integer>();
			}
			
			String[] permutation = reader.readLine().split(" ");
			
			//값 입력
			for (int j=1; j<=n; j++) {
				int v = Integer.parseInt(permutation[j-1]);
				//int v = sc.nextInt();
				
				map[j].add(v);
			}
			
			//방문 안되어 있는 리스트 탐색
			for (int j=1; j<=n; j++) {
				if (!visit[j]) {
					dfs(j);
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		
		System.out.print(sb);

	}

	private static void dfs(int start) {
			
		//방문전적 있으면 종료
		if (visit[start]) {
			return;
		}
		
		//방문처리
		visit[start] = true;
		
		//해당 리스트에서 방문한적 없으면 탐색
		for (int i : map[start]) {
			if (!visit[i]) {
				dfs(i);
			}
		}
		
	}
}
