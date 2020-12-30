package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DownhillRoad {
    /**
     * 백준 1520 내리막 길 (https://www.acmicpc.net/problem/1520)
     */

    private static int m,n;

    private static int[][] map;
    private static int[][] dp;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m+1][n+1];
        dp = new int[m+1][n+1];

        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1,1));

    }

    private static int dfs(int x, int y) {

        if (x == m && y == n) {
            //도달했을때 추가탐색 필요 없다
            return 1;
        }
        if (dp[x][y] != -1) {
            //-1이 아닌 경우는 이미 방문했다(메모이제이션)
            return dp[x][y];
        } else {
            //-1인 경우만 방문
            dp[x][y] = 0;
            for (int i=0; i<dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || ny < 1 || nx > m || ny > n) {
                    continue;
                }

                if (map[x][y] > map[nx][ny]) {
                    //현재 값이 더 큰 경우
                    dp[x][y] += dfs(nx, ny);
                }
            }

        }

        return dp[x][y];
    }//dfs
}
