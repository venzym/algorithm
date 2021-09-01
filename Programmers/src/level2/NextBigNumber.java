import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = n;
        
        int nCnt = getOneCount(Integer.toBinaryString(n));
        int nextCnt = 0;
        while (true) {
            //n의 다음 큰 숫자는 n보다 '큰 자연수'
            answer += 1;
            
            //n의 다음 큰 숫자의 1의 갯수 == n 1의 개수
            nextCnt = getOneCount(Integer.toBinaryString(answer));

            //n의 다음 큰 숫자는 1, 2를 만족하는 수 중 가장 작은 수
            if (nCnt == nextCnt) {
                break;
            }
        }//while
        
        return answer;
    }
    
    int getOneCount(String binaryString) {
        int cnt = 0;
        
        for (int i=0; i<binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                cnt += 1;                
            }
        }
        
        return cnt;
    }//getOneCount
}
