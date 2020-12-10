package brute_force;

import java.util.Scanner;

public class N_15649 {
	
	private static int N, M;
	private static int[] arr;
	private static boolean[] visit;
	
	public static void main(String[] args) {
		
		// 1 ~ N까지 수 중 M개 고른 수열
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visit = new boolean[N+1];
		arr = new int[M];
		dfs(0);
		
	}

	private static void dfs(int d) {
		//M = 2
		if (d == M) {
			for (int i=0; i<M; i++) {
//				System.out.println("d == M");
//				System.out.println("d :: " + d + " i :: " + i);
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			
			for (int i=1; i<=N; i++) {
				//이전에 visit[i]에 true를 해 1을 띄어넘음
				if (visit[i] == false) {
					System.out.println("d != M");
					System.out.println("d :: " + d + " i :: " + i);
					visit[i] = true;
					arr[d] = i;
					//재귀
					dfs(d+1);
					//백트래킹
					visit[i] = false;
				}
			}
		}
		
		
	}
}
