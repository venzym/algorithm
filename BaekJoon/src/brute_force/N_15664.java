package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class N_15664 {
	
	private static int n,m;
	private static int[] map;
	private static int[] result;
	private static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n];
		result = new int[m];
		visit = new boolean[n+1];
		
		for (int i=0; i<n; i++) {
			map[i] = sc.nextInt();
		}
		
		Arrays.sort(map);
		
		StringBuilder sb = new StringBuilder();
		
		cycle(0, 0, sb);
		
		System.out.print(sb);
		
	}

	private static void cycle(int start, int cnt, StringBuilder sb) {
		
		if (cnt == m) {
			
			for (int i=0; i<m; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			
		} else {
			
			int num = 0;
			for (int i=start; i<n; i++) {
				if (!visit[i]) {
					if (num == map[i]) {
						continue;
					}
					
					visit[i] = true;
					result[cnt] = map[i];
					cycle(i+1, cnt+1, sb);
					visit[i] = false;
					
					num = map[i];
					
				}
			}
			
		}
		
	}
}










