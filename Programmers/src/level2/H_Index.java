import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = Integer.MIN_VALUE;
        
        //n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지가 h번 이하 인용되었을 때 h의 최댓값
        
        int len = citations.length;
        Arrays.sort(citations);
        
        int cnt;
        
        for (int h=0; h<=citations[len-1]; h++) {
            //인용횟수 h
            cnt = 0;
            for (int j=0; j<len; j++) {
                if (h <= citations[j]) {
                    //h보다 큰 h 개수
                    cnt++;
                }
            }
            
            if (cnt >= h) {
                //h번 이상 인용되었을 때
                answer = Math.max(answer, h);
            }
        }
        
        
        return answer;
    }
}
