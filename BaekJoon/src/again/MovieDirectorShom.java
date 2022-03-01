package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieDirectorShom {

    /*
    백준 1436 영화감독 숌(https://www.acmicpc.net/problem/1436)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int number = 0;
        String str = "";
        while (n > 0) {
            number++;
            str = String.valueOf(number);

            if (str.contains("666")) {
                n--;
            }
        }

        System.out.println(number);
    }
}
