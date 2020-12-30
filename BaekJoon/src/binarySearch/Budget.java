package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Budget {
    /**
     * 백준 2512 예산 (https://www.acmicpc.net/problem/2512)
     */
    public static void main(String[] args) throws IOException {
        //최대의 총 예산
        //모든 요청이 배정될 수 있는 경우 : 요청한 금액을 그대로 배정
        //모든 요청이 배정될 수 없는 경우 : 특정한 정수 상한액을 계산해 그 이상인 예산요청에는 모두 상한액을 배정
        //485, 4개 지방(120,110,140,150) 상한액 127

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int start = 0;
        int end = 0;
        int[] money = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i=0; i<n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, money[i]);
        }

        Arrays.sort(money);

        int m = Integer.parseInt(reader.readLine());

        int result = 0;

        while (start <= end) {

            int mid = (start+end)/2;

            long sum = 0;

            for (int i=0; i<n; i++) {
                sum += Math.min(money[i], mid);
            }

            if (sum <= m) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }

        }//while

        System.out.println(result);
    }
}











