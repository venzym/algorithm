package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExplorerGuild {
    /**
     * 나동빈(그리디) - 모험가 길드
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //모험가 n명
        int n = Integer.parseInt(reader.readLine());

        //공포도 높은 모험가는 쉽게 공포를 느낌
        //곰포도가 X인 모험가는 반드시 X명 이상인 그룹에 들어야 함
        //최대 몇 개의 그룹을 만들 수 있는가?

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        int group = 0;

        for (int i=0; i<n; i++) {
            cnt++;
            if (cnt >= arr[i]) {
                group++;
                cnt = 0;
            }
        }
        System.out.println(group);

    }
}
