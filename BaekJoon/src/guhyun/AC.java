package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class AC {
	/**
	 * 백준 5430 AC (https://www.acmicpc.net/problem/5430)
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(reader.readLine());

		StringBuilder sb = new StringBuilder();
		
		for (int time = 0; time < t; time++) {

			String p = reader.readLine();// 함수
			
			int n = Integer.parseInt(reader.readLine());// 배열 개수
			String input = reader.readLine();

			if (isError(p, n)) {
				sb.append("error\n");
				continue;
			}

			String[] array = input.replace("[", "").replace("]", "").split(",");

			Deque<Integer> deque = new LinkedList<Integer>();
			for (String s : array) {
				if (!s.equals("")) {
					deque.add(Integer.parseInt(s));
				}
			}

			boolean flag = false;
			for (int i=0; i<p.length(); i++) {
				char c = p.charAt(i);
				if (c == 'R') {
					// R
					flag = !flag;
				} else {
					// D
					if (flag) {
						deque.removeLast();
					} else {
						deque.removeFirst();
					}
				}
			}

			String result = answer(deque, flag);
			
			sb.append(result.toString().replace(",]", "]"));

		}

		System.out.print(sb);
	}// main

	private static String answer(Deque<Integer> deque, boolean flag) {

		StringBuilder result = new StringBuilder();
		
		result.append("[");
		while(!deque.isEmpty()) {
			result.append(flag ? deque.removeLast() : deque.removeFirst());

			if (deque.size()!=0) {
				result.append(",");
			}
		}

		result.append("]\n");
		
		return result.toString();
	}

	private static boolean isError(String p, int n) {

		int count = 0;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == 'D') {
				count++;
			}
		}

		return n < count;
	}//isError
}
