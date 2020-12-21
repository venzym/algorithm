package stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Stack_1874_3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		ArrayList<String> array = new ArrayList<String>();
		
		int[] list = new int[n];
		for (int i=0; i<n; i++) {
			list[i] = sc.nextInt();
		}
		
		int index = 0;
		
		for (int i=1; i<=n; i++) {
			stack.push(i);
			array.add("+");
			while(!stack.isEmpty()) {
				if (stack.peek() == list[index]) {
					stack.pop();
					array.add("-");
					index++;
				} else {
					break;
				}
			}
		}
		
		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			for (String st : array) {
				System.out.println(st);
			}
		}
		
	}
}
