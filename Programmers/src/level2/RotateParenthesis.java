import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = -1;
        
        //왼쪽으로 x칸만큼 회전
        //올바른 괄호 문자열이 되는 경우의 수
        //큐 + 스택? - 둘이 변환이 쉽지 않네
        //substring은 쓰지 말제이~
        //s를 담아놓고 갈아끼우면서 체크(스택)
        // Stack<Character> stack = new Stack();
        
        StringBuilder sb = new StringBuilder(s);
        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
            //올바른 괄호 문자열인지 체크
            if (checkParenthesis(sb)) {
                cnt++;
            }
            
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        
        answer = cnt;
        return answer;
    }
    
    boolean checkParenthesis(StringBuilder sb) {
        Stack<Character> stack = new Stack();
        
        for (int i=0; i<String.valueOf(sb).length(); i++) {
            char c = sb.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                }
            } else {
                //)}] 만 남아있는 경우 실패실패
                return false;
            }
        }
        
        if (stack.isEmpty()) {
            //비어있으면 짝이 맞으니 성공
            return true;
        }
        
        return false;
    }
}
