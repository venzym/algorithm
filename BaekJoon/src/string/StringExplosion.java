package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringExplosion {
    /**
     * 백준 9935 문자열 폭발 (https://www.acmicpc.net/problem/9935)
     */
    public static void main(String[] args) throws IOException {

        //폭발하면 그 문자는 사라지며, 남은 문자열은 합쳐지게 된다.

        //폭발
        //문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하ㅔ 된다.
        //남은 문자열을 순서대로 이어붙여 새로운 문자열을 만든다.

        //새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
        //폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String explosion = reader.readLine();

        char[] result = new char[input.length()];
        char[] array = new char[input.length()];

        for (int i=0; i<explosion.length(); i++) {
            array[i] = explosion.charAt(i);
        }

        int length = explosion.length();

        //문자를 넣고나서 폭발문자를 만나면 다시 돌아와 다른 문자를 넣어준다.

        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i=0; i<input.length(); i++) {
            result[index] = input.charAt(i);
            index++;
            if (result[index-1] == array[length-1]) {
                //폭발문자 맨뒤가 같을 때
                if (index-length < 0) {
                    //폭발문자가 더 크면 안됨
                    continue;
                }

                boolean flag = false;
                for (int j=0; j<length; j++) {
                    if (result[index-1-j] != array[length-1-j]) {
                        flag=true;
                        break;
                    }
                }

                if (!flag) {
                    index -= length;
                }
            }
        }

        if (index==0) {
            System.out.println("FRULA");
        } else {
            for (int i=0; i<index; i++) {
                sb.append(result[i]);
            }
            System.out.println(sb);
        }

    }
}
