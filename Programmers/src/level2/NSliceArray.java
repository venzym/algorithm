import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        
        //1. n * n 배열
        //2. 1~n까지 i행 i열까지 모든 빈칸을 숫자 i로 채운다.
        //3. 행을 잘라 이어붙여 1차원 배열을 만든다.
        //4. left~right만 남긴다.
        
        //방법
            //1. Math.max(i, j) + 1 을 대입한 후 자르기 : 2중 for문
            //2. for문 1개로.. 
        
        //n : 10000000 * 10000000
        
        answer = new int[(int)(right - left) + 1];
        
        int idx = 0;
        for (long i = left; i <= right; i++) {
            answer[idx++] = Math.max((int)(i / n), (int)(i % n)) + 1;
        }
        
        return answer;
    }
}
