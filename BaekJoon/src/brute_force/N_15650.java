package brute_force;

import java.util.Scanner;

public class N_15650 {
	static private int N, M;
	static private boolean[] visit;
	static private int[] arr;
	
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
		
		//개수 같으면 출력
		if (M == d) {
			for (int i=0; i<M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for (int i=1; i<=N; i++) {
				if (!visit[i]) {
					if (d == 0 || arr[d-1] < i) {
						//d == 0은 다 출력 (1,2 | 1,3 | 1,4)
						//이전 arr[]원소가 현재 i보다 작을 때
						
						visit[i] = true; //방문 처리
						arr[d] = i; //원소 담기
						
						dfs(d + 1); //재귀
						
						//원상복구
						visit[i] = false;
					}
				}
			}
		}
		
	}
}
