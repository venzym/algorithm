package reflection;

import java.util.Scanner;

public class Pivonachi5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(cycle(n));
	}

	private static int cycle(int num) {
		
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		
		return cycle(num-1) + cycle(num-2);
		
	}
}
