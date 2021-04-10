package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    /**
     * 백준 11399 ATM(https://www.acmicpc.net/problem/11399)
     */
    public static void main(String[] args) throws IOException {

        //N명이 줄 서있음.
        //1~N번까지 번호가 매겨져 있음
        //P(i) : 돈 인출하는데 걸리는 시간

        //줄을 순서에 따라 인출에 필요한 시간의 합이 달라짐

        //P를 기준으로 오름차순으로 정렬

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());

        Node[] map = new Node[n];
        for (int i=0; i<n; i++) {
            map[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(map, (o1, o2) -> (o1.time - o2.time));

        int sum = 0;
        int time = 0;
        for (int i=0; i<n; i++) {
            time += map[i].time;
            sum += time;
        }

        System.out.println(sum);

    }
    static class Node {
        int index, time;

        Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
