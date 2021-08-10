package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChickenDelivery {
    /**
     * 백준 15686 치킨 배달 (https://www.acmicpc.net/problem/15686)
     */
    private static int[][] map; // 지도

    private static List<Home> Addresses = new ArrayList<>();//치킨 리스트
    private static List<Home> Chickens = new ArrayList<>();//조합한 치킨 리스트
    private static List<Home> Houses = new ArrayList<>();//집 리스트

    private static int N, M;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int result = Integer.MAX_VALUE;//도시 치킨 거리 최솟값 결과
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    Addresses.add(new Home(i, j));//치킨 주소 리스트에 넣기
                } else if (map[i][j] == 1) {
                    Houses.add(new Home(i, j));//집 리스트에 넣기
                }
            }
        }

        boolean[] visit = new boolean[Addresses.size()];
        dfs(0, 0, visit);

        System.out.println(result);

    }

    private static void dfs(int start, int count, boolean[] visit) {

        if (count == M) {

            //도시 치킨 거리 찾기
            int sum = 0;
            for (int i = 0; i< Houses.size(); i++) {
                int distance = Integer.MAX_VALUE;
                int x = Houses.get(i).x;
                int y = Houses.get(i).y;
                for (int j=0; j<Chickens.size(); j++) {
                    int hx = Chickens.get(j).x;
                    int hy = Chickens.get(j).y;
                    distance = Math.min(distance, Math.abs(x - hx) + Math.abs(y - hy));
                }
                sum += distance;
            }

            //최솟값 비교
            result = Math.min(result, sum);
        } else {

            for (int i=start; i<Addresses.size(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    Chickens.add(Addresses.get(i));
                    dfs(i + 1, count + 1, visit);
                    Chickens.remove(Chickens.size() - 1);
                    visit[i] = false;
                }
            }

        }

    }//dfs

    private static void bfs(Home home) {
        //해당 위치에서 가장 가까운 치킨 위치 구하기
        int cnt = Integer.MAX_VALUE;

        Queue<Home> q = new LinkedList<>();
        boolean[][] visit = new boolean[N+1][N+1];
        visit[home.x][home.y] = true;
        q.add(new Home(home.x, home.y));

        while (!q.isEmpty()) {
            Home addr = q.poll();
            int qx = addr.x;
            int qy = addr.y;

            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > N) {
                    continue;
                }

                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    cnt = Math.min(cnt, Math.abs(qx - nx) + Math.abs(qy - ny));
                    break;
                }
                q.add(new Home(nx, ny));
                visit[nx][ny] = true;
            }
        }
        System.out.println("cnt :: " + cnt);
        result = Math.min(result, cnt);
    }//bfs

    static class Home {
        int x, y;

        public Home (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
