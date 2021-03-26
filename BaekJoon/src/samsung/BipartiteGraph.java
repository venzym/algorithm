package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BipartiteGraph {
    /**
     * 백준 1707 이분 그래프(https://www.acmicpc.net/problem/1707)
     */
    private static int k, v, e;
    private static ArrayList<ArrayList<Integer>> list;
    private static int[] visit;

    public static void main(String[] args) throws IOException {

        //정점의 집합을 둘로 분할
        //각 집합에 속한 정점끼리 서로 인접하지 않도록 분할
        //이분그래프인지 판별

        //1. 인접정점 서로 다르게 표시(-1, 1)로
        //2. 정점돌면서 0인 정점 찾기 (연결되어 있지 않은 정점이 있을 수 있음)
        //3. 인접정점이 같은색이면 이분그래프가 아니다!

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(reader.readLine());

            v = Integer.parseInt(st.nextToken());//정점
            e = Integer.parseInt(st.nextToken());//간선

            visit = new int[v+1];
            list = new ArrayList<>();

            for (int j=0; j<=v; j++) {
                list.add(new ArrayList());
            }

            for (int j=0; j<e; j++) {
                st = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

            for (int j=1; j<=v; j++) {
                if (visit[j] == 0) {
                    bfs(j);
                }
            }

            boolean flag = true;
            loop :
            for (int j=1; j<=v; j++) {
                for (int k=0; k<list.get(j).size(); k++) {
                    if (visit[j] == visit[list.get(j).get(k)]) {
                        flag = false;
                        break loop;
                    }
                }
            }

            if (flag) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    private static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visit[start] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();
            int c = visit[temp];

            //현재 정점과 연결되어 있는 정점 개수 만큼
            for (int i=0; i<list.get(temp).size(); i++) {
                //인접 정점
                int index = list.get(temp).get(i);

                if (visit[index] == 0) {
                    //인접 정점이 0인데
                    if (c == 1) {
                        //자신은 1인 경우 -1로 변경
                        visit[index] = -1;
                    } else if (c == -1) {
                        //자신은 -1인 경우 1로 변경
                        visit[index] = 1;
                    }

                    q.add(index);
                }
            }
        }

    }//bfs

}
