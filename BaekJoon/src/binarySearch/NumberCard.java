package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {
	/**
	 * 백준 10815 숫자 카드 (https://www.acmicpc.net/problem/10815)
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//카드 N개
		//정수 m개
		//가지고 있는지 아닌지 구하기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] card = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		for (int i=0; i<n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		int m = Integer.parseInt(reader.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(reader.readLine());
		for (int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int result = binarySearch(card, num, 0, n-1);
			
			sb.append(result != -1 ? "1 " : "0 ");
		}
	
		System.out.println(sb);
		
	}

	private static int binarySearch(int[] card, int target, int start, int end) {
		
		if (start > end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if (target == card[mid]) {
			return mid;
		} else if (card[mid] > target) {
			return binarySearch(card, target, start, mid-1);
		} else {
			return binarySearch(card, target, mid+1, end);
		}

	}//binarySearch
}






