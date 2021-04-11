package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoom {
    /**
     * 백준 1931 회의실 배정(https://www.acmicpc.net/problem/1931)
     */
    public static void main(String[] args) throws IOException {

        //회의실 사용표
        //시작시간과 끝나는 시간
        //각 회의가 겹치지 않고 사용할 수 있는 '최대 회의 개수'

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Node[] map = new Node[n];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[i] = new Node(start, end);
        }

        Arrays.sort(map, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.end == o2.end) {
                    return Integer.compare(o1.start, o2.start);
                }
                return Integer.compare(o1.end, o2.end);
            }
        });

        int cnt = 0;
        int start = 0;
        int end = 0;
        for (int i=0; i<n; i++) {
            start = map[i].start;
            if (start >= end) {
                cnt++;
                end = map[i].end;
            }
        }

        System.out.println(cnt);

    }

    static class Node {
        int start, end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
