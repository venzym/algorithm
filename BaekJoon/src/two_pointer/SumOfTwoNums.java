package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfTwoNums {
    /**
     * 백준 3273 두 수의 합 (https://www.acmicpc.net/problem/3273)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(reader.readLine());

        int cnt = 0;

        for (int start=0; start<n; start++) {
            int end = start+1;
            int sum = 0;
            while (end<n) {
                sum = nums[start];
                sum += nums[end++];

                if (sum == x) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
