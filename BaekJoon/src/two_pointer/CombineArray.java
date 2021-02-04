package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombineArray {
    /**
     * 백준 11728 배열 합치기 (https://www.acmicpc.net/problem/11728)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int i=0;
        int j=0;

        while (i<n || j<m) {

            if (j >= m || (i<n && a[i] <= b[j])) {
                sb.append(a[i++] + " ");
            } else {
                sb.append(b[j++] + " ");
            }

        }//while

        System.out.print(sb);


    }
}
