package brute_force;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SevenSmall {
	
	private static int[] heights = new int[9];
	private static boolean[] visit = new boolean[9];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<9; i++) {
			heights[i] = sc.nextInt();
		}
		
		StringBuilder sb = new StringBuilder();
		
		cycle(0, 0, sb);
		
		System.out.print(sb);
		
	}

	private static void cycle(int n, int cnt, StringBuilder sb) {
		
		if (cnt == 7) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int sum = 0;
			for (int i=0; i<9; i++) {
				if (visit[i] == true) {
					sum += heights[i];
					list.add(heights[i]);
				}
			}
			
			if (sum == 100) {
				Collections.sort(list);
				for (int i=0; i<list.size(); i++) {
					sb.append(list.get(i) + "\n");
					//System.out.println(list.get(i));
				}
			} else {
				return;
			}
			
		} else {
			
			for (int i=n; i<9; i++) {
				if (!visit[i]) {
					visit[i] = true;
					cycle(i, cnt+1, sb);
					visit[i] = false;
				}
			}
			
		}
		
	}
}
