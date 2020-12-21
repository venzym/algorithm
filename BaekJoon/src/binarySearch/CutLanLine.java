package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutLanLine {
	/**
	 * 백준 1654 랜선 자르기 (https://www.acmicpc.net/problem/1654)
	 */
	public static void main(String[] args) throws IOException {
		
		//랜선 N개
		//K개 보유중 - 길이 제각각
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] line = new int[k];
		
		long start = 1;
		long end = 0;
		
		for (int i=0; i<k; i++) {
			line[i] = Integer.parseInt(reader.readLine());
			end = Math.max(end, line[i]);
		}
		
		Arrays.sort(line);
		
		long result = 0;
		
		while (start <= end) {
			
			long length = 0;
			
			long mid = (start+end)/2;
			
			for (int i=0; i<k; i++) {
				length += line[i]/mid;
			}
			
			if (length < n) {
				end = mid-1;
			} else {
				start = mid+1;
				result = Math.max(mid, result);
			}
			
		}//while
		
		System.out.println(result);
		
	}

}









