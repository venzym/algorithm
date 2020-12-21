package munjaul;

import java.util.Scanner;

public class String_Fourth {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//개수
		int num = scan.nextInt();
		
		//결과 담을 배열
		String[] result = new String[num];
		
		for (int i=0; i<num; i++) {
			//반복 횟수
			int size = scan.nextInt();

			//문자
			String input = scan.next();
		
			String hap = "";
			
			//출력문 만들기
			for (int j=0; j<input.length(); j++) {
				
				for (int k=0; k<size; k++) {
					hap += input.charAt(j);
				}
			}
			result[i] = hap;
		
		}
		
		for (int i=0; i<num; i++) {
			System.out.println(result[i]);
		}
		
	}
}
