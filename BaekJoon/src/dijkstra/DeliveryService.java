package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DeliveryService {
    /**
     * 백준 1719 택배 (https://www.acmicpc.net/problem/1719)
     */
    private static int n,m;
    private final static int INF = (int)1e9;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        //경로표로 정리
        //정점(집하장)
        //간선(이동가능)

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));

        }

        for (int i=1; i<=n; i++) {
            dijkstra(i);
        }

        System.out.println(sb);

    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        boolean[] visit = new boolean[n+1];
        int[] path = new int[n+1];//노드 추적
        //정점 i 직전에 정점 j를 거쳐야 한다.(path[i]=j)
        int[] d = new int[n+1];

        Arrays.fill(d, INF);

        d[start] = 0;
        path[start] = start;

        while (!pq.isEmpty()) {

            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if (visit[now]) {
                //재방문시 패스
                continue;
            }
            visit[now] = true;

            for (int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    path[graph.get(now).get(i).getIndex()] = now;
                    pq.add(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }

        }//while

        findPath(start, path);

    }//dijkstra

    private static void findPath(int start, int[] path) {

        for (int i=1; i<=n; i++) {
            if (i == start) {
                sb.append("- ");
                continue;
            }
            int answer = 0;
            for (int j=i; j!=start; j=path[j]) {
//                System.out.println("i :: " + i + " , j :: " + j + " , path[j] :; " + path[j] + " , start :: " + start);
                answer = j;
            }
//            System.out.println();
            sb.append(answer + " ");
        }
        sb.append("\n");
//        System.out.println("--------------------------");

    }//findPath

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
