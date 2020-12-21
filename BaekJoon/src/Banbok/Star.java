package Banbok;

import java.util.Scanner;

public class Star {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				System.out.print(" ");				
			}
			
			for (int j=n-i; j<=n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
