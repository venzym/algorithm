package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNums2 {

    /**
     * 백준 2003 수들의 합 2 (https://www.acmicpc.net/problem/2003)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int cnt = 0;
        int sum = 0;

        for (int start = 0; start < N; start++) {
            while (sum < M && end < N) {
                sum += arr[end++];
            }

            if (sum == M) {
                cnt++;
            }

            sum -= arr[start];
        }

        System.out.println(cnt);
    }
}
