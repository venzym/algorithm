import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        //알파벳 소문자
        //아래 반복
        //1. 같은 알파벳 2개 붙어 있는 짝 찾기
        //2. 1번 제거
        //3. 앞뒤 문자열 이어붙이기
        
        //모든 문자가 제거되면 성공, 문자가 남으면 실패
        //스택 사용
        
        Stack<Character> stack = new Stack<>();
        
        char[] arr = s.toCharArray();
        
        for (char c : arr) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        if (stack.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }
        
        return answer;
    }
    
}
