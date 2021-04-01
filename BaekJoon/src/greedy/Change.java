package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {
    /**
     * 백준 5585 거스름돈(https://www.acmicpc.net/problem/5585)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        int[] money = {500, 100, 50, 10, 5, 1};
        int count = 0;

        num = 1000 - num;

        for (int i=0; i<money.length; i++) {
            count += num/money[i];
            num %= money[i];
        }

        System.out.println(count);

    }
}
