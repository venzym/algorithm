package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RainWater2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[] map = new int[w];
		st = new StringTokenizer(reader.readLine());
		for (int i=0; i<map.length; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int center = 0; 
		int right = 0;
		
		for (int i=1; i<map.length-1; i++) {
			left = right = 0;
			//왼쪽
			for (int j=0; j<i; j++) {
				left = Math.max(left, map[j]);
			}
			
			//오른쪽
			for (int j=i+1; j<map.length; j++) {
				right = Math.max(right, map[j]);
			}
			
			//가운데
			if (map[i] < left && map[i] < right) {
				center += Math.min(left, right) - map[i];
			}
			
		}
		
		System.out.println(center);
		
	}
}













