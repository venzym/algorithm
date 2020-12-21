package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Stack_1406_2 {
	public static void main(String[] args) throws IOException {

		// L 왼쪽
		// D 오른쪽
		// B 삭제
		// P 문자 추가

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 왼쪽
		Stack<String> left = new Stack<String>();
		// 오른쪽(pop시)
		Stack<String> right = new Stack<String>();

		// 문자입력받기
		String munja = reader.readLine();
		String[] list = munja.split("");

		for (int i = 0; i < list.length; i++) {
			left.push(list[i]);
		}
		
		int num = Integer.parseInt(reader.readLine());

		for (int i=0; i<num; i++) {
			
			String input = reader.readLine();
			char c = input.charAt(0);
			
			if (c == 'L' && !left.isEmpty()) {
				right.push(left.pop());
			} else if (c == 'D' && !right.isEmpty()) {
				left.push(right.pop());
			} else if (c == 'B' && !left.isEmpty()) {
				left.pop();
			} else if (c == 'P') {
				left.push(String.valueOf(input.charAt(2)));
			}
		}
		

		while (!left.isEmpty()) {
			right.push(left.pop());
		}

		while (!right.isEmpty()) {
			System.out.print(right.pop());
		}
	}
}
