package array;

import java.util.Scanner;

public class Six {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		int[] score = new int[a];
		
		float max = 0;
		for (int i=0; i<a; i++) {
			score[i] = scan.nextInt();
			
			if (max < score[i]) {
				max = score[i];
			}
		}
		
		float sum = 0;
		float avg = 0;
		
		for (int i=0; i<a; i++) {
			sum += (score[i]/max)*100;
		}
		
		avg = sum/a;
		
		System.out.println(avg);
		
	}
}








