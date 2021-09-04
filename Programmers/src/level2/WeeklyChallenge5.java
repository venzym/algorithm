class Solution {
    static String[] arr = {"A", "E", "I", "O", "U"};
    static int answer; //정답
    static int order = 0; //순서
    public int solution(String word) {
        answer = 0;
        
        //사전을 어떻게 만들지..?
        //사전
        //완탐

        dfs(0, "", word);
        return answer;
    }
    
    void dfs(int cnt, String str, String word) {
        if (cnt == 5) {
            
        } else {
            String temp;
            for (int i = 0; i < arr.length; i++) {
                temp = str + arr[i];
                order++;
                if (temp.equals(word)) {
                    answer = order;
                    return;
                }
                dfs(cnt + 1, temp, word);
            }
        }
    }
}
