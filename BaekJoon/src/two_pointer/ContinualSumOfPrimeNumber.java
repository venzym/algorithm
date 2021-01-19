package two_pointer;

import java.util.ArrayList;
import java.util.Scanner;

public class ContinualSumOfPrimeNumber {
    /**
     * 백준 1644 소수의 연속합 (https://www.acmicpc.net/problem/1644)
     */
    private static ArrayList<Integer> list = new ArrayList<>();
    private static int result = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean[] array = new boolean[n+1];

        for (int i=2; i<=n; i++) {
            //소수만 배열에 담기
        }

        solution(n,array);

        System.out.println(result);

    }

    private static void solution(int n, boolean[] array) {

        checkPrime(n, array);
        calculate(n, array);

    }//solution

    private static void calculate(int n, boolean[] array) {

        int sum = 0;
        for (int i=0; i<list.size(); i++) {
            sum = 0;
            for (int j=0; j+i<list.size(); j++) {
                sum += list.get(i+j);
                if (sum == n) {
                    result++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }


    }//calculate

    private static void checkPrime(int n, boolean[] array) {

        for (int i=2; i<=(n+1)/2; i++) {
            for (int j=2; i*j<=n; j++) {
                array[i*j] = true;
            }
        }
        array[1] = true;

        for (int i=2; i<=n; i++) {
            if (!array[i]) {
                list.add(i);
            }
        }

    }//checkPrime
}
