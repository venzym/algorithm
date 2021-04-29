package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WordMath {
    /**
     * 백준 1339 단어 수학(https://www.acmicpc.net/problem/1339)
     */
    public static void main(String[] args) throws IOException {

        //N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만들기기

       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] alpha = new int[26];

        for (int i=0; i<n; i++) {
            String str = reader.readLine();
            for (int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                int index = c - 'A';

                alpha[index] += Math.pow(10, str.length() - j - 1);//j 작을수록 큰 숫자
            }
        }

        Arrays.sort(alpha);

        int result = 0;
        int index = 25;
        for (int i=9; i>=0; i--) {
            result += alpha[index--] * i;
        }

        System.out.println(result);
    }
}
