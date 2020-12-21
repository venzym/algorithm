package Banbok;

import java.util.Scanner;

public class Xmin {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int max = scan.nextInt();
		
		for (int i=0; i<n; i++) {
			int input = scan.nextInt();
			if (input < max) {
				System.out.print(input + " ");
			}
		}
		
	}
}
