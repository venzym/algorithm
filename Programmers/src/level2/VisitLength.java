import java.util.*;

class Solution {
    static int x = 0;
    static int y = 0;

    static List<String> list = new ArrayList();
    public int solution(String dirs) {
        int answer = 0;
        
        //처음 걸어본 길의 길이
        //갈 수 없는 길은 무시하기
        String[] arr = dirs.split("");
        
        for (int i = 0; i < arr.length; i++) {
            findMinLen(arr[i]);
        }
        
        answer = list.size();
        return answer;
    }
    
    void findMinLen(String str) {
        String temp = String.valueOf(x) + y;
        if(str.equals("U")){
            if(y == 5)
                return;
            y++;
        } else if(str.equals("D")){
            if(y == -5)
                return;
            y--;
        } else if(str.equals("R")){
            if(x == 5)
                return;
            x++;
        } else if(str.equals("L")){
            if(x == -5)
                return;
            x--;
        }
        if (list.contains(temp + x + y) || list.contains(String.valueOf(x) + y + temp)) {
            return;
        }
        list.add(temp + x + y);
    }
}
