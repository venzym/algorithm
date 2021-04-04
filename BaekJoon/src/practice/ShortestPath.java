package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath {
    /**
     * 백준 1753 최단경로(https://www.acmicpc.net/problem/1753)
     */
    private static int v, e, k;
    private final static int INF = (int) 1e9;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] d = new int[20001];

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        v = Integer.parseInt(st.nextToken());//정점
        e = Integer.parseInt(st.nextToken());//간선
        k = Integer.parseInt(reader.readLine());//시작정점번호

        for (int i=0; i<=v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra();

        for (int i=1; i<=v; i++) {
            if (d[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }

    }

    private static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));
        d[k] = 0;

        while (!pq.isEmpty()) {

            Node n = pq.poll();
            int index = n.index;
            int distance = n.distance;

            if (d[index] < distance) {
                continue;
            }

            for (int i=0; i<graph.get(index).size(); i++) {
                int cost = d[index] + graph.get(index).get(i).getDistance();

                if (cost < d[graph.get(index).get(i).getIndex()]) {
                    d[graph.get(index).get(i).getIndex()] = cost;

                    pq.add(new Node(graph.get(index).get(i).getIndex(), cost));
                }
            }

        }//while

    }//dijkstra

    static class Node implements Comparable<Node> {
        int index, distance;//index로 가는 거리(distance)
        Node(int index, int distance) {
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
            return (this.distance - o.distance);
        }
    }
}
