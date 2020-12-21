package array;

import java.util.Arrays;
import java.util.Scanner;

public class Third {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] list = new int[8];
		int[] asc = new int[8];
		int[] desc = new int[8];
		
		for (int i=0; i<8; i++) {
			list[i] = scan.nextInt();
			asc[i] = i+1;
			desc[i] = 8-i;
		}
		
		String result = "";
		
		if (Arrays.equals(list, asc)) {
			result = "ascending";
		} else if (Arrays.equals(list, desc)) {
			result = "descending";
		} else {
			result = "mixed";
		}
		
		System.out.println(result);
	}
}
