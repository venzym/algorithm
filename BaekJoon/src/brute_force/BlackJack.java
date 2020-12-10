package brute_force;

import java.util.Scanner;

public class BlackJack {
	private static int n, m;
	private static int[] map;
	private static boolean[] visit;
	private static int[] result = new int[3];
	
	private static int sum = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		visit = new boolean[n+1];
		map = new int[n];
		for (int i=0; i<n; i++) {
			map[i] = sc.nextInt();
		}
		
		dfs(0);
		
		System.out.print(sum);
	}

	private static void dfs(int start) {
		
		if (start == 3) {
			
			int hap = 0;
			for (int i : result) {
				hap += i;
			}

			if (hap > m) {
				return;
			}
			
			if (hap <= m) {
				sum = Math.max(sum, hap);
			}
			
		} else {
			
			for (int i=start; i<n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					result[start] = map[i];
					dfs(start+1);
					visit[i] = false;
				}
			}
		}
		
	}
}
