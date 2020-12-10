package brute_force;

import java.util.Scanner;

public class N_18290 {
   
   private static int n;
   private static int m;
   private static int k;
   
   private static int[][] array; //행렬
   private static int[][] cal; //인접 확인
   
   private static int[] list; //선택한 값 넣을 배열
   
   private static int max = -100000;
         
   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      
      n = sc.nextInt();
      m = sc.nextInt();
      k = sc.nextInt();
      
      list = new int[k];
      
      cal = new int[n][m];
      array = new int[n][m];
      for (int i=0; i<n; i++) {
         for (int j=0; j<m; j++) {
            array[i][j] = sc.nextInt();
         }
      }
      
      cycle(0);
      
      System.out.println(max);
      
   }

   private static void cycle(int start) {
      
      if (start == k) { //시작숫자가 K개일때 최대값 넣기
         int temp = 0;
         for (int i : list) {
            temp += i;
         }
         max = Math.max(max, temp);
      } else {
         
         for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
               if (cal[i][j] > 0) {
                  continue;
               }
               go(i, j); //인접 판별
               list[start] = array[i][j]; //현재값 넣기
               cycle(start+1); //재귀
               back(i, j); //원상복귀
            }
         }
         
      }
      
   }

   private static void go(int x, int y) {
      cal[x][y]++; //현재값 +1
      if (y-1 >= 0) {
         //위가 존재할때
         cal[x][y-1]++;
      }
      if (x-1 >= 0) {
         //왼쪽이 존재할때
         cal[x-1][y]++;
      }
      if (y+1 < m) {
         //아래가 존재할때
         //0,0일때 실행 -> 0,1
         cal[x][y+1]++;
      }
      if (x+1 < n) {
         //오른쪽이 존재할때
         //0,0일때 실행 -> 1,0
         cal[x+1][y]++;
      }
   }
   
   private static void back(int x, int y) {
      cal[x][y]--;
      if (y - 1 >= 0) {
         cal[x][y-1]--;
      }
      if (x - 1 >= 0) {
         cal[x-1][y]--;
      }
      if (y + 1 < m) {
         cal[x][y+1]--;
      }
      if (x + 1 < n) {
         cal[x+1][y]--;
      }
   }
}