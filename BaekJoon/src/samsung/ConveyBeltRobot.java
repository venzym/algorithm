package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConveyBeltRobot {
    /**
     * 백준 20055 컨베이어 벨트 위의 로봇(https://www.acmicpc.net/problem/20055)
     */
    private static int n, k;
    private static int[] map;
    private static int[] weight;
    public static void main(String[] args) throws IOException {

        //길이 N 컨베이어 벨트
        //2N 벨트가 위아래로 감싸고 있음
        //길이 1간격 2N개의 칸으로 나뉨뉨

        //1 -> 2 -> 3 -> ... -> N -> N+1 -> 2N-1 -> 2N

        //1번 : 올라가는 위치
        //N번 : 내려가는 위치

        //내구도?
        //올라가거나 이동하면 그 칸의 '내구도 -= 1'
        //내구도 0인 칸에 로봇 올라갈 수 없음

        //1. 벨트 한 칸 회전
        //2. 맨 앞 로봇부터 한 칸 이동
        //3. 이동하기 위해서는 앞 칸에 로봇이 없어야 함 && 내구도가 1이상 남아있어야 함
        //4. 올라가는 위치에 로봇이 없다면 로봇 하나 올리기

        //5. 내구도 0인 칸의 개수가 K개 이상이면 과정 종료

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n];//로봇
        weight = new int[n*2];//이동x, 내구도 감소만

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n*2; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        //로봇 O(1), 로봇 X(0)

        //벨트 아래 위치에는 로봇 올릴 수 없음 -> 내린다(N에 위치)는 아예 로봇을 벨트 위에서 없앤다는 뜻

        int cnt = 0;
        int result = 0; //가중치 0 개수
        while (true) {
            cnt++;
            //1. 벨트 한 칸씩 이동
            //가중치
            int up = weight[n*2-1];
            for (int i=n*2-1; i>0; i--) {
                weight[i] = weight[i-1];
            }
            weight[0] = up;

            //로봇
            for (int i=n-1; i>0; i--) {
                map[i] = map[i-1];
            }
            map[0] = 0;//올라오는 위치
            map[n-1] = 0;//내려오는 위치

            //2. 로봇 이동
            for (int i=n-1; i>0; i--) {
                if (map[i] == 0 && map[i-1] != 0 && weight[i] >= 1) {
                    map[i] = map[i-1];
                    weight[i]--;
                    map[i-1] = 0;
                    if (weight[i] == 0) {
                        result++;
                    }
                }
            }
            map[n-1] = 0;

            //올리는 위치의 가중치가 0이 아니면 로봇 올림
            if (weight[0] > 0) {
                map[0] = 1;
                weight[0]--;
                if (weight[0] == 0) {
                    result++;
                }
            }


            if (result >= k) {
                break;
            }
        }

        System.out.println(cnt);


    }
}
