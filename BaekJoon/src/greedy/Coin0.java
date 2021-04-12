package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Coin0 {
    /**
     * 백준 11048 동전0(https://www.acmicpc.net/problem/11047)
     */
    public static void main(String[] args) throws IOException {

        //동전 N종류
        //동전 최소로 사용해서
        //가치의 합을 K로 만들기

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(reader.readLine());
            coin[i] = num;
        }

        int cnt = 0;

        for (int i=n-1; i>=0; i--) {
            if (k >= coin[i]) {
                cnt += k/coin[i];
                k %= coin[i];
            }
            if (k == 0) {
                break;
            }
        }

        System.out.println(cnt);

    }
}
