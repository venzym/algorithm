package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Firefly {
    /**
     * 백준 3020 개똥벌레 (https://www.acmicpc.net/problem/3020)
     */
    public static void main(String[] args) throws IOException {

        //동굴 길이 : n미터, 높이 : h미터
        //처음 - 석순
        //이후 - 종유석 -> 석순 -> 종유석 -> ...

        //파워 개똥벌레;;

        //파괴해야하는 장애물 최솟값, 구간 총 몇개인지?

        //어렵네

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] stalagmite = new int[h+1];//석순(아래)
        int[] stalactite = new int[h+1];//종유석(위)

        for (int i=0; i<n/2; i++) {
            stalagmite[Integer.parseInt(reader.readLine())]++;//석순
            stalactite[Integer.parseInt(reader.readLine())]++;//종유석
        }

        int[] down_sum = new int[h+1];//석순
        int[] up_sum = new int[h+1];//종유석

        for (int i=1; i<=h; i++) {
            down_sum[i] = down_sum[i-1]+stalagmite[i];
            up_sum[i] = up_sum[i-1]+stalactite[i];
        }

        int min = n;//파괴 장애물 최소
        int cnt = 0;//min 경우 개수

        for (int i=1; i<=h; i++) {

            int destroy = 0;//파괴 개수

            destroy += down_sum[h] - down_sum[i-1];//h-down[i]높이
            destroy += up_sum[h] - up_sum[h-i];

            if (min > destroy) {
                min = destroy;
                cnt = 1;
            } else if (min == destroy) {
                //파괴해야 하는 장애물 개수가 같으면 ++
                cnt++;
            }
        }//for

        System.out.println(min + " " + cnt);

    }
}
