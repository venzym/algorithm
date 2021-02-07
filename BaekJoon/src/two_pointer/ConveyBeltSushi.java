package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ConveyBeltSushi {
    /**
     * 백준 2531 회전 초밥 (https://www.acmicpc.net/problem/2531)
     */
    public static void main(String[] args) throws IOException {

        //종류번호

        //k개 접시 연속해서 먹을 경우 할인

        //~번 초밥 쿠폰으로 추가로 받음

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());//접시개수
        int d = Integer.parseInt(st.nextToken());//초밥 종류
        int k = Integer.parseInt(st.nextToken());//연속해서먹는 접시 수!!
        int c = Integer.parseInt(st.nextToken());//쿠폰 번호

        int[] sushi = new int[n];

        for (int i=0; i<n; i++) {
            sushi[i] = Integer.parseInt(reader.readLine());
        }

        //1~d 초밥번호
        //쿠폰번호(c) < d(초밥종류)

        //먹을 수 있는 초밥 종류 개수 최댓값

        //7 9 7 30 2 7 9 25

        int[] eat = new int[d+1];

        int count = 0;

        for (int i=0; i<k; i++) {
            if (eat[sushi[i]] == 0) {
                count++;
            }
            //어떤 초밥 몇개 먹었는지 카운트
            eat[sushi[i]]++;
        }

        int max = count;

        int result = Integer.MIN_VALUE;

        for (int start=1; start<n; start++) {

            if (max <= count) {
                if (eat[c]==0) {
                    max = count+1;
                } else {
                    max = count;
                }
            }

            eat[sushi[start-1]]--;
            if (eat[sushi[start-1]]==0) {
                count--;
            }

            if (eat[sushi[(start+k-1)%n]] == 0) {
                count++;
            }
            eat[sushi[(start+k-1)%n]]++;

        }//for

        System.out.println(max);

    }
}
