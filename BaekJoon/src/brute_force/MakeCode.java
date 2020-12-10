package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakeCode {
	private static int L, C;
	private static char[] map;
	private static char[] temp;
	private static boolean[] visit;
	
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		
		//L개의 알파벳 소문자로 구성
		//최소 한 개의 모음(a, e, i, o, u) || 97, 101, 105, 111, 117
		//최소 두 개의 자음
		
		//최소 3개 이상
		
		//암호에서 증가하는 순서로 배열
		//abc
		
		//C가지 종류의 암호
		//가능성 있는 암호들을 모두 구하는 프로그램
		
		//중복 불가능
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[C+1];
		temp = new char[L+1];
		visit = new boolean[C+1];
		
		String[] input = reader.readLine().split(" ");
		
		for (int i=1; i<=C; i++) {
			map[i] = input[i-1].charAt(0);
		}
		
		Arrays.sort(map);
		
		dfs(1, 0);
		
	}//main

	private static void dfs(int start, int count) {
		
		if (count == L) {
			
			if(check()) {
				for (int i=0; i<L; i++) {
					System.out.print(temp[i]);
				}
				System.out.println();
			}
			
		} else {
			
			for (int i=start; i<=C; i++) {
				if (!visit[i]) {
					visit[i] = true;
					temp[count] = map[i];
					dfs(i+1, count+1);
					visit[i] = false;
				}
			}
			
		}
		
	}

	private static boolean check() {

		int mother = 0;
		int son = 0;
		for (int i=0; i<L; i++) {
			if (temp[i] == 'a' || temp[i] == 'e' || temp[i] == 'i' || temp[i] == 'o' || temp[i] == 'u') {
				mother++;
			} else {
				son++;
			}
		}
		
		return mother>=1 && son>=2;
		
	}
}//MakeCode









