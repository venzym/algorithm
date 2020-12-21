package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NM2 {
	private static int n,m;
	private static int[] map;
	private static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split(" ");
		
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		map = new int[m];
		visit = new boolean[n+1];
		
		cycle(0);
		
	}

	private static void cycle(int start) {
		
		if (start == m) {
			for (int i=0; i<m; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println();
		} else {
			
			for (int i=1; i<=n; i++) {
				if (!visit[i]) {
					if (start == 0 || map[start-1] < i) {
						visit[i] = true;
						map[start] = i;
						cycle(start+1);
						visit[i] = false;
					}
				}
			}
			
		}
		
	}
}











