package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PutOperator {
	/**
	 * 백준 14888 연산자 끼워넣기 (https://www.acmicpc.net/problem/14888)
	 */
	private static int n;
	private static ArrayList<Character> operator = new ArrayList<Character>();
	private static ArrayList<Character> selectOper = new ArrayList<Character>();
	private static int[] numList;
	private static char[] operList;
	private static boolean[] visit;
	
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		numList = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=1; i<=n; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(reader.readLine());
		for (int i=0; i<4; i++) {
			int order = Integer.parseInt(st.nextToken());
			if (i==0) {
				//덧셈
				for (int j=0; j<order; j++) {
					operator.add('+');
				}
			} else if (i==1) {
				//뺄셈
				for (int j=0; j<order; j++) {
					operator.add('-');
				}
			} else if (i==2) {
				//곱셈
				for (int j=0; j<order; j++) {
					operator.add('*');
				}
			} else {
				//나눗셈
				for (int j=0; j<order; j++) {
					operator.add('/');
				}
			}
		}
	
		visit = new boolean[operator.size()+1];
		operList = new char[operator.size()+1];
		for (int i=1; i<=operator.size(); i++) {
			operList[i] = operator.get(i-1);
		}
		
		dfs(1,0);
		
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void dfs(int start, int count) {
		
		if (count == n-1) {
			//연산자 조합 가져온 것들로 연산
			calculate();
			
		} else {
			
			for (int i=1; i<=n-1; i++) {
				if (!visit[i]) {
					visit[i] = true;
					selectOper.add(operList[i]);
					dfs(i+1,count+1);
					selectOper.remove(selectOper.size()-1);
					visit[i] = false;
				}
			}
			
		}
		
	}//dfs

	private static void calculate() {
		
		int num = numList[1];
		for (int i=1; i<n; i++) {
			num = math(num, numList[i+1], selectOper.get(i-1));
		}

		max = Math.max(max, num);
		min = Math.min(min, num);
		
	}//calculate

	private static int math(int num1, int num2, Character c) {
		
		switch (c) {
		case '+':
			return num1+num2;
		case '-':
			return num1-num2;
		case '*':
			return num1*num2;
		case '/':
			return num1/num2;
		}
		
		return 0;
	}//math
}















