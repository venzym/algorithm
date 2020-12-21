package stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Stack_1874_2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<String> array = new ArrayList<String>();
		
		//개수
		int num = sc.nextInt();

		int[] list = new int[num];
		
		for (int i=0; i<list.length; i++) {
			list[i] = sc.nextInt();
		}
		
		int index = 0;
		
		for (int i=1; i<=num; i++) {
			stack.push(i);
			array.add("+");
			while (!stack.isEmpty() && stack.peek() == list[index]) {
				stack.pop();
				array.add("-");
				index++;
			}
		}
		
		for (String st : array) {
			System.out.println(st);
		}
		
	}
}
