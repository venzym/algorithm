package level2;

import java.util.ArrayList;
import java.util.HashMap;

public class SkillTree {
    /**
     * 프로그래머스 레벨2 스킬트리 (https://programmers.co.kr/learn/courses/30/lessons/49993?language=java#fnref1)
     */
    public static void main(String[] args) {

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        Solution sol = new Solution();
        System.out.println(sol.solution(skill, skill_trees));
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (int i=0; i< skill_trees.length; i++) {
                String str = skill_trees[i];
                int index = 0;
                boolean flag = true;

                for (int j=0; j<str.length(); j++) {
                    for (int k=0; k<skill.length(); k++) {
                        if (str.charAt(j) == skill.charAt(k)) {
                            if (k == index) {
                                index++;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (flag) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
