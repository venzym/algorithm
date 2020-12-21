package argorithmStudy;

import java.util.Arrays;
import java.util.Scanner;

public class ByeFineDust {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int line = sc.nextInt();
		int row = sc.nextInt();
		int second = sc.nextInt();
		
		int num[][] = new int[line][row];
		int spread[][] = new int[line][row];
		
		for (int i=0; i<line; i++) {
			for (int j=0; j<row; j++) {
				int input = sc.nextInt();
				num[i][j] = input;
				spread[i][j] = input;
			}
		}
		
//		int[][] num = {{0, 0, 0, 0, 0, 0, 0, 9},
//						{0, 0, 0, 0, 3, 0, 0, 8},
//						{-1, 0, 5, 0, 0, 0, 22, 0},
//						{-1, 8, 0, 0, 0, 0, 0, 0},
//						{0, 0, 0, 0, 0, 10, 43, 0},
//						{0, 0, 5, 0, 15, 0, 0, 0},
//						{0, 0, 40, 0, 0, 0, 20, 0}};
//		
//		
//		int[][] spread = {{0, 0, 0, 0, 0, 0, 0, 9},
//						{0, 0, 0, 0, 3, 0, 0, 8},
//						{-1, 0, 5, 0, 0, 0, 22, 0},
//						{-1, 8, 0, 0, 0, 0, 0, 0},
//						{0, 0, 0, 0, 0, 10, 43, 0},
//						{0, 0, 5, 0, 15, 0, 0, 0},
//						{0, 0, 40, 0, 0, 0, 20, 0}};
		
		//인접 4방향 확산
		//공기청정기(-1), 칸이 없을때 체크(열 1 or 8)
		//인접으로 n/5씩 확산
		
		//비교는 num으로 하고, 적용은 spread에 한다.
		
		for (int i=0; i<num.length; i++) {
			for (int j=0; j<num[i].length; j++) {
				if (num[i][j] >= 5) {
					//1. 5이상 일때 확산 가능
					int temp = num[i][j]/5;
					//2. 현재 위치가 왼쪽 행이나 열이거나 오른쪽 행이나 열일 때
					if (i == 0 || j == 0 || i == num.length-1 || j == num[i].length-1) {
						if (i == 0) {
							//1행일때
							if (j == 0) {
								//1,1일때
								spread[i][j+1] += temp;
								spread[i+1][j] += temp;
								spread[i][j] -= temp*2; 
							} else if (j == num[i].length-1) {
								//1,8일때
								spread[i+1][j] += temp;
								spread[i][j-1] += temp;
								spread[i][j] -= temp*2;
							} else {
								//1, 2~7 일때
								spread[i-1][j] += temp;
								spread[i+1][j] += temp;
								spread[i][j+1] += temp;
								spread[i][j] -= temp*3;
								
							}
							
						} else if (i == num.length-1) {
							//맨마지막 행일때
							if (j == 0) {
								//7,1
								spread[i-1][j] += temp;
								spread[i][j+1] += temp;
								spread[i][j] -= temp*2;
							} else if (j == num[i].length-1) {
								//7,8
								spread[i-1][j] += temp;
								spread[i][j-1] += temp;
								spread[i][j] -= temp*2;
							} else {
								//7, 2~7
								spread[i-1][j] += temp;
								spread[i][j-1] += temp;
								spread[i][j+1] += temp;
								spread[i][j] -= temp*3;
							}
						} else if (j == 0 && (i > 0 && i < num.length)) {
							//2~6, 1
							//공기청정기
							if (num[i][j] != -1 && num[i-1][j] == -1) {
								//아래가 -1일때
								spread[i-1][j] += temp;
								spread[i][j+1] += temp;
								spread[i][j] -= temp*2;
							} else if (num[i][j] == -1) {
								//현재 위치가 -1일때
								continue;
							} else if (num[i][j] != -1 && num[i-1][j] == -1) {
								//위가 -1일때
								spread[i+1][j] += temp;
								spread[i][j+1] += temp;
								spread[i][j] -= temp*2;
							} else if (num[i][j-1] == -1) {
								//왼쪽이 -1일때
								spread[i-1][j] += temp;
								spread[i][j+1] += temp;
								spread[i+1][j] += temp;
								spread[i][j] -= temp*3;
							}
							
							
						} else if (j == num[i].length-1 && (i > 0 && i < num.length)) {
							//2~7, 8
							spread[i-1][j] += temp;
							spread[i][j-1] += temp;
							spread[i+1][j] += temp;
							spread[i][j] -= temp*3;
						}
					} else {
						//내부
						if (num[i][j-1] == -1) {
							//왼쪽에 공기청정기 있을 때
							spread[i-1][j] += temp;
							spread[i+1][j] += temp;
							spread[i][j+1] += temp;
							spread[i][j] -= temp*3;
						} else {
							spread[i-1][j] += temp;
							spread[i][j-1] += temp;
							spread[i+1][j] += temp;
							spread[i][j+1] += temp;
							spread[i][j] -= temp*4;
						}
					}
				
				}
			}
		}
		
//		for (int i=0; i<num.length; i++) {
//			for (int j=0; j<num[i].length; j++) {
//				System.out.print(num[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		for (int i=0; i<spread.length; i++) {
//			for (int j=0; j<spread[i].length; j++) {
//				System.out.print(spread[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println();
		
		//---------------------------------------------
		
		//공기청정기 작동
		//1~3 
		//3 -> 2 -> 1 -> 2 순서
		
		for (int i=0; i<=2; i++) {
			if (i < 2) {
				for (int j=0; j<spread[i].length; j++) {
					
					if (i == 0) {
						if (j == 0) {
							//1번째는 밑으로
							spread[i+1][j] = spread[i][j];
						} else if (j > 0 && j < spread[i].length-1) {
							//나머지는 <- 방향으로 이동
							//2~7까지 왼쪽으로
							spread[i][j] = spread[i][j+1];
						} else {
							//j == 8일때 아래것 가져오기
							spread[i][j] = spread[i+1][j];
						}
						
						
					} else if (i == 1) {
						if (j == 0) {
							//공기청정기행
							spread[i][j] = 0;
						} else if (j == spread[i].length-1) {
							spread[i][j] = spread[i+1][j];
						}
						
					} 
				}
				
			} else if (i == 2) {
				//-> 방향
				for (int j=spread[i].length-1; j>1; j--) {
					spread[i][j] = spread[i][j-1];
				}
				spread[i][1] = 0;
			}
		}
		
		
		// 4~7
		//4 -> 5 -> 6 -> 7 -> 6 -> 5
		for (int i=4; i<spread.length; i++) {
			for (int j=0; j<spread[i].length; j++) {
				
			if (i > 3 && i < 6) {
				//5~6
				if (j == 0) {
					//5,1 | 6,1
					spread[i][j] = spread[i+1][j];
				} 
			} else if (i == 6) {
				if (j < spread[i].length-1) {
					//7,1~7
					spread[i][j] = spread[i][j+1];
				} else {
					spread[i][j] = spread[i-1][j];
				}
			}
			}
		}
		
		for (int i=spread.length-2; i>=3; i--) {
			for (int j=spread[i].length-1; j>1; j--) {
				if (i > 3 && i < spread.length-1) {
					if (j == spread[i].length-1 ) {
						spread[i][j] = spread[i-1][j];
					}
				} else {
					spread[i][j] = spread[i][j-1];
				}
			}
			spread[i][1] = 0;
		}
		
//		for (int i=0; i<spread.length; i++) {
//			for (int j=0; j<spread[i].length; j++) {
//				System.out.print(spread[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
	}
}
