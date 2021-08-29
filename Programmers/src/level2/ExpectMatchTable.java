import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        //n명 참가
        //번호 순서대로 부여받음
        
        // n/2 명 다음 토너먼트 진출
        //다시 번호 부여받음
        
        //A번 참가자는 B번 참가자와 몇라운드에 만나는지 궁금하다?
        
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            
            answer++;
        }
        
        return answer;
    }
}
