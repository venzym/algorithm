package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.*;

public class TwoArrayCalculation {
    /**
     * 백준 17140 이차원 배열과 연산(https://www.acmicpc.net/problem/17140)
     */
    private static int r, c, k;
    private static int[][] map = new int[101][101];
    private static int row = 3;
    private static int col = 3;
    public static void main(String[] args) throws IOException {

        //3x3
        //R : 모든 행 정렬(행 >= 열 개수)
        //C : 모든 열 정렬(행 < 열 개수)

        //a[r][c] == k가 되기 위한 최소 시간

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(st.nextToken());//R
        c = Integer.parseInt(st.nextToken());//C
        k = Integer.parseInt(st.nextToken());//a[r][c] == 'k'



        for (int i=0; i<3; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=0; j<3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[r-1][c-1] == k) {
            System.out.println(0);
            return ;
        }

        //전체 행의 개수와 열의 개수를 비교
        //수의 등장 횟수가 커지는 순으로 비교

        int cnt = 0;
        while (map[r-1][c-1] != k) {
            if (cnt > 100) {
                System.out.println(-1);
                return ;
            }

            if (row >= col) {
                active_r();
            } else {
                active_c();
            }
            cnt++;
        }//while

        System.out.println(cnt);
    }

    private static void active_r() {

        HashMap<Integer, Integer> hash = new HashMap<>();
        int temp = 0;
        for (int i=0; i<row; i++) {
            hash = new HashMap<>();
            for (int j=0; j<col; j++) {
                if (map[i][j] == 0) continue;

                if (hash.containsKey(map[i][j])) {
                    //이미 있는 숫자라면 개수 + 1
                    hash.put(map[i][j], hash.get(map[i][j]) + 1);
                } else {
                    //처음 보는 숫자면 삽입
                    hash.put(map[i][j], 1);
                }
                map[i][j] = 0;
            }

            //개수를 기준으로 정렬
            List<Entry<Integer, Integer>> valueSort = new ArrayList<Entry<Integer, Integer>>(hash.entrySet());
            Collections.sort(valueSort, new Comparator<Entry<Integer, Integer>>() {
                @Override
                public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                    if (o1.getValue() == o2.getValue()) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                }
            });
            //열 길이
            int size = valueSort.size()*2;
            //map에 채워넣기
            for (int j=0; j<size/2; j++) {
                map[i][j * 2] = valueSort.get(j).getKey();
                map[i][j * 2 + 1] = valueSort.get(j).getValue();
            }
            temp = Math.max(temp, size);
        }
        col = temp;
    }//active_r

    private static void active_c() {

        HashMap<Integer, Integer> hash;
        int temp = 0;
        for (int i=0; i<col; i++) {
            hash = new HashMap<>();
            for (int j=0; j<row; j++) {
                if (map[j][i] == 0) continue;

                if (hash.containsKey(map[j][i])) {
                    //이미 있는 숫자라면 개수 + 1
                    hash.put(map[j][i], hash.get(map[j][i]) + 1);
                } else {
                    //처음 보는 숫자면 삽입
                    hash.put(map[j][i], 1);
                }
                map[j][i] = 0;
            }
            List<Entry<Integer, Integer>> valueSort = new ArrayList<Entry<Integer, Integer>>(hash.entrySet());
            Collections.sort(valueSort, new Comparator<Entry<Integer, Integer>>() {
                @Override
                public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                    if (o1.getValue() == o2.getValue()) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                }
            });
            int size = valueSort.size()*2;

            //map에 채워넣기
            for (int j=0; j<size/2; j++) {
                map[j * 2][i] = valueSort.get(j).getKey();
                map[j * 2 + 1][i] = valueSort.get(j).getValue();
            }
            temp = Math.max(temp, size);
        }
        row = temp;
    }//active_c

    private static void print(int[][] map) {

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }//print
}
