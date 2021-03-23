package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PhoneNumberList {
    /*
    백준 5052 전화번호 목록(https://www.acmicpc.net/problem/5052)
     */
    private static int t;
    private static int n;
    private static String[] list;
    public static void main(String[] args) throws IOException {

        //목록의 일관성?
        //한 번호가 다른 번호의 접두어(?)인 경우가 없어야 한다.
        //-> 위에 번호가 밑에 번호에서 겹치면 안된다.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = Integer.parseInt(reader.readLine());

            list = new String[n];
            for (int i=0; i<n; i++) {
                list[i] = reader.readLine();
            }

            //정렬하면 같은 접두어를 가진 문자열이 다음에 나오기 때문에 +1 번째만 비교
            Arrays.sort(list);

            boolean flag = false;

            for (int i=0; i<n-1; i++) {
                int now_len = list[i].length();
                int next_len = list[i+1].length();
                if (next_len > now_len) {
                    if (list[i].equals(list[i+1].substring(0, now_len))) {
                        flag = true;
                        break;
                    }
                }
            }//for
            if (!flag) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }//while
        System.out.print(sb);
    }
}











