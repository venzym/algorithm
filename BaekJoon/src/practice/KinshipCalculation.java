package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class KinshipCalculation {
	private static int n;
	private static boolean[] visit;
	private static ArrayList<Integer>[] list;
	
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		visit = new boolean[n+1];
		list = new ArrayList[n+1];
		
		for (int i=0; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		String[] input = reader.readLine().split(" ");
		int start = Integer.parseInt(input[0]);
		int end = Integer.parseInt(input[1]);
		
		int m = Integer.parseInt(reader.readLine());
		
		for (int i=1; i<=m; i++) {
			String[] str = reader.readLine().split(" ");
			int a1 = Integer.parseInt(str[0]);
			int a2 = Integer.parseInt(str[1]);
			
			list[a1].add(a2);
			list[a2].add(a1);
		}
		
		int[] result = new int[n+1];
		dfs(start, end, result);
		
		for (int i=1; i<=n; i++) {
			result[i] = result[i] == 0 ? -1 : result[i];
		}
		
		System.out.print(result[end]);
//		cnt = cnt == 0 ? -1 : cnt;
//		
//		System.out.print(cnt);
	}

	private static void dfs(int start, int end, int[] result) {
		
		if (start == end) {
			Arrays.fill(visit, true);
			//System.out.println("start==end :: " + start + " , count :: " + count);
		}
		
		visit[start] = true;
		
		for (int i : list[start]) {
			if (!visit[i]) {
				result[i] = result[start]+1;
				dfs(i, end, result);
				//System.out.println("num :: " + num);
			}
		}
		
		
	}
}






