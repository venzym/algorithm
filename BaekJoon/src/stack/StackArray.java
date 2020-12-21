package stack;

import java.util.Stack;

public class StackArray {
	static int[] arr = { 8, 4, 3, 6, 8, 7, 5, 2, 1 };
	public Stack stk;
	public static Stack stkResult;

	public StackArray() {
		this.stk = new Stack();
		this.stkResult = new Stack();
	}

	public static void main(String args[]) {
		Stack s = new Stack();
		Stack stkResult = new Stack();

		for (int j = 1; j < arr[0] + 1; j++) {
			for (int i = 1; i < arr.length; i++) { // 주어진 기준 스택

				if (j == arr[i + 1]) {
					stkResult.push("+");

				} else {
					if (!s.empty()) {
						s.pop();
						stkResult.push("-");
					} else {
						continue;
					}

				}
				
				
			}

		}
		System.out.println(stkResult);
	}

}
