package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Telegram {
    /**
     * 이것이 취업을 위한 코딩테스트다 p.262 전보
     */
    private static int n,m,c;
    private final static int INF = (int)1e9;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] d = new int[30001]; //최단경로테이블

    public static void main(String[] args) {

        //N개의 도시

        //X -> Y  통로가 설치되어 있어야 메시지 전송 가능
        //양방향이어야함

        //C에서 출발
        //메시지를 받게 되는 도시의 개수는 총 몇개
        //걸리는 시간

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node(b,c));
        }

        Arrays.fill(d, INF);

        dijkstra(c);

        int count = 0;//도달할 수 있는 노드의 개수
        int maxDistance = 0; //도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리

        for (int i=1; i<=n; i++) {
            //도달할 수 있는 노드인 경우
            if (d[i] != INF) {
                count+=1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        System.out.println((count-1) + " " + maxDistance);

    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start]=0;

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
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

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





