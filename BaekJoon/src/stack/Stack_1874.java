package stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Stack_1874 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<Integer>();

		//+, - 담을 리스트
		ArrayList<String> array = new ArrayList<String>();
		
		//개수
		int num = sc.nextInt();
		
		//1~num까지 들어갈 배열
		int[] list = new int[num];
		for (int i=0; i<num; i++) {
			list[i] = sc.nextInt();
		}
		
		//수열 index
		int index = 0;
		
		for (int i=1; i<=num; i++) {
			stack.push(i);
			array.add("+");
			while (!stack.isEmpty()) {
				//stack의 탑과 리스트가 같은 경우
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
