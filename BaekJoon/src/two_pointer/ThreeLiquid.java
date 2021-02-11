package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreeLiquid {
    /**
     * 백준 2473 세 용액 (https://www.acmicpc.net/problem/2473)
     */
    public static void main(String[] args) throws IOException {

        int[] answer = new int[3];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] liquid = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i=0; i<n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);
        long max = Long.MAX_VALUE;

        for (int i=0; i<n-1; i++) {
            int start = i+1;//맨 왼쪽
            int end = liquid.length-1;//맨오른쪽
            int center = end-1;//맨

            while (end > center) {

                center = end-1;

                while (start <= center) {
                    int mid = (start+center)/2;

                    long sum = (long)liquid[i] + (long)liquid[mid] + (long)liquid[end];

                    if (Math.abs(sum) < max) {
                        answer[0] = liquid[i];
                        answer[1] = liquid[mid];
                        answer[2] = liquid[end];
                        max = Math.abs(sum);
                    }

                    if (sum < 0) {
                        start = mid+1;
                    } else {
                        center = mid-1;
                    }

                }//while(이분탐색)

                end--;
            }//while(맨 오른쪽 인덱스)
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);

    }
}










