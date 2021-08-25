class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int index = 0;//뽑은 숫자 위치
        char max;
        
        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            
            for (int j = index; j <= i + k; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    index = j + 1; //현재 찾은 숫자 다음부터 찾기 위해
                }
            }
            
            answer.append(max);
        }
        
        return answer.toString();
    }
}
