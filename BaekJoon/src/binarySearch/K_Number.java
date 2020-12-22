package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K_Number {
    /**
     * 백준 1300 K번째 수 (https://www.acmicpc.net/problem/1300)
     */
    public static void main(String[] args) throws IOException {

        //n*n배열
        //a[i][j] = ixj

        //배열 B n*n
        //오름차순 정렬

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        //1 2 2 3 3 4 6 6 9
        //4가 나오는 순서는 (4 이하의 개수) 번째
        //min((mid/i), n)
        //비교값에 n이 필요한 이유는 최댓값이 각 행의 개수를 넘어갈 수 없기 때문

        System.out.println(binarySearch(n, k, 1,k));

    }//main

    private static long binarySearch(int n, int k, long start, long end) {

        if (start > end) {
            return start;
        }

        long mid = (start+end)/2;//중간값
        long cnt = 0;//개수

        for (int i=1; i<=n; i++) {
            cnt += Math.min(mid/i, n);
        }

        if (cnt < k) {
            //k가 더 크므로 오른쪽 탐색
            return binarySearch(n, k, mid+1, end);
        } else {
            //k보다 작으므로 왼쪽 탐색
            return binarySearch(n, k, start, mid-1);
        }

    }//binarySearch
}









