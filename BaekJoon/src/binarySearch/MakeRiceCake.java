package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakeRiceCake {
	/**
	 * 나동빈 - 떡볶이 떡 만들기 (p.201)
	 */
	public static void main(String[] args) throws IOException {
		// 떡볶이 떡의 길이가 일정하지 않음
		// 결과값 : m
		// 적어도 m만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());// 떡 개수
		int m = Integer.parseInt(st.nextToken());// 떡 길이

		int[] tteok = new int[n];

		st = new StringTokenizer(reader.readLine());
		int end = 0;
		for (int i = 0; i < n; i++) {
			tteok[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, tteok[i]);
		}

		Arrays.sort(tteok);

		int start = 0;
		int result = 0;
		
		while (start <= end) {
			long total = 0;
			int mid = (start + end)/2;
			
			for (int i=0; i<n; i++) {
				if (tteok[i] > mid) {
					total += tteok[i] - mid;
				}
			}
			
			if (total < m) {
				end = mid - 1;
			} else {
				start = mid + 1;
				result = mid;
			}
			
		}
		
		System.out.println(result);
		
	}

}





