package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pelindrom_Dp {
    /**
     * 백준 10942 팰린드롬? (https://www.acmicpc.net/problem/10942)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n+1];

        //dp : i~j까지 팰린드롬인지 아닌지
        boolean[][] dp = new boolean[n+1][n+1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=1; i<=n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        setDp(n, nums, dp);//dp배열 설정


        int m = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {

            st = new StringTokenizer(reader.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (dp[left][right]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }

        }//while

        System.out.print(sb);


    }

    private static void setDp(int n, int[] nums, boolean[][] dp) {
        //처음
        for (int i=1; i<=n; i++) {
            dp[i][i] = true;//i~i는 자기 자신 = 팰린드롬
            if (nums[i] == nums[i-1]) {
                //바로 뒤와 같으면 길이2짜리 팰린드롬
                dp[i-1][i] = true;
            }
        }

        for (int i=2; i<n; i++) {//i+1~n-1길이
            for (int j=1; j<=n-i; j++) {
                if (nums[j] == nums[j+i] && dp[j+1][j+i-1]) {
                    //처음==끝 && 처음+1~ == 끝-1~
                    dp[j][j+i] = true;
                }
            }
        }


    }//setDp
}












