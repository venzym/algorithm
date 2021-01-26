package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    /**
     * 백준 2467 용액 (https://www.acmicpc.net/problem/2467)
     */
    public static void main(String[] args) throws IOException {

        //산성용액 : 1~1억
        //알칼리성 : -1~-1억

        //두 용액 혼합 -> 특성값의 합
        //두 용액을 혼합해 특성값이 0에 가장 가까운 용액 만들기 !

        int[] answer = new int[2];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] liquid = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i=0; i<n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);
        int max = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            int start = i+1;
            int end = n-1;
            while (start <= end) {
                int mid = (start+end)/2;

                int sum = liquid[i] + liquid[mid];

                if (Math.abs(sum) < max) {
                    answer[0] = liquid[i];
                    answer[1] = liquid[mid];
                    max = Math.abs(sum);
                }

                if (sum < 0) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}














