package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CombineFile {
    /**
     * 백준 11066 파일 합치기 (https://www.acmicpc.net/problem/11066)
     */
    private static int[] file;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {

        //두 파일 크기의 합 -> 비용(시간)

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {

            int k = Integer.parseInt(reader.readLine());

            file = new int[k];
            dp = new int[k][k];

            for (int[] i : dp) {
                Arrays.fill(i, Integer.MAX_VALUE);
            }

            StringTokenizer st = new StringTokenizer(reader.readLine());
            int sum = 0;

            //누적합합
           for (int i=0; i<k; i++) {
                sum += Integer.parseInt(st.nextToken());
                file[i] = sum;
            }

            sb.append(partition(0,k-1) + "\n");

        }//while

        System.out.print(sb.toString());
    }

    //A+B + A+B+C || B+C + A+B+C
    private static int partition(int i, int j) {

        //메모이제이션
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        //같을때는 필요없음
        if (i==j) {
            return 0;
        }

        //1 차이면 누적합 리턴
        if (i+1 == j) {
            dp[i][j] = partitionalSum(i,j);
            return dp[i][j];
        }


        int originalSum = partitionalSum(i,j);
        for (int k=i; k<j; k++) {
            int minLeft = partition(i,k);//왼쪽
            int minRight = partition(k+1, j);//오른쪽

            dp[i][j] = Math.min(dp[i][j], minLeft + minRight + originalSum);
        }

        return dp[i][j];

    }

    //부분합
    private static int partitionalSum(int i, int j) {
        if (i == 0) {
            return file[j];
        }
        return file[j]-file[i-1];
    }
}

















