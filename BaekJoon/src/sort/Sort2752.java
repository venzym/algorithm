package sort;

import java.util.Scanner;

public class Sort2752 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] array = new int[3];
		for (int i=0; i<3; i++) {
			array[i] = scan.nextInt();
		}
		
		int temp=0, index=0;
		for (int i=0; i<3; i++) {
			int min=1000001;
			for (int j=i; j<3; j++) {
				if (min>array[j]) {
					min = array[j];
					index = j;
				}
			}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		
		for (int i=0; i<3; i++) {
			System.out.print(array[i] + " ");
		}
		
	}
}
