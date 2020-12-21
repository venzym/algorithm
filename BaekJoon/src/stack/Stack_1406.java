package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_1406 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//문자열
		String input = br.readLine();
		
		//연산 개수
		int n = Integer.parseInt(br.readLine());
		
		//왼쪽(기존 문자)
		Stack<String> left = new Stack<String>();
		//오른쪽(pop시 활용)
		Stack<String> right = new Stack<String>();
		
		String[] list = input.split("");
		//left에 기존 문자열 순서대로 넣기
		for (int i=0; i<list.length; i++) {
			left.push(list[i]);
		}
		
		for (int i=0; i<n; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			
			if (c == 'L' && !left.isEmpty()) {
				//왼쪽으로 이동시 하나 오른쪽으로 이동
				right.push(left.pop());
			} else if (c == 'D' && !right.isEmpty()) {
				//오른쪽으로 이동시 하나 왼쪽으로 이동
				left.push(right.pop());
			} else if (c == 'B' && !left.isEmpty()) {
				//삭제
				left.pop();
			} else if (c == 'P') {
				//추가
				left.push(String.valueOf(command.charAt(2)));
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
