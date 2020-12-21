package Banbok;

import java.util.Scanner;

public class AhapB {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		
		for (int i=0; i<n; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();

			System.out.printf("Case #%d: %d + %d = %d\n", i+1, a, b, a+b);
		}
		
	}
}
