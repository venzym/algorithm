import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        //장르별 플레이 수 담기
        // <genre, play> 
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<genres.length; i++){ 
            String genre = genres[i]; 
            int play = plays[i]; 
            
            if (map.containsKey(genre)){ 
                // 기존에 있는 장르라면 play 누적.
                map.put(genre, map.getOrDefault(genre, 0) + play);
            } else {
                // 새로운 장르
                map.put(genre, play); 
            } 
        }
        
        //key 리스트
        List<String> keyList = new ArrayList(map.keySet());

        //play수 기준으로 keyList를 내림차순 정렬
        Collections.sort(keyList, (o1, o2) -> (
                            map.get(o2).compareTo(map.get(o1)))
                        );
        
        //정답 담을 배열
        List<Integer> answerList = new ArrayList();
        
        //곡 재생 횟수, 동일한 장르 비교해서 위에 넣기
        for (String s : keyList) {
            //곡 재생 횟수
            int firstMax = 0;
            int secondMax = 0;
            
            //곡 인덱스
            int firstIndex = -1;
            int secondIndex = -1;
            
            //동일한 장르에서
            for (int i=0; i<genres.length; i++) {
                if (s.equals(genres[i])) {
                    //key(장르가 같을 때) 순위가 바뀌는지 확인
                    if (firstMax < plays[i]) {
                        //1위에서 현재 재생횟수가 더 높은 경우
                        secondMax = firstMax; //1순위가 2순위로
                        secondIndex = firstIndex; //1순위가 2순위로
                        firstMax = plays[i]; //1순위값이 현재값(더 큰값)으로
                        firstIndex = i; //1순위가 현재 index로
                    } else if (firstMax == plays[i]) {
                        //장르가 같고, 1위와 플레이 횟수가 같으면
                        //2위에 넣어주기
                        secondMax = plays[i];
                        secondIndex = i;
                    } else if (plays[i] < firstMax && secondMax < plays[i]) {
                        //1위보다 낮고, 2위에서 현재 재생횟수가 높은 경우
                        secondMax = plays[i];
                        secondIndex = i;
                    }
                }
            }
            //1위
            answerList.add(firstIndex);
            
            //한 장르에 곡이 1개만 있을 경우
            if (secondIndex != -1) {
                answerList.add(secondIndex);
            }
        }
        
        answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
