package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Alphabet {
	/**
	 * 백준 1987 알파벳 (https://www.acmicpc.net/problem/1987)
	 */
	private static int r, c;
	private static char[][] map;
	private static boolean[] check = new boolean[26]; //알파벳 중복 판별
	
	private static int result = Integer.MIN_VALUE;
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		//r*c
		//각 칸 - 대문자 알파벳
		//1행 1열에 말이 놓여져 있음
		
		//같은 알파벳을 두번 지날 수 없다. - 지날때마다 저장
		
		//말이 최대한 몇 칸을 지날 수 있는지!
		
		//첫칸도 저장
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		for (int i=0; i<r; i++) {
			char[] array = reader.readLine().toCharArray();
			for (int j=0; j<c; j++) {
				//배열에 0부터 넣을 수 있도록 제일 작은 대문자인 A를 뺀다.
				map[i][j] = (char)(array[j] - 'A'); 
			}
		}
		
		check[map[0][0]] = true;
		dfs(0, 0, 1);
		
		System.out.println(result);
		
	}//main

	private static void dfs(int x, int y, int count) {
		
		result = Math.max(result, count);
		
		for (int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
				continue;
			}
			
			if (!check[map[nx][ny]]) {
				check[map[nx][ny]] = true;
				dfs(nx, ny, count+1);
				check[map[nx][ny]] = false;
			}
		}
		
	}//dfs
}
