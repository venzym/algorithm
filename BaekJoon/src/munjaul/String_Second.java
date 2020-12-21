package munjaul;

import java.util.Scanner;

public class String_Second {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//개수
		int num = scan.nextInt();
		
		int sum=0;
		String input = scan.next(); 
		
		for (int i=0; i<num; i++) {
			sum += input.charAt(i)-'0';
		}
		
		System.out.println(sum);
		
	}
}
