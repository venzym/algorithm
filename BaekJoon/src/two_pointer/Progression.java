package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Progression {
    /**
     * 백준 2559 수열 (https://www.acmicpc.net/problem/2559)
     */
    public static void main(String[] args) throws IOException {

        //연속적인 며칠 동안의 온도의 합이 가장 큰지

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temparature = new int[n];

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            temparature[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int result = Integer.MIN_VALUE;

        for (int start=0; start<=n-k; start++) {
            int intervalSum = 0;
            end = start;

            while (end<n && end-start < k) {
                intervalSum += temparature[end++];
            }//while

            result = Math.max(result, intervalSum);
        }

        System.out.println(result);

    }
}
