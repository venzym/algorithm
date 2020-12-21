package munjaul;

import java.util.Scanner;

public class String_Tenth {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//개수
		int num = scan.nextInt();
		
		int result = num;
		
		for (int i=0; i<num; i++) {
			String input = scan.next();
			boolean[] check = new boolean[26];
			
			for (int j=1; j<input.length(); j++) {
				if (input.charAt(j-1) != input.charAt(j)) {
					if (check[input.charAt(j)-97] == true) {
						result--;
						break;
					}
					check[input.charAt(j-1) - 97] = true;
				}
			}
		}	
		System.out.println(result);
		
	}
}
