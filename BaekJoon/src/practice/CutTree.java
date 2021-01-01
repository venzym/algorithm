package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutTree {
/**
 * 백준 2805 나무 자르기 (https://www.acmicpc.net/problem/2805)
 */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;

        int[] tree = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, tree[i]);
        }

        Arrays.sort(tree);

        int height = 0;

        while (start <= end) {

            long total = 0;

            int mid = (start+end)/2;

            for (int i=0; i<tree.length; i++) {
                if (tree[i] > mid) {
                    total += tree[i] - mid;
                }
            }

            if (total < m) {
                //자른 나무의 합이 m보다 작으면 더 낮은 높이 잘라보기
                //더 낮은 높이로 나무를 잘라야 많은 길이를 가져갈 수 있음.
                end = mid-1;
            } else {
                //자른 나무의 합이 m보다 크면 더 높은 높이 해보기
                start = mid+1;
                height = mid;
            }

        }

        System.out.println(height);

    }
}