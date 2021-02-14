package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LeastExpense {
    /**
     * 백준 1916 최소비용 구하기 (https://www.acmicpc.net/problem/1916)
     */

    private static int n,m;
    private static int start, target;
    private final static int INF = (int)1e9;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] d = new int[10001];

    public static void main(String[] args) throws IOException {

        //N개 도시
        //M개 버스
        //A->B 비용 최소화시키기

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
        }

        st = new StringTokenizer(reader.readLine());

        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        Arrays.fill(d, INF);

        dijkstra();

        System.out.println(d[target]);

    }

    private static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start,0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if (d[now] < dist) {
                continue;
            }

            for (int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.add(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }

    }//dijkstra

    static class Node implements Comparable<Node> {
        int index, distance;
        Node (int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        private int getIndex() {
            return this.index;
        }

        private int getDistance() {
            return this.distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }
}
