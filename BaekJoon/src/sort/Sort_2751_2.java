package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort_2751_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] list = new int[n];
		
		for (int i=0; i<n; i++) {
			list[i] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		for (int i : list) {
			System.out.println(i);
		}
		
	}
}
