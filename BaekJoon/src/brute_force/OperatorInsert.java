package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OperatorInsert {
	
	private static int N;
	private static int[] map;
	private static char[] operator;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//N개의 수로 이루어진 수열
		//N-1개의 연산자(+, -, x, /)
		
		//음수 나눌 때 : 양수로 바꾼 뒤 몫을 구하고, 음수로 변경
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(reader.readLine());
		map = new int[N];
		operator = new char[N-1];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i=0; i<N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
	}//main
}//OperatorInsert






