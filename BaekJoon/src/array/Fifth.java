package array;

import java.util.Arrays;
import java.util.Scanner;

public class Fifth {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[10];
		
		for (int i=0; i<10; i++) {
			int num = scan.nextInt();
			arr[i] = num%42;
		}
		
		Arrays.sort(arr);
		
		int count = 10;
		
		for (int i=1; i<10; i++) {
			if (arr[i] == arr[i-1]) {
				count--;
			}
		}
		
		System.out.println(count);
		
		
	}
}

//		int[] arr = new int[10];
//		
//		for (int i=0; i<10; i++) {
//			arr[i] = scan.nextInt();
//		}
//		
//		int count = 10;
//		
//		for (int i=0; i<10; i++) {
//			int num = arr[i]%42;
//			System.out.println(num);
//			for (int j=0; j<10; j++) {
//				int num2 = arr[j]%42;
//				
//				if (num == num2) {
//					if (i == j) {
//						break;
//					} else {
//						count--;
//					}
//				}
//			}
//		}
//		
//		System.out.println(count);