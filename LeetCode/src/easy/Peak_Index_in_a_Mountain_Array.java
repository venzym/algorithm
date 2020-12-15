package easy;

public class Peak_Index_in_a_Mountain_Array {
	/*
	 * 릿코드 Peak Index in a Mountain Array (https://leetcode.com/problems/peak-index-in-a-mountain-array/)
	 */
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] arr = {0,1,0};
		
		System.out.println(sol.peakIndexInMountainArray(arr));
	}
	
	static class Solution {
	    public int peakIndexInMountainArray(int[] arr) {
	        
	        int index = 0;
	        int num = -1;
	        for (int i=0; i<arr.length; i++) {
	            if (num < arr[i]) {
	                num = arr[i];
	                index = i;
	            }
	        }
	        
	        return index;
	    }
	}
}
