package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MemorizationKing {
	/**
	 * 백준 2776 암기왕 (https://www.acmicpc.net/problem/2776)
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//m개의 질문
		//x라는 정수를 오늘 보았는가?
		
		//n : 1000000(백만)
		//m : 1000000(백만)
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(reader.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while (t-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			
			int[] note1 = new int[n];
			
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int i=0; i<n; i++) {
				note1[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(note1);
			
			int m = Integer.parseInt(reader.readLine());
			
			st = new StringTokenizer(reader.readLine());
			for (int i=0; i<m; i++) {
				int num = Integer.parseInt(st.nextToken());
				sb.append(Arrays.binarySearch(note1, num) > -1 ? "1\n" : "0\n");
			}
			
		}
		
		System.out.print(sb);
	}
}







