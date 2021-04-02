package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ToBeOne {
    /**
     * 나동빈(그리디) - 1이 될 때까지
     */
    public static void main(String[] args) throws IOException {

        //1. N - 1
        //2. N / K

        //ex) N = 17, K = 4

        //1. K의 배수가 될 때 까지 -1
        //2. 이후엔 K로 나누기

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        while (n != 1) {
            if (n % k != 0) {
                n -= 1;
            } else {
                n /= k;
            }
            count++;
        }

        System.out.println(count);
    }
}
