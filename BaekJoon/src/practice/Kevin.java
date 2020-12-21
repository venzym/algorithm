package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kevin {
	private static int n,m;
	private static ArrayList<Integer>[] list;
	private static boolean[] visit;
	private static int[] temp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		for (int i=0; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i=1; i<=m; i++) {
			st = new StringTokenizer(reader.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			list[a1].add(a2);
			list[a2].add(a1);
		}
		
		int[] hap = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			Arrays.fill(visit, false);
			temp = new int[n+1];
			visit[i] = true;
			dfs(i, 0);
			
			hap[i] = sum();
		}
		
		int index = 0;
		int min = Integer.MAX_VALUE;
		for (int i=1; i<=n; i++) {
			if (min > hap[i]) {
				index = i;
				min = hap[i];
			}
		}
		
		System.out.println(index);
	}

	private static int sum() {
		
		int sum = 0;
		for (int i : temp) {
			sum += i;
		}
		
		return sum;
	}

	private static void dfs(int start, int level) {
		
		if (temp[start] == 0) {
			temp[start] = level;
		} else {
			temp[start] = Math.min(temp[start], level);
		}
		
		for (int i : list[start]) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, level+1);
				visit[i] = false;
			}
		}
		
	}
}
