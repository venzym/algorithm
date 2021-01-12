package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoLiquid {
    /**
     * 백준 2470 두 용액 (https://www.acmicpc.net/problem/2470)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int[] liquid = new int[n];

        for (int i=0; i<n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int[] output = new int[2];

        solution(n, liquid, output);


        System.out.println(output[0] + " " + output[1]);

    }

    private static void solution(int n, int[] liquid, int[] output) {

        int start = 0;
        int end = n-1;
        int max = Integer.MAX_VALUE;

        while (start < end) {
            int sum = liquid[start] + liquid[end];

            if (Math.abs(sum) < max){
                output[0] = liquid[start];
                output[1] = liquid[end];
                max = Math.abs(sum);
            }

            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

    }//solution
}
