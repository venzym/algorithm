package brute_force;

import java.util.Scanner;

public class MakePelindrom {
    /**
     * 백준 1254 팰린드롬 만들기
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.println(calculate(input));

    }

    private static int calculate(String input) {

        int len = input.length();

        for (int i=0; i<len; i++) {
            if (isPalin(input.substring(i))) {
                return len+i;
            }
        }

        return len*2;
    }//calculate

    private static boolean isPalin(String input) {
        int len = input.length();

        for (int i=0; i<len; i++) {
            if (input.charAt(i) != input.charAt(len-i-1)) {
                return false;
            }
        }

        return true;
    }//isPalin

}
