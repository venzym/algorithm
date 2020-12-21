package munjaul;

import java.util.Scanner;

public class String_Sixth {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine().trim();
		
//		int index = 0;
		
//		for (int i=0; i<input.length(); i++) {
//			if (input.charAt(i) == ' ') {
//				index++;
//			}
//		}
		
		if (input.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(input.split(" ").length);
		}
		
//		System.out.println(index+1);
		
	}
}
