import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        //길이가 같은 배열
        //A와 B에서 한개씩 뽑아 두 수를 곱한다.
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }
        
        
        return answer;
    }
}
