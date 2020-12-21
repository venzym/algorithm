package munjaul;

import java.util.Scanner;

public class String_Seventh {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String first = scan.next();
		String second = scan.next();
		
		
		String firstResult = "";
		String secondResult = "";
		
		for (int i=first.length()-1; i>=0; i--) {
			firstResult += first.charAt(i);
		}

		for (int i=second.length()-1; i>=0; i--) {
			secondResult += second.charAt(i);
		}
		
		
		if (Integer.parseInt(firstResult) > Integer.parseInt(secondResult)) {
			System.out.println(firstResult);
		} else {
			System.out.println(secondResult);
		}
		
	}
}
