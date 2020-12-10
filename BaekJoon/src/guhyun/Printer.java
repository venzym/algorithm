package guhyun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Printer {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		ArrayList<Integer> result = new ArrayList();
		
		//n : 문서 개수
		//m : 현재 위치
		//n개의 중요도
		
		for (int i=0; i<num; i++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int priorities[] = new int[n];
			
			for (int j=0; j<n; j++) {
				priorities[j] = sc.nextInt();
			}
			
//			Queue<Temp> q = new LinkedList<Temp>();
//			for (int j=0; j<n; j++) {
//				q.add(new Temp(j, priorities[j]));
//			}
			
			math(n, m, priorities, result);
		}
		
		for (int i : result) {
			System.out.println(i);
		}
		
	}

	private static void math(int n, int m, int[] priorities, ArrayList<Integer> result) {
		
		Queue<Temp> q = new LinkedList<Temp>();
		
		for (int i=0; i<priorities.length; i++) {
			q.add(new Temp(i, priorities[i]));
		}
		
		while (!q.isEmpty()) {
			
			int num = q.peek().prior;
			
			boolean flag = false;
			
			for (Temp t : q) {
				if (num < t.prior) {
					flag = true;
				}
			}
			
			if (flag) {
				//큰 프린터 존재
				q.add(q.poll());
			} else {
				if (q.poll().location == m) {
					result.add(n - q.size());
				}
			}
			
		}
		
	}
}

class Temp {
	int location;
	int prior;
	
	Temp(int location, int prior) {
		this.location = location;
		this.prior = prior;
	}
}
