package sort;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CardSort {
	/**
	 * 백준 1714 카드 정렬하기 (https://www.acmicpc.net/problem/1715)
	 */
	public static void main(String[] args) {
		
		//A+B번 비교
		//고르는 순서에 따라 비교 횟수가 달라짐
		//N max 100000
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for (int i=0; i<n; i++) {
			pq.add(sc.nextLong());
		}
		
		long num = 0;
		//우선순위 큐에 2개이상 들어있어야 비교가 가능하다.
		while (pq.size() > 1) {
			long temp1 = pq.poll();
			long temp2 = pq.poll();
			
			num += temp1 + temp2;
			pq.add(temp1 + temp2);
		}
		
		System.out.println(num);
		
	}
}









