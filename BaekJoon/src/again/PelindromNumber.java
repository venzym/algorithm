package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PelindromNumber {

    /*
    백준 1259 팰린드롬 수(https://www.acmicpc.net/problem/1259)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = reader.readLine();
            int length = str.length();
            boolean flag = true;

            if (str.equals("0")) {
                break;
            }

            for (int i = 0; i < length / 2; i++) {
                if (str.charAt(i) != str.charAt(length - 1 - i)) {
                    flag = false;
                }
            }

            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }

}
