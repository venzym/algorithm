package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepaintChess {
	private static int n, m;
	private static String[][] map;
	private static String[][] result = new String[9][9];
	private static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		
		map = new String[n+1][m+1];
		for (int i=1; i<=n; i++) {
			String[] str = reader.readLine().split("");
			for (int j=1; j<=m; j++) {
				map[i][j] = str[j-1];
			}
		}
		
		int num1 = 0;
		
		int x = 0;
		int y = 0;
		
		int min = Integer.MAX_VALUE;
		
		while (true) {
			if (n == x+8 && m == y+8) {
				break;
			}
			
			num1 = 0;
			
			for (int i=1; i<=8; i++) {
				for (int j=1; j<=8; j++) {
					if (!map[x+i][y + j].equals(map[i][j])) {
						num1++;
					}
				}
			}
			if (num1 < min) {
				min = num1;
			}
			
			if (x+8 == n && y+8 == m) {
				break;
			}
			
			if (y+8 == m) {
				x++;
				y=0;
			} else {
				y++;
			}
		}
		
		System.out.println(min);
		
//		dfs(1);
		
	}

	private static void dfs(int start) {
		
		if (start > 8) {
			for (int i=1; i<=8; i++) {
				for (int j=1; j<=8; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			
			for (int i=start; i<=m; i++) {
				for (int j=1; j<=n; j++) {
					if (!visit[i][j]) {
						visit[i][j] = true;
						result[start][j] = map[i][j];
						dfs(start+1);
						visit[i][j] = false;
					}
				}
			}
			
		}
		
	}
}
