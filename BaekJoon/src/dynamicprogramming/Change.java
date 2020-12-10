package dynamicprogramming;

import java.util.Scanner;

public class Change {
	/**
	 * 백준 14916 거스름돈 (https://www.acmicpc.net/problem/14916)
	 */
	public static void main(String[] args) {
		
		//2원, 5원 거스름돈
		
		//동전 개수 최소
		
		//n : 거스름돈
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int count = 0;
		
		while (n>0) {
			//5로 나뉘는 경우
			if (n%5==0) {
				count = n/5 + count;
				break;
			}
			
			//5로 나뉘지 않으면 2씩 빼기
			n -=2;
			count++;
		}
		
		if (n < 0) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}
		
		
	}
}









