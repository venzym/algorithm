package level2;

import java.util.Arrays;
import java.util.HashMap;

public class Disguise {
    /*
     * 프로그래머스 level2 [해시] 위장 (https://programmers.co.kr/learn/courses/30/lessons/42578)
     */
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution sol = new Solution();
        System.out.println(sol.solution(clothes));
    }

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;

            HashMap<String, Integer> map = new HashMap<>();

            for (int i=0; i<clothes.length; i++) {
                System.out.println(clothes[i][0] + " " + clothes[i][1]);
                if (map.containsKey(clothes[i][1])) {
                    map.put(clothes[i][1], map.get(clothes[i][1])+1);
                } else {
                    map.put(clothes[i][1], 1);
                }
            }

            int result = 1;
            //공식
            //{1,2} {3,4,5} 두 배열의 조합은 겉으로 보면 2*3이지만, 한 개를 안 선택하는 경우도 존재한다.
            //1,3 1,4 1,5 2,3 2,4 2,5  0,3 0,4 0,5 1,0 2,0
            //따라서, {0,1,2} {0,3,4,5} 라고 생각하여 총 조합의 개수를 구한 후, 1개는 무조건 입어야 하기 때문에 -1을 해준다.
            for (String s : map.keySet()) {
                result = result*(map.get(s)+1);
            }

            answer = result-1;

            return answer;
        }
    }
}

