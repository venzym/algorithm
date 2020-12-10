package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek2 {
   /**
    * 백준 12851 숨바꼭질2 (https://www.acmicpc.net/problem/12851)
    */
   
   private static int n, k;
   private static int[] map;
   private static int[] count;
   
   private static int[] dx = {-1, 1, 2};
   
   public static void main(String[] args) throws IOException {
      
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(reader.readLine());
      
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      map = new int[100001];
      count = new int[100001];
      
      bfs();
      
      System.out.println(map[k]-1);
      System.out.println(count[k]);
   }

   private static void bfs() {
      
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(n);
      
      count[n] = 1;
      map[n] = 1;

      while (!q.isEmpty()) {
         
         int num = q.remove();
         
         int nx = 0;
         for (int i=0; i<dx.length; i++) {

            if (i == 2) {
               //*2
               nx = num * dx[i];
            } else {
               //+1, -1
               nx = num + dx[i];
            }
            
            
            if (nx >= 0 && nx < 100001) {
               //0~100000
               
               //최소값 : map[num] + 1
               
               if (map[nx] == map[num] + 1) {
                  //다음지점이 최솟값인 경우
                  
                  //현재 위치까지 최솟값으로 오는 경우의 수를 더해줌
            	  //count[nx]++;
                  count[nx] += count[num];
               } else {
                  if (map[nx] == 0 || map[nx] > map[num] + 1) {
                     //방문x || 다음 값이 최소값보다 클 때
                     
                     //1초씩 증가하고, 
                     //최솟값보다 큰 경우 최솟값으로 변경 -> 최솟값 유지
                     map[nx] = map[num] + 1; 
                  
                     //nx 위치가 최솟값, 현재까지의 최솟값 넣기
                     count[nx] = count[num];
                     
                     q.add(nx);
                  }
               }
               
            }
            
         }
      }
      
   }
}










