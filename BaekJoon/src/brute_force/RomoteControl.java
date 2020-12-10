package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RomoteControl {
	/**
	 * 백준 1107 리모컨(https://www.acmicpc.net/problem/1107)
	 */
	private static int n, m;
	private static boolean[] enable;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//0~9
		//+, -
		
		//현재 : 100 -> N
		//N으로 이동하기 위해 버튼 몇 번 눌러야하는지
		
		//1. 채널 하나씩 직접 이동
		//2. 숫자로 이동 시 고장난 키 있으면 불가능
		//3. 연산
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(reader.readLine());

        enable = new boolean[10];

        if(m!=0){
            st = new StringTokenizer(reader.readLine());
            for (int i = 1; i <= m; i++) {
                int input = Integer.parseInt(st.nextToken());
                enable[input] = true;
            }

        }
		
		//채널 1개씩 이동
		int result = Math.abs(n-100);
		
		//숫자버튼으로 이동
		for (int i=0; i<=1000000; i++) {
			//일일이 검사
			String num = Integer.toString(i);
			boolean flag = false;
			
			//고장난 키 있는지 확인
			for (int j=0; j<num.length(); j++) {
				int val = num.charAt(j) - '0';
				
				//0~9
				if (!brokenCheck(val)) {
					flag = true;
					break;
				}
			}
			
			//고장난 키 포함 안될 때
			//숫자버튼
			//가는법
			
			//ex) i = 5455 -> + 2 -> 5457
			//길이 : num.length() : 4 + 2 = 6
			if (!flag) {
				result = Math.min(result, Math.abs(i-n) + num.length());
			}
			
		}
		
		System.out.println(result);
	}

	private static boolean brokenCheck(int val) {
		//현재 값과 고장난 버튼 사용해 비교
		if (enable[val]) {
			return false;
		}
		return true;
	}
}










