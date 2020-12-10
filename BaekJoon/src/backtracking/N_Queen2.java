package backtracking;

import java.util.Scanner;

public class N_Queen2 {
	private static int N = 0;
	private static int count = 0;
	private static int[] col;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for (int i=1; i<=N; i++) {
			col = new int[N+1];
			col[1] = i;
			
			//다음열 탐색
			dfs(2);
		}
		System.out.println(count);
	}

	private static void dfs(int row) {
		//row가 정해진 크기 벗어나면 숫자 증가
		if (N < row) {
			count++;
		} else {
			for (int i=1; i<=N; i++) {
				col[row] = i;
				
				if (isPossible(row)) {
					//탐색이 유의미할떄
					dfs(row+1);
				} else {
					//탐색이 무의미할때
					col[row] = 0;
				}
			}
		}
		
		
	}

	private static boolean isPossible(int row) {
		
		for (int i=1; i<row; i++) {
			
			//행이 같을 때
			if (col[i] == col[row]) {
				return false;
			}
			
			//대각선에 존재할 때
			if (Math.abs(i-row) == Math.abs(col[i] - col[row])) {
				return false;
			}
			
		}
		
		return true;
	}
	
}