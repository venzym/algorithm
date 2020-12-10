package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenSmall2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 9;

        int[] height = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        Arrays.sort(height);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ( sum - height[i] - height[j] == 100 ) {
                    for (int k = 0; k < n; k++) {
                        if ( i == k || j == k ) continue;

                        System.out.println(height[k]);
                    }

                    System.exit(0);
                }
            }
        }
    }
}