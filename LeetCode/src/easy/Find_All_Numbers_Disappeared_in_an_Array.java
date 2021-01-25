package easy;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {

            List<Integer> list = new ArrayList<>();

            int[] number = new int[nums.length+1];

            for (int i=0; i<nums.length; i++) {
                int temp = nums[i];
                number[temp] = 1;
            }

            for (int i=1; i<number.length; i++) {
                if (number[i] == 0) {
                    list.add(i);
                }
            }


            return list;
        }
    }
}
