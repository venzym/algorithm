package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class N_15654 {
	
	private static int n, m;
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
		
		cycle(0);
		
	}

	private static void cycle(int start) {
		
		if (start == m) {
			for (int i=0; i<result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		} else {
			
			for (int i=0; i<n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					result[start] = map[i];
					cycle(start+1);
					visit[i] = false;
				}
			}
		}
		
	}
}















