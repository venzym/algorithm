package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class N_7568 {
	private static int n;
	private static int[][] map;
	private static boolean[] visit;
	private static int[] rank;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][2];
		visit = new boolean[n+1];
		rank = new int[n];
		Arrays.fill(rank, 1);
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<2; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][0] > map[j][0] && map[i][1] > map[j][1]) {
					rank[j]++;
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			System.out.println(rank[i]);
		}
		
	}
}
