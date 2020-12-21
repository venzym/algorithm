package practice;

import java.util.Scanner;

public class N_15649_3 {
	
	private static int n, m;
	private static int[] list;
	private static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		list = new int[m];
		visit = new boolean[n+1];
		
		dfs(0);
		
	}

	private static void dfs(int num) {
		
		if (num == m) {
			for (int i=0; i<m; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
		} else {
			
			for (int i=1; i<=n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					list[num] = i;
					dfs(num+1);
					visit[i] = false;
				}
			}
		}
		
	}
}