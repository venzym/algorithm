package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra_Simple {
    /**
     * 이것이 취업을 위한 코딩 테스트다 - 간단한 다익스트라 알고리즘
     */

    private static final int INF = (int)1e9;//무한(10억)
    private static int n, m, start;//n(노드),m(간선),start(시작노드)
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();//각 노드에 연결되어 있는 노드에 대한 정보
    private static boolean[] visit = new boolean[100001]; //방문체크
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

        //최단 거리 출력
        for (int i=1; i<=n; i++) {
            //도달 불가능하면, INFINITY 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                //도달 가능한 경우 거리 출력
                System.out.println(d[i]);
            }
        }

    }

    private static void dijkstra(int start) {

        //시작 노드 초기화
        d[start] = 0;
        visit[start] = true;

        for (int j=0; j<graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        //시작 노드를 제외한 전체 n-1개의 노드에 대해 반복
        for (int i=0; i<n-1; i++) {
            //현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();//index
            visit[now] = true;

            //현재 노드와 연결된 다른 노드를 확인
            for (int j=0; j<graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();

                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 갱신
                if (cost <d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }

    }//dijksra

    //방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    private static int getSmallestNode() {

        int min_value = INF;
        int index = 0; //가장 최단 거리가 짧은 노드(인덱스)
        for (int i=1; i<=n; i++) {
            if (d[i] < min_value && !visit[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;

    }//getSmallestNode

    static class Node {
        private int index, distance;

        Node (int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }
        public int getDistance() {
            return this.distance;
        }
    }
}
