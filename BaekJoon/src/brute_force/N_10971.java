package brute_force;

import java.util.Scanner;

public class N_10971 {
	private static int n;
	private static int[][] map;
	private static boolean[] visit;
	private static int min = 10000000; //N개 항목 더한것보다 크게
	private static int count = 0;
	private static int sum = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i=1; i<=n; i++) {
			//시작점
			dfs(i,i);
			sum = 0;
		}
		System.out.println(min);
	}

	private static void dfs(int start, int index) {
		
		if (start == index && count == n) {
			//처음과 돌아올때 같아야함 && n개의 도시를 방문해야함
			if (min > sum) {
				min = sum;
			}
		} else {
			for (int i=1; i<=n; i++) {
				if (!visit[i] && map[index][i] != 0) { 
					//방문하지 않은 도시 && 자기자신 제외
					//다른 도시를 방문하기 위해 행 변경
					visit[i] = true; //방문x, 갈 수 있어야 할 때
					sum += map[index][i]; //합계더하기
					count++; //개수더하기
					
					//i -> 2 1 3 4
					
					dfs(start, i); //재귀
					
					//원상복구
					visit[i] = false;
					sum -= map[index][i];
					count--;
				}
			}
		}
		
	}
}
