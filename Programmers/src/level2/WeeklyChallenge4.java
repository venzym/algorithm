import java.util.*;

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        
        //언어별 선호도
        Map<String, Integer> langPrefer = new HashMap();
        for (int i=0; i<languages.length; i++) {
            langPrefer.put(languages[i], preference[i]);
        }
        
        //직업별 점수 계산해 비교후 최댓값으로 집어넣기
        int max = Integer.MIN_VALUE;
        int sum;
        
        //직군별 언어 순서
        Map<String, String[]> jobLang = new HashMap();
        for (int i=0; i<table.length; i++) {
            String[] temp = table[i].split(" ");
            jobLang.put(temp[0], Arrays.copyOfRange(temp, 1, temp.length - 1));
            
            sum = 0;
            for (int j=1; j<temp.length; j++) {
                if (langPrefer.containsKey(temp[j])) {
                    sum += langPrefer.get(temp[j]) * (temp.length - j);
                }
            }
            
            if (max < sum) {
                answer = temp[0];
                max = sum;
            } else if (max == sum) {
                if (temp[0].compareTo(answer) < 0) {
                    answer = temp[0];
                }
            }
        }
        
        
        return answer;
    }
}
