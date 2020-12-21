package Input_cal;

import java.util.Scanner;

public class ThreeNum {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] input = new int[3];
		int temp = 0;
		
		for (int i=0; i<input.length; i++) {
			input[i] = scan.nextInt();
		}
		
		for (int i=0; i<input.length; i++) {
			for (int j=0; j<input.length; j++) {
				if (input[i] > input[j]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		
		System.out.println(input[1]);
		
	}
}
