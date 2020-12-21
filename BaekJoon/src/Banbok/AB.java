package Banbok;

import java.util.Scanner;

public class AB {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		for (int i=0; i<num; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println(a + b);
		}
	}
}
