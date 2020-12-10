package reflection;

import java.util.Scanner;

public class HanoiTop_2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		int total = (int)Math.pow(2, n)-1;
		System.out.println(total);
		
		cycle(n, 1, 2, 3, sb);
		System.out.print(sb);
		
	}

	private static void cycle(int n, int one, int two, int three, StringBuilder sb) {
		
		if (n == 1) {
			sb.append(one + " " + three + "\n");
		} else {
			
			cycle(n-1, one, three, two, sb);
			sb.append(one + " " + three + "\n");
			cycle(n-1, two, one, three, sb);
		}
		
	}
}
