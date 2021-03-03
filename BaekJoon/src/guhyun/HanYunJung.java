package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HanYunJung {
    /**
     * 백준 2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데 (https://www.acmicpc.net/problem/2422)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            map[a1][a2] = 1;
            map[a2][a1] = 1;
        }

        int result = 0;
        for (int i=1; i<=n-2; i++) {
            for (int j=i+1; j<=n-1; j++) {
                for (int k=j+1; k<=n; k++) {
                    if (map[i][j] == 1 || map[j][k] == 1 || map[k][i] == 1) {
                        continue;
                    }
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
