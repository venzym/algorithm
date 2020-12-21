package practice;

import java.util.Scanner;

public class N_15650_2 {
	private static int n, m;
	private static int[] list;
	private static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		list = new int[m];
		visit = new boolean[n+1];
		
		cycle(0);
		
	}

	private static void cycle(int num) {
		
		if (num == m) {
			for (int i=0; i<m; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
		} else {
			
			for (int i=1; i<=n; i++) {
				if (!visit[i] && (num == 0 || list[num-1] < i)) {
					visit[i] = true;
					list[num] = i;
					cycle(num+1);
					visit[i] = false;
				}
			}
		}
		
	}
}
