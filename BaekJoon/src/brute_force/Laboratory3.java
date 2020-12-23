package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory3 {
    /**
     * 백준 17142 연구소3 (https://www.acmicpc.net/problem/17142)
     */
    private static int n, m;
    private static int[][] map;
    private static boolean[] visit;

    private static int result = Integer.MAX_VALUE;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static ArrayList<Virus> virusList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    virusList.add(new Virus(i,j));
                }
            }
        }

        visit = new boolean[virusList.size()];

        dfs(0);



    }//main

    private static void dfs(int count) {

        if (count == m) {

//            spreadVirus();

            result = Math.min(result, spreadVirus());

            System.out.println(result);

        } else {

            for (int i=0; i<virusList.size(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(count+1);
                    visit[i] = false;
                }
            }

        }

    }//dfs

    private static int spreadVirus() {

        Queue<Virus> q = new LinkedList<>();

        int[][] temp = new int[n+1][n+1];
        int[][] time = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            temp[i] = map[i].clone();
        }

        for (int i=0; i<virusList.size(); i++) {
            if (visit[i]) {
                q.add(virusList.get(i));
                temp[virusList.get(i).x][virusList.get(i).y] = 0;//활성바이러스 값
                time[virusList.get(i).x][virusList.get(i).y] = 1;//활성바이러스 시작시간
            }
        }

        int val = 0;

        while (!q.isEmpty()) {
            Virus v = q.remove();
            int qx = v.x;
            int qy = v.y;
            int qt = time[qx][qy];

            val = Math.max(val, qt);

            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n || temp[nx][ny] != 0 || time[nx][ny] != 0) {
                    continue;
                }

                if (temp[nx][ny] == 0 && time[nx][ny] == 0) {
                    time[nx][ny] = qt + 1;
                    temp[nx][ny] = 2;
                    q.add(new Virus(nx, ny));
                }

            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (temp[i][j] == 0 && time[i][j] == 0) {
                    return Integer.MAX_VALUE;
                }
            }
        }

        return val;

    }//spreadVirus

    static class Virus {
        int x, y;
        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
