package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {
	/**
	 * 백준 1920 수 찾기 (https://www.acmicpc.net/problem/1920)
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//정수 N개
		//X 존재하는지 알아내기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());

		int[] array = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		int m = Integer.parseInt(reader.readLine());
		int[] result = new int[m];
		
		st = new StringTokenizer(reader.readLine());
		for (int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int temp = binarySearch(array, num, 0, n-1);
			
			result[i] = temp != -1 ? 1 : 0;
		}
		
		for (int i=0; i<m; i++) {
			System.out.println(result[i]);
		}
		
	}

	private static int binarySearch(int[] array, int target, int start, int end) {
		
		if (start > end) {
			//시작이 커지면 일치하는것이 없다.
			return -1;
		}
		
		int mid = (start+end)/2;
		
		if (array[mid] == target) {
			//같을 때는 해당 위치가 구하고자 하는 위치
			return mid;
		} else if (array[mid] > target) {
			//배열의 mid값이 목표값보다 크면 end를 줄인다.
			return binarySearch(array, target, start, mid-1);
		} else {
			//배열의 mid값이 목표값보다 작으면 start를 늘린다.
			return binarySearch(array, target, mid+1, end);
		}
		
	}//binarySearch
}







