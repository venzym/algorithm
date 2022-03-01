package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EscapeRectangle {

    /*
    백준 1085 직사각형에서 탈(https://www.acmicpc.net/problem/1085)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] temps = reader.readLine().split(" ");
        int x = Integer.parseInt(temps[0]);
        int y = Integer.parseInt(temps[1]);
        int w = Integer.parseInt(temps[2]);
        int h = Integer.parseInt(temps[3]);

        //(0,0) -> (w,h)

        int answer = Math.min(w - x, h - y);
        answer = Math.min(answer, Math.min(x, y));
        System.out.println(answer);
    }
}
