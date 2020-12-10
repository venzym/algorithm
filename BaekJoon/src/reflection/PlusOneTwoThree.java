package reflection;

import java.util.Scanner;

public class PlusOneTwoThree {
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		int n = sc.nextInt();

		Solution sol = new Solution();
		
		System.out.println(sol.solution("doga"));
	}


}


class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        
        if (S.contains("aaa")) {
            return -1;
        }
        
        if (S.equals("aa")) {
            return 0;
        }
        
        int aCnt = 0;
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'a') {
                aCnt++;
            } 
        }
        
        int num = S.length() - aCnt;
        
        if (aCnt != (num*2)+2) {
            return (num*2)+2 - aCnt;
        }
        return 0;
        
    }
}
