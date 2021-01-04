package level2;

import java.util.Stack;

public class RightParenthesis {
    /**
     * 프로그래머스 level2 올바른 괄호 (https://programmers.co.kr/learn/courses/30/lessons/12909)
     */
    public static void main(String[] args) {

        String s = ")()(";
        Solution sol = new Solution();
        System.out.println(sol.solution(s));

    }

    static class Solution {
        boolean solution(String s) {

            if (s == null || s.charAt(0) == ')' || s.charAt(s.length()-1) == '(' || s.length()%2 != 0) {
                //예외처리
                return false;
            }

            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}








