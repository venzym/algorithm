package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonBag {
    /**
     * 백준 12865 평범한 배낭 (https://www.acmicpc.net/problem/12865)
     */
    public static void main(String[] args) throws IOException {

        //최대 가치

        //N개 물건
        //무게 W, 가치 V
        //V만큼 즐길 수 있음
        //최대 K만큼 무게 넣을 수 있음

        //그러니까 정해진 무게에서 최대 가치를 즐기자?

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n+1];
        int[] value = new int[n+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][k+1];
        //dp : 해당 무게에서 가질 수 있는 최대 가치
        //j-weight >= 0 -> 현재 담을 수 있는 무게에서 물건 무게 뺐을 때 0이상인 경우 다른 물건 시도 가능

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=k; j++) {
                dp[i][j] = dp[i-1][j];
                if (j-weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n][k]);

    }
}
