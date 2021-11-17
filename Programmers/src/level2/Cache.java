import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        //도시 이름 검색 - 관련된 맛집 보여주기
        //실행시간이 오래 걸린다
        //캐시 크기에 따른 실행시간 측정 프로그램을 만들어라!! -> '총 실행시간'
        
        //가장 오랫동안 사용되지 않은 페이지를 제거한다.
        
        //cache miss - 메모리가 캐시에 존재하지 않을 떄
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        List<String> list = new ArrayList();
        
        for (String s : cities) {
            String city = s.toLowerCase();
            
            if (list.contains(city)) {
                //도시가 기존 리스트에 있을 때
                answer++;
                list.add(city); 
                list.remove(list.indexOf(city));
            } else {
                //도시가 기존 리스트에 없을 때
                answer += 5;
                
                list.add(city); 
                
                //캐시사이즈 넘으면 제일 오래된 것 삭제하기
                if (list.size() > cacheSize) {
                    list.remove(0);
                }
            }
        }
        
        return answer;
    }
}
