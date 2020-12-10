package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSFSDFS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()); //탐색을 시작할 번호

        int map[][] = new int[N+1][N+1];
        for (int i = 1; i <= M; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }

        int check[] = new int[N+1];

        DFS(map, check, V);
        System.out.println("");
        check = new int[N+1];
        BFS(map, check, V);
    }

    public static void DFS(int m[][], int check[], int p) {

        System.out.print(p + " ");
        check[p] = 1; //시작번호체크

        for (int i = 1; i < m[0].length; i++) {
            if (m[p][i] == 1 && check[i] == 0) {
                DFS(m, check, i);
            }
        }
    }

    public static void BFS(int m[][], int check[], int p) {

        Queue<Integer> q = new LinkedList<Integer>();

        check[p] = 1;
        q.add(p);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int i = 0; i < m[0].length; i++) {                
                if (m[node][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    q.add(i);
                }
            }
        }
    }
}