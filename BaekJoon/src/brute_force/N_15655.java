package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class N_15655 {
	
	private static int n, m;
	private static int[] map;
	private static int[] result;
	private static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n];
		visit = new boolean[n+1];
		result = new int[m];
		
		for (int i=0; i<n; i++) {
			map[i] = sc.nextInt();
		}
		Arrays.sort(map);
		
		cycle(0,0);
		
	}

	private static void cycle(int start, int cnt) {
		
		if (cnt == m) {
			
			for (int i=0; i<m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			
		} else {
			
			for (int i=start; i<n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					result[cnt] = map[i];
					cycle(i+1, cnt+1);
					visit[i] = false;
				}
			}
			
		}
		
	}
}









