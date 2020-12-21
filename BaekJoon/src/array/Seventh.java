package array;

import java.util.Scanner;

public class Seventh {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		//OX 담을 배열
		String[] input = new String[num];

		//갯수 담을 배열
		int[] count = new int[num];
		
		for (int i=0; i<num; i++) {
			input[i] = scan.next();
			count[i] = 0;
		}
		
		int size = 0;
		int hap = 0;
		
		for (int i=0; i<num; i++) {
			
			for (int j=0; j<input[i].length(); j++) {

				if (input[i].charAt(j) == 'O') {
					size += 1;
					hap += size;
				} else if (input[i].charAt(j) == 'X') {
					size = 0;
				}
				
			}
			System.out.println(hap);
			count[i] = hap;
			size = 0;
			hap = 0;
		}
		
	}
}
