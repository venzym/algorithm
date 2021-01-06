package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNums {
    /**
     * 백준 2003 수들의 합 2 (https://www.acmicpc.net/problem/2003)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int intervalSum = 0;
        int cnt = 0;
        int end = 0;

        for (int start=0; start<n; start++) {
            while (intervalSum<m && end<n) {
                intervalSum += arr[end++];
            }

            if (intervalSum==m) {
                cnt++;
            }

            intervalSum -= arr[start];
        }

        System.out.println(cnt);

    }
}
