import javafx.scene.control.Cell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class StemCell {
    /**
     * SWEA 줄기세포배양 (https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo&&)
     */
    private static int[][] map;
    private static boolean[][] visit;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static Queue<Cell> q;
    private static PriorityQueue<Cell> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            //무한확장대비
            map = new int[350][350];
            visit = new boolean[350][350];
            q = new LinkedList<>();
            pq = new PriorityQueue<>();

            for (int i=150; i<n+150; i++) {
                st = new StringTokenizer(reader.readLine());
                for (int j=150; j<m+150; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if(map[i][j] != 0) {
                        //세포
                        visit[i][j] = true;
                        q.add(new Cell(i, j, map[i][j], map[i][j], map[i][j]*2-1));
                    }
                }
            }

            for (int i=1; i<=k; i++) {
                //활성화체크
                activate(i);
                bfs(i);
            }

            System.out.println("#" + t + " " + q.size());


        }

    }//main

    private static void activate(int time) {
        for (int i=0; i<q.size(); i++) {
            Cell cell = q.remove();
            //활성화, 비활성화
            if (time <= cell.start) {
                q.add(cell);
            } else if (time == cell.start+1) {
                pq.add(cell);
            } else if (time > cell.start && time <= cell.end) {
                q.add(cell);
            }
        }
    }//activate

    private static void bfs(int time) {

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            if (time <= cell.end) {
                q.add(cell);
            }
            for (int i=0; i<4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];

                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    map[nx][ny] = cell.value;
                    q.add(new Cell(nx, ny, cell.value, time + cell.value, time + cell.value*2 -1));
                }
            }
        }

    }//bfs



    static class Cell {
        int x, y, value, start, end;

        Cell(int x, int y, int value, int start, int end) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.start = start;
            this.end = end;
        }
    }
}
















