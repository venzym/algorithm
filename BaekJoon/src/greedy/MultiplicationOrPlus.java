package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationOrPlus {
    /**
     * 나동빈(그리디) - 곱하기 혹은 더하기
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = reader.readLine().split("");

        long num = Integer.parseInt(str[0]);

        for (int i=1; i<str.length; i++) {
            if (str[i-1].equals("0") || str[i].equals("0")) {
                num = num + Integer.parseInt(str[i]);
            } else {
                num *= Integer.parseInt(str[i]);
            }
        }
        System.out.println(num);
    }
}
