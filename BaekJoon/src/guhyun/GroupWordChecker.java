package guhyun;

import java.util.ArrayList;
import java.util.Scanner;

public class GroupWordChecker {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = 0; //전체 개수

		for (int i=0; i<n; i++) {
			String str = sc.next();
			ArrayList<Character> list = new ArrayList<Character>();

			char c1 = str.charAt(0);
			list.add(c1);
			boolean flag = false;
			
			for (int j=1; j<str.length(); j++) {
				char c2 = str.charAt(j);
				if (c1 != c2) {
					//전과 같지 않을 때
					
					//전 이전수 중 같은게 있으면 그룹단어x
					for (int k=0; k<list.size(); k++) {
						if (c2 == list.get(k)) {
							flag = true;
							break;
						}
					}
					
					list.add(c2);
					c1 = c2;
				} 
				
			}
			
			if (!flag) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}













