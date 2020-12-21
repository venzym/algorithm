package munjaul;

import java.util.Scanner;

public class String_Nineth {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String input = scan.next();
		
		for (int i=0; i<alpha.length; i++) {
			input = input.replace(alpha[i], "q");
		}
		
		System.out.println(input.length());
	}
}
