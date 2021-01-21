package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_Heap {
    /**
     * 이것이 취업을 위한 코딩테스트다 - 다익스트라_큐
     */

    private static final int INF = (int)1e9;
    private static int n,m,start;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] d = new int[100001];//최단거리 테이블

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //그래프 초기화
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        //모든 간선 정보 입력받기
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            //a번 노드에서 b번 노드로 가는 비용이 c
            graph.get(a).add(new Node(b,c));
        }

        //최단 거리 테이블 모두 무한으로 초기화
        Arrays.fill(d, INF);

        //다익스트라 실행
        dijkstra(start);

        for (int i=1; i<=n; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }

    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,0));
        d[start] = 0;

        while (!pq.isEmpty()) {

            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if (d[now] < dist) {
                //기존방문시 더 길이가 짧았던 경우
                continue;
            }

            //현재가 더 짧은 경우
            for (int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }


        }//while

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

        //거리가 짧은 것이 높은 우선순위 가지도록 설정정
        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }//Node
}
