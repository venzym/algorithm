package practice;

import java.util.Scanner;

public class N_15649_2 {
	private static int N, M;
	private static boolean[] visit;
	private static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		//방문처리
		visit = new boolean[N+1];
		//개수만큼 출력할 값 담음
		arr = new int[M];
		dfs(0);
		
	}

	private static void dfs(int d) {
		
		//d와 M이 같은 경우 출력해야함
		if (d == M) {
			//M개 출력
			for (int i=0; i<M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for (int i=1; i<=N; i++) {
				if (!visit[i]) {
					visit[i] = true; //방문처리
					arr[d] = i; //원소 넣기
					dfs(d+1); //하위 노드 탐색
					visit[i] = false; //다음 계산을 위해 원상복구
				}
			}
		}
		
	}
}