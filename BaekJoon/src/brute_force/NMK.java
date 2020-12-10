package brute_force;

import java.util.Scanner;

public class NMK {
    static int N, M, K;
    static int[][] arr;
    static int maxvalue = Integer.MIN_VALUE;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] isCheck;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();

        arr = new int[N][M];
        isCheck = new boolean[N][M];
        for (int i = 0; i< N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

       findMax(0, 0, 0, 0);
        System.out.println(maxvalue);
    }


    static void findMax(int x, int y, int count, int sum){
        if(count==K){
            maxvalue= Math.max(maxvalue,sum);
        }
        else{
            for(int px=x;px<N;px++){
                for(int py=y;py<M;py++){
                    if(isValid(px,py)){
                        isCheck[px][py]=true;
                        findMax(x, y, count+1, sum+arr[px][py]);
                        isCheck[px][py]=false;
                    }
                }
            }
        }
    }
    static boolean isValid(int x, int y){
        boolean isValid=true;
        for(int i= 0 ;i<dir.length;i++){
            int tempX= x+dir[i][0];
            int tempY =y+dir[i][1];

            if(tempX>=0 && tempX<N && tempY>=0 && tempY<M){
                if(isCheck[tempX][tempY]){
                    isValid=false;
                }
            }
        }
        return isValid;
    }

    /*
    private static boolean isOkay(int i, int j){
        boolean result = true;

        if (isCheck[i][j])
            result = false;

        if (result) {
            for (int k = 0; k < dir.length; k++) {
                int nextI = i + dir[k][0];
                int nextJ = j + dir[k][1];

                if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < M) {
                    if (isCheck[nextI][nextJ]) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    private static void makeKValue(int len, int value, int startI, int startJ){
        if (len == K) {
            maxvalue = Math.max(maxvalue, value);
            return;
        }

        for (int i = startI; i< N; i++) {
            for (int j = startJ; j< M; j++) {
                if (isOkay(i, j)) {
                    isCheck[i][j] = true;
                    makeKValue(len+1, value + arr[i][j], i, j);
                    isCheck[i][j] = false;
                }
            }
        }
    }*/
}