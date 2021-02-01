package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Scale {
    /**
     * 백준 2437 저울 (https://www.acmicpc.net/problem/2437)
     */
    public static void main(String[] args) throws IOException {
        //저울추 무게
        //추들을 사용해 측정할 수 없는 양의 정수 무게 중 최솟값

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //1~1000
        int n = Integer.parseInt(reader.readLine());

        int[] weights = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i=0; i<n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights);

        if (weights[0] != 1) {
            //1은 1밖에 못만듬
            System.out.println(1);
            return;
        }

        //1 1 2 3 6 7 30

        //1 2 4 7 13 20 50

        //1 - 1
        //2 - 1 2
        //4 - 3
        //7 - 5 6
        //13 - 8 9 10 11 12
        //20 - 14 15 16 17 18 19
        //50 - 21

        int sum = weights[0];
        for (int i=1; i<n; i++) {

            if (sum+1 < weights[i]) {
                System.out.println(sum+1);
                return;
            }

            sum += weights[i];
        }

        System.out.println(sum+1);

    }
}
