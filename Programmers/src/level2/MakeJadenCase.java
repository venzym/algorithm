import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        //JadenCase
        //첫 문자는 대문자
        //나머지는 소문자
        
        s = s.toLowerCase();
        
        boolean flag = true; // 공백 만나면 true, 아니면 false
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if ((i == 0 || s.charAt(i - 1) == ' ') && (c >= 'a' && c <= 'z') && flag) {
                //첫글자 확인해 대문자 만들기
                c -= 32;
                flag = false;
            } else if ((c >= 'A' && c <= 'Z') && !flag) {
                //나머지 문자 확인해 소문자 만들기
                c += 32;
            } else if (c == ' ') {
                flag = true;
            }
            
            answer.append(Character.toString(c));
        }
        
        return answer.toString();
    }
}
