class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        //원래 이용료 : price
        //n번째 이용료 : n * price
        //얼마가 모자라는가 구해라
        //부족하지 않으면 0을 return해라
        
        long sum = 0;
        for (int i=1; i<=count; i++) {
            sum += price * i;
        }

        if (sum > money) {
            return (sum - money);
        } 

        return (0);
    }
}
