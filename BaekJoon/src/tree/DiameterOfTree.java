package tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DiameterOfTree {
    /**
     * 백준 1967 트리의 지름(https://www.acmicpc.net/problem/1967)
     */
    private static ArrayList<Node>[] graph;
    private static boolean[] visit;
    private static int max;
    private static int max_index;
    public static void main(String[] args) throws IOException {

        //무방향 그래프
        //경로는 항상 1개
        //트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이

        //루트 노드는 무조건 1
        //간선의 가중치 < 100

        //dfs로 제일 깊은 곳
        //제일 깊은 곳에서 제일 깊은 곳 찾기


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        graph = new ArrayList[n+1];
        visit = new boolean[n+1];

        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        max = 0;
        max_index = 0;

        dfs(1, 0);

        max = 0;
        visit = new boolean[n+1];

        dfs(max_index, 0);

        System.out.println(max);

    }

    private static void dfs(int start, int weight) {

        if (visit[start]) {
            return;
        }

        visit[start] = true;

        if (max < weight) {
            max = weight;
            max_index = start;
        }

        for (Node n : graph[start]) {
            dfs(n.index, weight + n.distance);
        }

    }//dfs

    static class Node {
        int index, distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}