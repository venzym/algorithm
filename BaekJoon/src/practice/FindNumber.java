package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {
    /**
     * 백준 1920 수 찾기 (https://www.acmicpc.net/problem/1920)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] map = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<m; i++) {
            int input = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = map.length-1;
            sb.append((binarySearch(map,input,start,end) == -1 ? 0 : 1) + "\n");
        }

        System.out.print(sb);

    }

    private static int binarySearch(int[] map, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start+end)/2;

        if (map[mid] == target) {
            return mid;
        } else if (map[mid] <= target) {
            //찾은 원소가 target보다 작다 -> 오른쪽
            return binarySearch(map,target,mid+1,end);
        } else {
            return binarySearch(map,target,start,mid-1);
        }

    }
}
