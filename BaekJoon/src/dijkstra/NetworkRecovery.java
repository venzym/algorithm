package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NetworkRecovery {
    /*
    백준 2211 네트워크 복구(https://www.acmicpc.net/problem/2211)
     */
    private static int n, m;
    private final static int INF = (int) 1e9;
    private static ArrayList<Node>[] graph;
    private static int[] d;
    private static int[] prev;

    public static void main(String[] args) throws IOException {

        //n개의 컴퓨터로 구성된 네트워크
        //몇 개의 컴퓨터들은 서로 통신이 가능
        //통신할 때는 서로 직접 연결되어 있거나, 회선과 다른 컴퓨터를 거쳐서 통신 가능

        //직접 연결 회선 - 회선을 이용해서 통신을 하는 데 드는 시간
        //여러개 회선 - 각 회선 통신이용 시간 합

        //해커 침입
        //1. 양방향 통신
        //2. 슈퍼컴퓨터 - 컴퓨터 최소 시간 < 네트워크 통신 최소 시간

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken()); //컴퓨터 개수
        m = Integer.parseInt(st.nextToken()); //회선 개수

        d = new int[n+1];
        prev = new int[n+1];

        graph = new ArrayList[n+1];

        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));//양방향
            graph[b].add(new Node(a, c));
        }

        Arrays.fill(d, INF);

        dijkstra();

        System.out.println(n-1);
        for (int i=2; i<=n; i++) {
            System.out.println(i + " " + prev[i]);
        }
    }

    private static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        d[1] = 0;

        while (!pq.isEmpty()) {

            Node temp = pq.poll();
            int index = temp.index;
            int distance = temp.distance;

            if (d[index] < distance) {
                continue;
            }

            for (Node node : graph[index]) {

                int cost = distance + node.distance;

                if (cost < d[node.index]) {
                    d[node.index] = cost;
                    //슈퍼컴 <-> 컴 통신시간 < 네트워크 통신
                    prev[node.index] = index;

                    pq.add(new Node(node.index, cost));
                }
            }

        }//while

    }//dijkstra

    static class Node implements Comparable<Node> {
        int index, distance;
        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance > o.distance) {
                return 1;
            }
            return -1;
        }
    }
}
