package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimePelin {
    /**
     * 백준 1747 소수&팰린드롬 (https://www.acmicpc.net/problem/1747)
     */
    private static int n;
    private static boolean[] distinct = new boolean[1004001];
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램

        n = Integer.parseInt(reader.readLine());

        checkPrime();//소수판별

        int result = 0;

        for (int i=n; i<=1004000; i++) {
            //1. n보다 크거나 같고
            if (i < 10 && distinct[i]) {
                result = i;
                break;
            } else {

                if (checkPelin(Integer.toString(i)) && distinct[i]) {
                    //3. 팰린드롬 확인
                    result = i;
                    break;
                }
            }

        }

        System.out.println(result);

    }

    private static boolean checkPelin(String num) {

        int start = 0;
        int end = num.length()-1;

        while (start <= end) {

            if (num.charAt(start) != num.charAt(end)) {
                return false;
            }

            start++;
            end--;

        }//while

        return true;

    }//checkPelin

    private static void checkPrime() {

        //2. 소수 판별 <- 에라토스테네스의 체
        for (int i=2; i<=1004000; i++) {
            distinct[i] = true;
        }

        int num = (int)Math.sqrt(1004000);

        for (int i=2; i<=num; i++) {
            if (distinct[i]) {
                for (int j=i; i*j<=1004000; j++) {
                    distinct[i*j] = false;
                }
            }
        }

    }//checkPrime
}









