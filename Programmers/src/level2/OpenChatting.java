package level2;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChatting {
    /**
     * 프로그래머스 레벨2 오픈채팅방 (https://programmers.co.kr/learn/courses/30/lessons/42888)
     */
    public static void main(String[] args) {

        Solution sol = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        sol.solution(record);

    }

    static class Solution {
        public String[] solution(String[] record) {
            String[] answer = {};

            //나갔다가 다른 아이디로 로그인하면 기존 이름 변경
            //유저 아이디로 구분

            //enter : 들어옴
            //leave : 나감
            //change : 변경 (uid기준으로)

            //저장 필요
            //hashmap<String(uid), String(이름)>

            //중복허용 - hashset x
            //나갔다가 들어왔을 때 이름을 변경하면 기존 이름도 변경(enter시 id 비교해 동일한 것이 있으면 이름 변경)

            HashMap<String, String> map = new HashMap<>();
            ArrayList<String[]> list = new ArrayList<>();

            for (int i=0; i<record.length; i++) {
                String[] userInfo = record[i].split(" ");

                if (userInfo[0].equals("Enter")) {
                    //입장시
                    map.put(userInfo[1], userInfo[2]);
                    list.add(new String[] {userInfo[1], userInfo[2] + "님이 들어왔습니다."});

                } else if (userInfo[0].equals("Leave")) {
                    //나갈시
                    //userInfo[0] : Leave, userIfo[1] : uid
                    list.add(new String[] {userInfo[1], map.get(userInfo[1]) + "님이 나갔습니다."});
                } else {
                    //이름 변경시(Change)
                    //id가 같은 놈을 찾아서 이름 변경
                    map.put(userInfo[1], userInfo[2]);
                }
            }


            answer = new String[list.size()];
            for (int i=0; i<list.size(); i++) {
                String uid = list.get(i)[0];
                String name = list.get(i)[1];
                if (!map.get(uid).equals(name)) {
                    String input = list.get(i)[1].substring(list.get(i)[1].indexOf("님"));
                    list.set(i, new String[] {uid, map.get(uid) + input});
                }
                answer[i] = list.get(i)[1];
            }

            return answer;
        }
    }

    static class Result {
        String uid, name;
        public Result(String uid, String name) {
            this.uid = uid;
            this.name = name;
        }
    }
}








