package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RainWater {
	private static int h, w;
	private static int[] block;
	private static int left, right, center;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split(" ");
		
		h = Integer.parseInt(input[0]);
		w = Integer.parseInt(input[1]);
		
		block = new int[w];
		
		input = reader.readLine().split(" ");
		for (int i=0; i<w; i++) {
			block[i] = Integer.parseInt(input[i]);
		}
		
		left = center = right = 0;
		
		//가운데 기준으로 왼쪽 오른쪽 큰 친구를 찾는다.
		for (int i=1; i<w-1; i++) {
			left = right = 0;
			//i기준 왼쪽 중 제일 높은 친구 찾기
			for (int j=0; j<i; j++) {
				left = Math.max(left, block[j]);
			}
			
			//i기준 오른쪽 중 제일 높은 친구 찾기
			for (int j=i+1; j<w; j++) {
				right = Math.max(right, block[j]);
			}
			
			//현재 block이 left와 right보다 작으면 더해주기
			if (block[i] < left && block[i] < right) {
				center += Math.min(left, right) - block[i];
			}
			
		}
		
		System.out.println(center);
	}
	
	
}












