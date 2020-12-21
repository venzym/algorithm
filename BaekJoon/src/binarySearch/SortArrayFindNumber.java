package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortArrayFindNumber {
	/**
	 * 나동빈 - 정렬된 배열에서 특정 수의 개수 구하기(p.367)
	 */
	public static void main(String[] args) throws IOException {
		
		//N개의 원소
		//x가 등장하는 횟수
		
		//이진탐색 2번 실행
		//첫위치와 마지막위치를 찾아야 한다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] array = new int[n];
		st = new StringTokenizer(reader.readLine());

		for (int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		int result = binarySearch(array, x, x);
		
		if (result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
		
	}

	private static int binarySearch(int[] array, int leftValue, int rightValue) {

		int rightIndex = uppderBound(array, rightValue, 0, array.length);
		int leftIndex = lowerBound(array, leftValue, 0, array.length);
		
		return rightIndex - leftIndex;
	}

	private static int lowerBound(int[] array, int target, int start, int end) {
		
		while (start < end) {
			int mid = (start + end)/2;
			if (array[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return end;
	}//lowerBound

	private static int uppderBound(int[] array, int target, int start, int end) {
		
		while (start < end) {
			int mid = (start + end)/2;
			if (array[mid] > target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		
		return end;
	}//upperBound

}




