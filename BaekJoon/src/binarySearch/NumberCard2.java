package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2 {
    /**
     * 백준 10816 숫자 카드 2 (https://www.acmicpc.net/problem/10816)
     */
    public static void main(String[] args) throws IOException {

        //정수 m개
        //이 수가 적혀있는 숫자 카드를 몇 개 가지고 있는지?

        //천만 * 오십만 = 5000000000000

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] card = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i=0; i<n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int m = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = card.length-1;
            int result = binarySearch(card, num, start, end);
            sb.append(result + " ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int[] card, int target, int start, int end) {
        int leftIndex = lowerBound(card, target, 0, end); //key보다 크거나 같은 첫번째 위치 반환
        int rightIndex = upperBound(card, target, 0, end); //key보다 큰 첫번째 위치를 반환
        return rightIndex - leftIndex;
    }//binarySearch

    private static int upperBound(int[] card, int target, int start, int end) {
        while (start < end) {
            int mid = (start+end)/2;

            if (card[mid] > target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        if (card[end] == target) {
            //target과 같으면 +1(lower과 빼기 위해)
            end++;
        }

        return end;

    }//upperBound

    private static int lowerBound(int[] card, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end)/2;
            if (card[mid] >= target) {//upper과 이부분만 차이
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return end;

    }//lowerBound
}
