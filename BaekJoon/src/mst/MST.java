package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST {
    /**
     * 백준 1197 최소 스패닝 트리(https://www.acmicpc.net/problem/1197)
     */
    private static PriorityQueue<Node> pq = new PriorityQueue();
    private static int result = 0;
    private static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int v = Integer.parseInt(st.nextToken());//정점
        int e = Integer.parseInt(st.nextToken());//간선

        parent = new int[v+1];

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Node(a, b, c));
        }

        for (int i=0; i<=v; i++) {
            parent[i] = i;
        }

        kruskal();

        System.out.println(result);
    }

    private static void kruskal() {

        while (!pq.isEmpty()) {

            Node n = pq.poll();
            int start = n.start;
            int end = n.end;
            int distance = n.distance;

            if (find(start) != find(end)) {
                union(start, end);
                result += distance;
            }

        }//while

    }//kruskal

    private static void union(int start, int end) {

        int a = find(start);
        int b = find(end);

        if (a != b) {
            parent[b] = a;
        }

    }//union

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }//find

    static class Node implements Comparable<Node> {
        int start, end, distance;

        Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return (this.distance - o.distance);
        }
    }
}
