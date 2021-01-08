package level2;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneNumbers {
    /**
     * 프로그래머스 level2 [해시] 전화번호 목록 (https://programmers.co.kr/learn/courses/30/lessons/42577)
     */
    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};
        Solution sol = new Solution();
        System.out.println(sol.solution(phone_book));
    }

    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            for (int i=0; i<phone_book.length; i++) {
                String str = phone_book[i];
                for (int j=0; j<phone_book.length; j++) {
                    if (i!=j && phone_book[j].indexOf(str) == 0) {
                        answer = false;
                        return answer;
                    }
                }
            }


            return answer;
        }
    }
}
