package munjaul;

import java.util.Scanner;

public class String_Third {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		int[] num = new int[input.length()];
		
		for (int i=0; i<input.length(); i++) {
			num[i] = input.charAt(i);
		}
		
		for (int i=97; i<=122; i++) {
			
			int result = 0;
			for (int j=0; j<input.length(); j++) {
				if (i == num[j]) {
					result = j;
					break;
				} else {
					result = -1;
				}
			}
			
			if (result == -1) {
				System.out.printf("%d ", -1);
			} else {
				System.out.printf("%d ", result);
			}
		}
		
		
	}
}
