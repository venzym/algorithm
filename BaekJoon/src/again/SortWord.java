package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortWord {

    /*
    백준 1181 단어 정렬(https://www.acmicpc.net/problem/1181)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(reader.readLine());
        }

        List<String> wordList = new ArrayList(set);

        //길이가 짧은 것부터
        Collections.sort(wordList, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                }
                return o1.compareTo(o2);
            }
        });

        // 결과 출력
        wordList.forEach(System.out::println);
    }
}
