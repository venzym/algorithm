package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class N_15665 {
	
	private static int n, m;
	private static int[] map;
	private static int[] result;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n];
		result = new int[m];
		
		for (int i=0; i<n; i++) {
			map[i] = sc.nextInt();
		}
		Arrays.sort(map);
		
		StringBuilder sb = new StringBuilder();
		
		cycle(0, sb);
		System.out.print(sb);
		
	}

	private static void cycle(int start, StringBuilder sb) {
		
		if (start == m) {
			
			for (int i=0; i<m; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			
		} else {
			
			int num = 0;
			for (int i=0; i<n; i++) {
				if (num == map[i]) continue;
				result[start] = map[i];
				cycle(start+1, sb);
				
				num = map[i];
			}
			
		}
		
	}
}
