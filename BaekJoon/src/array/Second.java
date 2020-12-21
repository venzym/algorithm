package array;

import java.util.Scanner;

public class Second {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] result = new int[9];
		
		int max = 0;
		int num = 0;
		
		for (int i=0; i<9; i++) {
			result[i] = scan.nextInt();
			if (result[i] > 100) {
				i--;
			}
		}
		
		for (int i=0; i<9; i++) {
			if (result[i] > max) {
				num = i+1;
				max = result[i];
			}
		}
		
		System.out.println(max);
		System.out.println(num);
		
	}
}
