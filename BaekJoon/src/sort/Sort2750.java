package sort;

import java.util.Scanner;

public class Sort2750 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int[] array = new int[num];
		
		for (int i=0; i<num; i++) {
			array[i] = scan.nextInt();
		}
		
		//-------------------------------
		//선택정렬
		int temp=0, index=0;
		for (int i=0; i<num; i++) {
			int min = 9999;
			for (int j=i; j<num; j++) {
				if (min > array[j]) {
					min = array[j];
					index = j;
				}
			}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
			
		}
		
		for (int i=0; i<num; i++) {
			System.out.println(array[i]);
		}
		
	}
}
