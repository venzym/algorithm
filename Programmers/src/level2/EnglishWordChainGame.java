import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        //단어 계속 저장 -> ArrayList.contains
        
        List<String> list = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(i + 1, 1);
        }
        
        int index;
        char last = '0';
        
        for (int i = 0; i < words.length; i+=n) {
            index = 1;
            for (int j = i; j < i + n; j++) {
                if ((j == 0 || words[j].charAt(0) == last) && !list.contains(words[j])) {
                    list.add(words[j]);
                    map.put(index, map.get(index) + 1);
                    last = words[j].charAt(words[j].length() - 1);
                } else {
                    answer[0] = index;
                    answer[1] = map.get(index);
                    return answer;
                }
                index++;
            }
        }
        
        answer[0] = 0;
        answer[1] = 0;

        return answer;
    }
}
