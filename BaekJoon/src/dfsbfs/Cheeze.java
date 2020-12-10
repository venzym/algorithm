package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cheeze {
   /**
    * 백준 2638 치즈 (https://www.acmicpc.net/problem/2638)
    */
   
   private static int n,m; //세로, 가로
   private static int[][] map;
   private static boolean[][] visit;
   
   private static int[] dx = {-1, 0, 1, 0};
   private static int[] dy = {0, 1, 0, -1};
   
   public static void main(String[] args) throws IOException {
      
      //냉동보관
      
      //4변 중 2변 이상이 실내온도의 공기와 접촉하면 1시간만에 녹는다.
      // -> 공기 2변 유무 파악
      
      //치즈 내부의 공간은 외부의 공기가 아니다.
      // -> 내부/외부 구분 
      
      //치즈 : 1, 외부 : -1, 내부 : 0
      
      //dfs 실행해 외부변 개수 카운트한다 
      //가장자리는 항상 치즈가 없다.(1,1)
      //녹을때마다 녹는곳 -1처리
      
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(reader.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      
      map = new int[n+1][m+1];
      visit = new boolean[n+1][m+1];
      
      for (int i=1; i<=n; i++) {
         st = new StringTokenizer(reader.readLine());
         for (int j=1; j<=m; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      
      
      int result = 0;
      while (true) {
         visit = new boolean[n+1][m+1];
         
         boolean flag = false;
         //치즈 외부 및 녹은곳 다 -1처리하기
         setAir(1,1);
         
         for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
               if (map[i][j] == 1) {
                  //치즈 존재할 때
                  if (dfs(i,j)) {
                     //외부 공기 2개 이상일 때
                     flag = true;
                  }
               }
            }
         }
         
         if (!flag) {
            break;
         }
         
         result++;
      }
      
      System.out.println(result);
      
      
   }

   private static void setAir(int x, int y) {
      
      //외부 및 녹은곳 -1처리
      map[x][y] = -1;
      visit[x][y] = true;
      
      for (int i=0; i<dx.length; i++) {
         int nx = x + dx[i];
         int ny = y + dy[i];
         
         if (nx < 1 || ny < 1 || nx > n || ny > m) {
            continue;
         }
         
         if (!visit[nx][ny] && map[nx][ny] != 1) {
            setAir(nx,ny);
         }
         
      }
      
   }

   private static boolean dfs(int x, int y) {
      
      int cnt = 0;
      for (int i=0; i<dx.length; i++) {
         int nx = x + dx[i];
         int ny = y + dy[i];
         
         if (nx < 1 || ny < 1 || nx > n || ny > m) {
            continue;
         }
         
         //인접변의 외부공기와 접촉 개수
         if (map[nx][ny] == -1) {
            cnt++;
         }
         
      }
      if (cnt >= 2) {
         //2개 이상일 때 녹는처리
         map[x][y] = 0;
         return true;
      }
      return false;
      
   }

}








