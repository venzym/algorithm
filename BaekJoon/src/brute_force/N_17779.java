package brute_force;

import java.util.Scanner;

public class N_17779 {
	private static int n;
	private static int[][] people;
	private static int[][] area;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		people = new int[n+1][n+1];
		area = new int[n+1][n+1];
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				people[i][j] = sc.nextInt();
			}
		}
		
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				//모든 d1, d2 탐색
				for (int d1=1; d1<n; d1++) {
					for (int d2=1; d2<n; d2++) {
						if (i + d1 + d2 <= n && 1 <= j - d1 && j + d2 <= n) {
							area1(i,j,d1,d2); //1번 선거구
							area2(i,j,d1,d2); //2번 선거구
							area3(i,j,d1,d2); //3번 선거구
							area4(i,j,d1,d2); //4번 선거구
							
							area5(i,j,d1,d2); //5번 선거구
						}
					}
				}
			}
		}
	}

	private static void area1(int x, int y, int d1, int d2) {
		//1번 선거구
		for (int i=1; i<x+d1; i++) {
			for (int j=1; j<=y; j++) {
				area[i][j] = 1;
			}
		}
		
	}

	private static void area2(int x, int y, int d1, int d2) {
		//2번 선거구
		for (int i=1; i<=x+d2; i++) {
			for (int j=y; j<=n; j++) {
				area[i][j] = 2;
			}
		}
		
	}

	private static void area3(int x, int y, int d1, int d2) {
		//3번 선거구
		for (int i=x+d1; i<=n; i++) {
			for (int j=1; j<y-d1+d2; j++) {
				area[i][j] = 3;
			}
		}
		
	}

	private static void area4(int x, int y, int d1, int d2) {
		//4번 선거구
		for (int i=x+d2; i<=n; i++) {
			for (int j=y-d1+d2; j<=n; j++) {
				area[i][j] = 4;
			}
		}
		
	}

	private static void area5(int x, int y, int d1, int d2) {
		
		//흐음..
		//경계선 || 내부
		
		//경계선
		
		//(x, y), (x+1, y-1), ..., (x+d1, y-d1)
		for (int i=0; i<=d1; i++) {
			area[x+i][y-i] = 5;
		}
		
		//(x, y), (x+1, y+1), ..., (x+d2, y+d2)
		for (int i=0; i<=d2; i++) {
			area[x+i][y+i] = 5;
		}
		
		//(x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
		for (int i=0; i<=d1; i++) {
			area[x+i+d2][y-i-d2] = 5;
		}
		
		//(x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
		for (int i=0; i<=d2; i++) {
			area[x+i+d1][y+i-d1] = 5;
		}
		
		//내부
		//음...음.ㅁ.ㅇ.ㅁ.ㄴ.ㅁㅇ....
		
	}

}
