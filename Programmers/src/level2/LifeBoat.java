import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //무게 제한을 초과하지 않고 최대한 많은 사람 탈출 시키기
        Arrays.sort(people);
        //포인터 2개를 두고 앞과 뒤를 같이 비교
        
        int min = 0;
        
        for (int i=people.length - 1; min <= i; i--) {
            if (people[min] + people[i] <= limit) {
                //2명 태울 수 있을 때 다음 사람으로 이동
                min++;
            }
            //보트 개수는 무조건 증가(1명을 태우든 위에 경우 해당해 2명을 태우든!)
            answer++;
        }
        
        return answer;
    }
}
