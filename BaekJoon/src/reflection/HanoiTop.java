package reflection;

import java.util.Scanner;

public class HanoiTop {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		//하노이의 탑 전체 경우의 수 - 2^n - 1
		sb.append((int)Math.pow(2, n)-1 + "\n");
		
		cycle(n, 1, 2, 3);
		
		System.out.println(sb);
	}

	private static void cycle(int n, int one, int two, int three) {
		
		if (n == 1) {
			sb.append(one + " " + three + "\n");
		} else {
			//하노이의 탑 진행과정 
			//n-1번째까지의 돌을 A에서 B로 옮긴다.
			//n번째 돌을 A에서 C로 옮긴다.
			//1에서 빼놓았던 n-1번째까지의 돌을 B에서 C로 옮긴다.
			
			cycle(n-1, one, three, two);
			sb.append(one + " " + three + "\n");
			cycle(n-1, two, one, three);
			
		}
		
		
	}

}
