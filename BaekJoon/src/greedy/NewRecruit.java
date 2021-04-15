package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NewRecruit {
    /**
     * 백준 1946 신입 사원(https://www.acmicpc.net/problem/1946)
     */
    public static void main(String[] args) throws IOException {

        //1차 서류, 2차 면접
        //'적어도 하나'가 다른 지원자보다 떨어지지 않는 자만 선발!
        //두개 다 모두 떨어진다면 선발되지 않는다.
        //선발할 수 있는 신입사원의 최대 인원 수

        //2개 다 정렬
        //하나 정렬 후 하나 비교

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        int[][] map;

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(reader.readLine());

            map = new int[n][2];

            StringTokenizer st;
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(reader.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            //서류정렬
            Arrays.sort(map, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[0] - o2[0]);
                }
            });

            int cnt = find_recruit(n, map);

            sb.append(cnt + "\n");

        }//while

        System.out.print(sb);
    }

    private static int find_recruit(int n, int[][] map) {

        int cnt = 1;
        int min_interview = map[0][1];

        //1번 제외
        for (int i=1; i<n; i++) {
            if (min_interview > map[i][1]) {
                cnt++;
                min_interview = map[i][1];
            }

        }

        return (cnt);

    }//find_recruit
}
