package guhyun;

import java.util.Scanner;

public class RoomNumber {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int arr[] = new int[10];
		int temp = 0;
		int min = 0;
		
		for (int i=0; i<str.length(); i++) {
			temp = str.charAt(i) -'0';
			arr[temp]++;
		}
		
		int k = arr[6] + arr[9];
		
		if (k % 2 == 0) {
			//짝수개일때 세트 1개면 가능하다.
			arr[6] = k/2;
			arr[9] = k/2;
		} else {
			//홀수개일때 1개 더 필요하다(세트 1개로 불가능하다)
			arr[6] = k/2 + 1;
			arr[9] = k/2 + 1;
		}
		
		for (int i=0; i<arr.length; i++) {
			min = Math.max(min, arr[i]);
		}
		System.out.println(min);
	}
}
