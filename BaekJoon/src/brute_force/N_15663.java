package brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class N_15663 {

	private static int n, m;
	private static int[] map;
	private static int[] result;
	private static boolean[] visit;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//2번째 원소
		//1번째와 중복x
		//이전에 나왔던 수 x
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n];
		result = new int[m];
		visit = new boolean[n+1];
		
		for (int i=0; i<n; i++) {
			map[i] = sc.nextInt();
		}
		
		Arrays.sort(map);
		
		StringBuilder sb = new StringBuilder();
		
		cycle(0, sb);
		
		System.out.print(sb);
		
	}

	private static void cycle(int start, StringBuilder sb) {
		
		if (start == m) {
			
			for (int i=0; i<m; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			
		} else {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i=0; i<map.length; i++) {
				
				if (!visit[i]) {
					
					//2번째 원소중 이전에 나온것 또 나오면 안됨
					int cnt = 0;
					for (int j=0; j<list.size(); j++) {
						if (map[i] == list.get(j)) {
							cnt++;
						}
					}
					
					if (cnt == 0) {
						//중복 x
						visit[i] = true;
						result[start] = map[i];
						list.add(map[i]);
						cycle(start+1, sb);
						visit[i] = false;
						
					} else {
						//중복 o
						continue;
					}
					
				}
				
			}
			
		}
		
	}
}












