package function;

import java.util.Scanner;

public class Func_Third {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int result = 0;
		
		if (num < 100) {
			System.out.println(num);
		} else {
			if (num == 1000) {
				result--;
			}

			for (int i=100; i<=num; i++) {
				result += cal(i);
			}
			
			System.out.println(99+result);
		}
		
		
	}//main

	private static int cal(int num) {
		
		int a = (num/100)%10;
		int b = (num/10)%10;
		int c = num%10;
		
		if ((b-a) == (c-b)) {
			return 1;
		}
		return 0;
		
	}
}
