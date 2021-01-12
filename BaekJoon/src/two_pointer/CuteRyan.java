package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CuteRyan {
    /**
     * 백준 15565 귀여운 라이언 (https://www.acmicpc.net/problem/15565)
     */
    public static void main(String[] args) throws IOException {

        //라이언 인형이 K개 이상 있는 가장 작은 연속된 인형들의 집합의 크기

        //범위 구하기!

        //k개 달성하면 start++
        //달성 못하면 end++

        //라이언 : 1
        //어피치 : 2

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());

        int[] dolls = new int[n];

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());

            if (dolls[i] == 1) {
                list.add(i);
            }
        }

        if (list.size() < k) {
            System.out.println(-1);
            return;
        }

        int distance = Integer.MAX_VALUE;

        for (int start=0; start<list.size(); start++) {
            int end = start;
            int cnt = 0;
            while (end<list.size() && cnt < k) {
                cnt++;
                end++;
            }

            if (cnt == k) {
                int left = list.get(start);
                int right = list.get(end-1);
                distance = Math.min(distance, right-left+1);
            }
        }

        System.out.println(distance);

    }
}
