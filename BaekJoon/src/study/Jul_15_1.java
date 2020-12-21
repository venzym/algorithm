package study;

import java.util.Scanner;

public class Jul_15_1 {

	static int n = 4;
	static int m = 4;
	static int t = 1;
	
	static int[][] circle;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		circle = new int[n][m];
		
		//수 입력
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(i + "번째 원 " + j + "번째 숫자 입력 : ");
				circle[i][j] = scan.nextInt();
				System.out.println();
			}
		}

		
		int x = 2; // 2의배수
		//scan.nextInt();
		int d = 0; // 시계방향
		//scan.nextInt();
		int k = 1; // 1칸 회전
		//scan.nextInt();
		
		
		
		// 원판 돌리기
		move(x, d);
		
		
		// 같은 원판에서 각 수 기준 인접한 수 탐색 = ?? 음...
		boolean isFound = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				
			}
		}
		
		
		
		
		
		// 다른 원판에서 인접한 수 탐색
		
		
		
		
		
	}

	// 원판 돌리기
	private static void move(int x, int d) {
		for (int i=1; i<=n; i++) {
			//x의 배수일 때 
			if (i%x == 0) {
				if (d == 0) {
					//시계방향으로 1칸 회전
					
					//마지막 변수 저장
					int last = circle[i][m];
					
					//1칸씩 오른쪽으로 옮기기(마지막은 제외)
					for (int j = 0; j < m-1; j++) {
						circle[i][j] = circle[i][j+1];
					}
					circle[i][0] = last;
					
				} else if (d == 1) {
					//반시계방향으로 1칸 회전
					
					//처음 변수 저장
					int first = circle[i][0];
					
					//1칸씩 왼쪽으로 옮기기(첫번째는 제외)
					for (int j = m; j > 0; j--) {
						circle[i][j-1] = circle[i][j];
					}
					circle[i][m] = first;
				}
				
			} 
		}
		
		
		change(circle);
	}

	private static void change(int[][] circle) {
		boolean isFound = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				if (circle[i][j] == circle[i][(j+1) % m]) {
					circle[i][j] = 0;
					circle[i][(j+1) % m] = 0;
					
					if (circle[i][j] != 0) isFound = true;
				}
			}
		}
	}
}

/*
4	4	1
1	1	2	3
5	2	4	2
3	1	3	5
2	1	3	2
2	0	1

2,4,6,... 을 시계방향으로 1칸 돌리기
*/
