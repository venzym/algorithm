package array;

import java.util.Scanner;

public class Fourth {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		String result = String.format("%d", a*b*c);
		
		int zero = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		int seven = 0;
		int eight = 0;
		int nine = 0;

		for (int i=0; i<result.length(); i++) {
			if (result.charAt(i) == '0') {
				zero++;
			} else if (result.charAt(i) == '1') {
				one++;
			} else if (result.charAt(i) == '2') {
				two++;
			} else if (result.charAt(i) == '3') {
				three++;
			} else if (result.charAt(i) == '4') {
				four++;
			} else if (result.charAt(i) == '5') {
				five++;
			} else if (result.charAt(i) == '6') {
				six++;
			} else if (result.charAt(i) == '7') {
				seven++;
			} else if (result.charAt(i) == '8') {
				eight++;
			} else if (result.charAt(i) == '9') {
				nine++;
			}
		}
		
		int[] arr = {zero, one, two, three, four, five, six, seven, eight, nine};
		
		for (int d : arr) {
			System.out.println(d);
		}
		
	}
}
