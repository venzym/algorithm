package practice;

import java.util.Scanner;

public class TwoNTiling_2 {
	private static int[] map;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		map = new int[n+1];
		
		System.out.println(cycle(n));
		
	}//main

	private static int cycle(int n) {
		
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}
		
		if (map[n] != 0) {
			return map[n];
		}
		
		return map[n] = (cycle(n-1) + cycle(n-2)) % 10007;
	}
}














