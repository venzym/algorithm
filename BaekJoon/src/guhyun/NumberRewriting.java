package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberRewriting {
    /*
     * 백준 1748 수 이어 쓰기 1(https://www.acmicpc.net/problem/1748)
     */
    public static void main(String[] args) throws IOException {
        //1부터 N까지의 수를 이어서 쓸 때 나타나는 자릿수
        //StringBuilder 사용

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int length = 0;//총 길이
        int plus = 1;//숫자별 더할 길이
        int digits = 10;//나눌 숫자

        //1~9 : 1자리
        //10 ~ 99 : 2자리
        //100 ~ 999 : 3자리

        for (int i = 1; i <= N; i++) {
            if (i % digits == 0) {
                plus += 1;
                digits *= 10;
            }
            length += plus;
        }

        System.out.println(length);
    }
}
