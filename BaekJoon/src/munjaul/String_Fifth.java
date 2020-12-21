package munjaul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_Fifth {
	public static void main(String[] args) throws IOException {
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		//문자 입력
		String input = read.readLine();
		
		int[] arr = new int[26];
		
		int max = -1;
		char result = 0;
		
		for (int i=0; i<input.length(); i++) {
//			int loc = input.toLowerCase().charAt(i) - 97;
			int loc = Character.toLowerCase(input.charAt(i)) - 'a';
			arr[loc]++;
		}
		
		
		for (int i=0; i<26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = (char)(i+65);
			} else if (arr[i] == max) {
				result = '?';
			}
		}
		
		System.out.println(result);
		
	}

}
