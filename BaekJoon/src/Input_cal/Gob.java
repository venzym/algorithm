package Input_cal;

import java.util.Scanner;

public class Gob {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.println(472*(b%10));
		System.out.println(472*((b%100)/10));
		System.out.println(472*(b/100));
		System.out.println(a*b);
	}
}
