package Wwwwhile;

import java.util.Scanner;

public class AB4 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextInt()) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println(a + b);
		}
		
	}
}
