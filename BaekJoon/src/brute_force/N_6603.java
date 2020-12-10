package brute_force;

import java.util.Scanner;

public class N_6603 {
   private static int n;
   private static int[] array;
   private static int[] result = new int[6];
   
   public static void main(String[] args) {
	   
	   Scanner sc = new Scanner(System.in);
	   
	   while (true) {
		   n = sc.nextInt();
		   
		   if (n == 0) {
			   //입력값이 0일때 종료
			   break;
		   }
		   
		   array = new int[n];
		   for (int i=0; i<n; i++) {
			   array[i] = sc.nextInt();
		   }
		   
		   cycle(0,0);
		   System.out.println();
	   }
	   
   }

	private static void cycle(int start, int level) {
		
		if (start == 6) {
			//출력
			for (int i=0; i<6; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		} else {
			for (int i=level; i<n; i++) {
				//i=0부터 시작하면 모든 경우의 수 탐색 -> 시작지점을 level(i+1)로
				result[start] = array[i]; //값 넣기
				cycle(start+1, i+1); //다음값 재귀
			}
		}
		
	}

   
}