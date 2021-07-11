package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TimeMachine {
    /**
     * 백준 11657 타임머신(https://www.acmicpc.net/problem/11657)
     */
    private static int n, m;
    private static ArrayList<Node>[] graph;
    private static int[] d;
    public static void main(String[] args) throws IOException {
        //N개의 도시
        //한 도시에서 출발해 다른 도시에 도착하는 버스 M개
        //A : 시작도시
        //B : 도착도시
        //C : 버스 이동시 걸리는 시간
        //C < 0 인 경우 시간 되돌아가기
        //C == 0 인 경우 순간 이동

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        d = new int[n+1];

        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }

        Arrays.fill(d, Integer.MAX_VALUE);

        if (BellmanFord()) {
            System.out.println(-1);
            return ;
        }

//        for (int i=2; i<=n; i++) {
//            if (d[i] == Integer.MAX_VALUE) {
//                System.out.println(-1);
//            } else {
//                System.out.println(d[i]);
//            }
//        }


    }

    private static boolean BellmanFord() {

        d[1] = 0;

        for (int i=1; i<n; i++) {
            for (int j=1; j< graph.length; i++) {
                for (Node node : graph[j]) {
                    if (d[j] != Integer.MAX_VALUE && d[j] + node.distance < d[node.index]) {
                        d[node.index] = d[j] + node.distance;
                    }
                }
            }
        }

        for (int i=1; i< graph.length; i++) {
            for (Node node : graph[i]) {
                if (d[i] != Integer.MAX_VALUE && d[i] + node.distance < d[node.index]) {
                    return (true);
                }
            }
        }

        return (false);

    }//BellmanFord

    static class Node {
        int index, distance;
        Node (int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
