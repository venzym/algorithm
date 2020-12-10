package brute_force;

import java.util.Scanner;

public class Start_Link {
	private static int N;
	private static int[][] map;
	private static boolean[] visit;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		visit = new boolean[N+1];
		map = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		cycle(1, 0);
		System.out.println(min);
		
	}

	private static void cycle(int start, int num) {
		
		if (num == N/2) {
			//값 -
			//min보다 작은값이 나오면 min에 넣어준다.
			int result = minus();
			min = Math.min(min, result);
			
		} else {
			
			//중복제거 위해 start부터 실행
			for (int i=start; i<=N; i++) {
				if (!visit[i]) {
					visit[i] = true;
					cycle(i+1, num+1);
					visit[i] = false;
				}
			}
			
		}
		
	}

	private static int minus() {
		
		int start_sum = 0;
		int link_sum = 0;
		
		//방문처리가 되있는 원소는 start, 안되어있는 원소는 link
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (visit[i] && visit[j]) {
					start_sum += map[i][j];
				}
				
				if (!visit[i] && !visit[j]) {
					link_sum += map[i][j];
				}
			}
		}
		
		return Math.abs(start_sum - link_sum);
	}
}














