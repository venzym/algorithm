package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindComponent {
	/**
	 * 나동빈 - 부품 찾기 (p.197)
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());

		int[] nArray = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=0; i<n; i++) {
			nArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nArray);
		
		int m = Integer.parseInt(reader.readLine());
		int[] mArray = new int[m];
		st = new StringTokenizer(reader.readLine());
		for (int i=0; i<m; i++) {
			mArray[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<mArray.length; i++) {
			int num = mArray[i];
			
			int result = binarySearch(nArray, num, 0, n-1);
			
			if (result == -1) {
				sb.append("no ");
			} else {
				sb.append("yes ");
			}
		}
		
		System.out.println(sb);
		
	}

	private static int binarySearch(int[] nArray, int target, int start, int end) {
		
		if (start > end) {
			return -1;
		}
		
		int mid = (start + end)/2;
		
		if (nArray[mid] == target) {
			return mid;
		} else if (nArray[mid] > target) {
			return binarySearch(nArray, target, start, mid-1);
		} else {
			return binarySearch(nArray, target, mid+1, end);
		}
		
	}//binarySearch

}






