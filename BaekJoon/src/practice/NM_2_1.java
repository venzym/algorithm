package practice;

import java.util.Scanner;

public class NM_2_1 {

	private static int n,m;
	private static int[] map;
	private static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[m+1]; // 0 1 2
		visit = new boolean[n+1];
		
		cycle(1, 0);
		
	}

	private static void cycle(int start, int end) {
		
		if (end == m) {
			
			for (int i=1; i<=m; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println();
		} else {

			for (int i=start; i<=n; i++) {
				if (!visit[i] && i > map[start-1]) {
					visit[i] = true;
					map[start] = i;
					cycle(start+1, end+1);
					visit[i] = false;
				}
			}
			
		}
		
	}
}
