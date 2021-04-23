package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game {
    /**
     * 백준 1072 게임(https://www.acmicpc.net/problem/1072)
     */
    public static void main(String[] args) throws IOException {

        //X : 게임 횟수
        //Y : 이긴 게임
        //Z : 승률

        //앞으로 진행하는 모든 게임에서 이긴다.
        //게임을 최소 몇 번 더 해야 Z가 변하는지(Math.floor)

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long z = y * 100 / x;

        long start = 1;
        long end = 1000000000;

        if (z >= 99) {
            System.out.println(-1);
            return;
        }

        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            //추가로 진행한 경기 수 만큼 더해준다.
            long tempZ = 100 * (y + mid) / (x + mid);

            if (tempZ > z) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
