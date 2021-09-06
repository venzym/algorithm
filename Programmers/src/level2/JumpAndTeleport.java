public class Solution {
    public int solution(int n) {
        int ans = 0;

        //한번에 k칸 앞으로 점프
        //(현재까지 온 거리 * 2) '위치'로 순간이동
        //순간이동은 건전지를 사용하지 않는다.
        //k칸 점프하면 k만큼 건전지를 사용한다.
        //점프 이용 최소화
        
        //건전지 최소 사용량 구하기!!
        //완탐 x
        //그리디
        
        while (n > 0) {
            if (n % 2 == 1) {
                ans++;
                n--;
            } else if (n % 2 == 0) {
                n /= 2;
            }
        }
        return ans;
    }
}
