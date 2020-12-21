package Banbok;

import java.util.Scanner;

public class Hap {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int sum = 0;
		
		for (int i=n; i>0; i--) {
			sum += i;
		}
		System.out.println(sum);
	}
}
