package munjaul;

import java.util.Scanner;

public class String_Eight {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.next();
		
		int sum = 0;
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			if (c >= 65 && c < 68) {
				sum += 3;
			} else if (c >= 68 && c < 71) {
				sum += 4;
			} else if (c >= 71 && c < 74) {
				sum += 5;
			} else if (c >= 74 && c < 77) {
				sum += 6;
			} else if (c >= 77 && c < 80) {
				sum += 7;
			} else if (c >= 80 && c < 84) {
				sum += 8;
			} else if (c >= 84 && c < 87) {
				sum += 9;
			} else if (c >= 87 && c < 91) {
				sum += 10;
			}
		}
		
		System.out.println(sum);
		
	}
}
