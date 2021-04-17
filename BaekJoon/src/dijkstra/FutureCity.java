package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FutureCity {
    /**
     * 이것이 취업을 위한 코딩테스트다 p.259 미래 도시
     */
    private static int INF = (int)1e9;
    private static int n,m,x,k;

    private static int[][] graph = new int[101][101];

    private static int[] d = new int[100001];
    public static void main(String[] args) {

        //1번~N번
        //특정 회사끼리 서로 도로를 통해 연결
        //현재 1번 회사에 위치

        //연결된 2개의 회사는 양방향으로 이동 가능
        //특정회사와 다른 회사가 연결되어 있다면, 1만큼의 시간으로 이동 가능

        //1번 회사에서 K번 회사 방문 후 X번 회사로 가는 것

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<101; i++) {
            Arrays.fill(graph, INF);
        }

        for (int a=1; a<=n; a++) {
            for (int b=1; b<=n; b++) {
                if (a == b) {
                    graph[a][b] = 0;
                }
            }
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();


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

        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }
}
