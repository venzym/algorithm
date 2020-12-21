package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM4 {
	private static int n, m;
	private static int[] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[m];
		
		cycle(0, 1);
		
	}

	private static void cycle(int idx, int start) {

		if (idx == m) {
			for (int i=0; i<m; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println();
		} else {
			
			for (int i=start; i<=n; i++) {
				map[idx] = i;
				cycle(idx+1, i);
			}
			
		}
		
	}
}










