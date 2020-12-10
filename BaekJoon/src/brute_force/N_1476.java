package brute_force;

import java.util.Scanner;

public class N_1476 {
	public static void main(String[] args) {
		
		//지구	 태양 	달
		//E    	 S    	M
		//1~15	 1~28	1~19
		
		Scanner sc = new Scanner(System.in);
		
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		
		int year = 0;
		
		while (true) {
			year++;
			if ((year-e)%15 == 0 && (year-s)%28 == 0 && (year-m)%19 == 0) {
				break;
			}
		}
		System.out.println(year);
		
		
	}
}
