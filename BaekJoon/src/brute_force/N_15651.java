package brute_force;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N_15651 {
	
	private static int n, m;
	private static int[] map;
	private static boolean[] visit;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//bufferedReader는 런타임 에러뜸. 이유는?
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[m];
		visit = new boolean[n+1];
		
		cycle(0, 0);
		bw.flush();//남아있는 데이터를 모두 출력시킴
		bw.close();//스트림을 닫음
	}

	private static void cycle(int start, int cnt) throws IOException {
		
		if (cnt == m) {
			
			for (int i=0; i<m; i++) {
				bw.write(Integer.toString(map[i]) + " ");
			}
			bw.newLine();
			
		} else {
			
			for (int i=1; i<=n; i++) {
				visit[i] = true;
				map[start] = i;
				cycle(start + 1, cnt + 1);
				visit[i] = false;
			}
			
		}
	
	}
}
