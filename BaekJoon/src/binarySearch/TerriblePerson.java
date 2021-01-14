package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TerriblePerson {
    /**
     * 백준 1764 듣보잡 (https://www.acmicpc.net/problem/1764)
     */
    public static void main(String[] args) throws IOException {

        //듣도 못한 사람
        //보도 못한 사람

        //듣도 + 보도 못한 사람

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] array = new String[n];
        for (int i=0; i<n; i++) {
            array[i] = reader.readLine();
        }

        Arrays.sort(array);

        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<m; i++) {
            String input = reader.readLine();
            int index = Arrays.binarySearch(array, input);
            if (index >= 0) {
                list.add(input);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }

    }
}




















