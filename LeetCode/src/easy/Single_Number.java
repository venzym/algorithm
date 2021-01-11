package easy;

import java.util.HashMap;

public class Single_Number {
    /**
     * 릿코드 Single Number (https://leetcode.com/problems/single-number/)
     */
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(nums));
    }

   static class Solution {
        public int singleNumber(int[] nums) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i=0; i<nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            }

            for (Integer i : map.keySet()) {
                if (map.get(i) == 1) {
                    return i;
                }
            }

            return 0;
        }
    }
}
