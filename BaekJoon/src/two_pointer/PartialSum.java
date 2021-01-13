package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialSum {
    /**
     * 백준 1806 부분합 (https://www.acmicpc.net/problem/1806)
     */

    public static void main(String[] args) throws IOException {

        //10000이하
        //N길이 수열
        //연속된 수들의 부분합 중 S이상이 되는 것 중 가장 짧은 것의 길이

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n,s,array));

    }

    private static int solution(int n, int s, int[] array) {

        int intervalSum = 0;
        int start = 0;
        int end = 0;
        int distance = Integer.MAX_VALUE;

        while (true) {
            if (intervalSum < s) {
               if (end>=n) {
                   break;
               }
               intervalSum += array[end++];
            } else {
                distance = Math.min(distance, end-start);
                intervalSum -= array[start++];
            }
        }

        if(distance == Integer.MAX_VALUE) {
            return 0;
        }
        return distance;

    }//solution
}











