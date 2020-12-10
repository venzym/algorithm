package guhyun;

import java.util.Scanner;
import java.util.Stack;

public class Zero {
	/**
	 * 백준 10773 제로 (https://www.acmicpc.net/problem/10773)
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i=0; i<k; i++) {
			int input = sc.nextInt();
			
			if (input != 0) {
				stack.push(input);
			} else if (input == 0) {
				stack.pop();
			}
		}
		
		int sum = 0;
		for (int i=0; i<stack.size(); i++) {
			sum += stack.pop();
			i--;
		}
		System.out.println(sum);
	}
}














