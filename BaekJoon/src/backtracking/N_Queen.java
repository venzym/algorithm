package backtracking;

import java.util.Scanner;

public class N_Queen {
	private static int N = 0;
	private static int count = 0;
	private static int[] column;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//퀸 N개를 서로 공격할 수 없게 놓는 경우의 수
		N = sc.nextInt();
		
		//동일한 행에 퀸은 1개만 둘 수 있다.
		
		for (int i=1; i<=N; i++) {
			//N행까지 담기 위해
			column = new int[N+1];
			//1행 i열에 퀸을 놓음
			//1, 1 | 1, 2 | 1, 3 | 1, 4 | ...
			column[1] = i;
			
			//DFS 수행
			//1행 i열에 퀸을 놓았을 경우 dfs로 가능한 경우를 확인한다.
			dfs(2);
		}
		System.out.println(count);
	}

	
	//dfs
	private static void dfs(int row) {
		//~행 row열
		//열(row)이 N보다 크다는 말은 N번째 열까지 퀸을 놓았다는 의미다.
		//즉, 퀸을 다 놓았다는 의미로 count를 증가시킨다.
		if (N < row) {
			count++;
		} else {
			for (int i=1; i<=N; i++) {
				//(row)행 i열에 퀸을 놓는다.
				//동일한 열은 불가능하기 때문에 row(다음열)부터 진행
				column[row] = i;
			
				//2. 유망한 노드인지 판단.
				if (isPossible(row)) {
					//유망할 때
					//3. 서브 트리로 이동(해당 노드의 하위 노드) -> 재귀로 dfs 실행
					dfs(row+1);
				} else {
					//4. 백트래킹 수행. 해당 노드는 가지치기 됨.
					// 0이면 퀸을 못놓는다는 의미.
					column[row] = 0;
				}
			}
		}
	}


	//유망한 노드 판단
	private static boolean isPossible(int row) {
		
		// (row)이 들어오는데 row 행 전까지 검사한다.
		for (int i=1; i<row; i++) {
			
			//i행과 row행의 열이 같으면 퀸을 놓을 수 없다.
			//상위 노드에서 같은 행에 퀸이 있으면 놓을 수 없다.
			if (column[i] == column[row]) {
				return false;
			}
			
			//대각선 검사, 상위 노드위 퀸과 현재 노드의 퀸의 가로 세로 거리가 같은지 검사
			//i행과 row행의 열 값이 대각선 위치에 존재하면 퀸을 놓을 수 없다.
			if (Math.abs(i - row) == Math.abs(column[i] - column[row])) {
				return false;
			}
			
		}
		
		
		return true;
	} 
}












