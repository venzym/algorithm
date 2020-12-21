package array;

import java.util.Scanner;

public class One {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		
		int[] list = new int[a];
		
		for (int i=0; i<a; i++) {
			list[i] = scan.nextInt();
		}
		
		int min = 1000000;
		int max = -1000000;
		
		for (int i=0; i<a; i++) {
			if (min > list[i]) {
				min = list[i];
			}
			if (max < list[i]) {
				max = list[i];
			}
		}
		
		System.out.println(min + " " + max);
		
	}
}
