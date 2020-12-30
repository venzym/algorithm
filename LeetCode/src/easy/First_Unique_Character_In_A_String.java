package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class First_Unique_Character_In_A_String {
    public static void main(String[] args) {

        String s = "loveleetcode";

        Solution sol = new Solution();
        System.out.println(sol.firstUniqChar(s));
    }

    static class Solution {
        public int firstUniqChar(String s) {

            if (s == null || s.length() == 0) {
                return -1;
            }

            HashMap<Character, Integer> map = new HashMap<>();

            for (int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }

            for (int i=0; i<s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }

            return -1;

        }
    }
}
