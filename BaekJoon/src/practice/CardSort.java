package practice;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CardSort {
	public static void main(String[] args) {
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			pq.add(sc.nextLong());
		}
		
		long num = 0;
		
		while (pq.size() > 1) {
			
			long temp1 = pq.poll();
			long temp2 = pq.poll();
			
			num += temp1 + temp2;
			
			pq.add(temp1 + temp2);
			
		}
		
		System.out.println(num);
		
	}
}








