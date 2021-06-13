package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_B {
    /**
     * 백준 12904 A와 B (https://www.acmicpc.net/problem/12904)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //AB
        //BAA
        //AA
        //ABBA

        //S -> T
        String input = reader.readLine();
        String result = reader.readLine();

        StringBuilder sb = new StringBuilder(result);

        //그리디
        //T -> S 해보자
        while (input.length() < sb.length()) {
            char c = sb.charAt(sb.length() - 1);

            //1. 맨 오른쪽 삭제
            sb.deleteCharAt(sb.length() - 1);

            //2. B이면 뒤집기
            if (c == 'B') {
                sb.reverse();
            }
        }

        if (input.equals(sb.toString())) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
