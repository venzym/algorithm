package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlopeWay {
    /**
     * 백준 14890 경사로 (https://www.acmicpc.net/problem/14890)
     */
    private static int n, l;
    private static int[][] map;

    public static void main(String[] args) throws IOException {

        //nxn
        //높이
        //지나갈 수 있는 길이 몇 개 있는지!
        //길이 : 한 행, 한 열 전부. -> 한쪽 끝에서 다른쪽 끝까지 지나가는 것

        //경사로
        //낮은칸 -> 높은칸 순서로만 가능
        //높이차 1

        //같은 곳에 경사로 또 불가능
        //높이 1이상 차이나면 안댐
        //L 주어짐
        //경사로 떄문에 범위 벗어나면 안됨

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //풀이
        //다음 블록의 높이가 1차이날때 L길이만큼 확인
        //만약 경사로를 놓을 수 있다면 무슨 처리를.. -> true

        int cnt=0;

        for (int i=1; i<=n; i++) {
            if (check(i,0,0)) {
                //열
                cnt++;
            }
            if (check(0,i,1)) {
                //행
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static boolean check(int x, int y, int flag) {

        int[] height = new int[n+1];
        boolean[] visit = new boolean[n+1];

        for (int i=1; i<=n; i++) {
            if (flag == 0) {
                //열 체크
                height[i] = map[x][i];
            } else {
                //행 체크
                height[i] = map[i][y];
            }
        }

        for (int i=1; i<n; i++) {

            if (height[i] == height[i+1]) {

                continue;

            } else if (height[i]-1 == height[i+1]) {
                //내리막
                //왼 -> 오른쪽

                for (int j=i+1; j<i+1+l; j++) {
                    if (j > n) {
                        return false;
                    }
                    if (visit[j]) {
                        return false;
                    }
                    if (height[i+1] != height[j]) {
                        return false;
                    }
                    visit[j] = true;
                }

            } else if (height[i]+1 == height[i+1]) {
                //오르막
                //오른쪽 -> 왼쪽
                for (int j=i; j>i-l; j--) {
                    if (j < 1) {
                        return false;
                    }
                    if (visit[j]) {
                        return false;
                    }
                    if (height[i] != height[j]) {
                        //현재 위치가 경사로를 설치해야하는 위치이기 떄문에 높이가 같은지 비교
                        return false;
                    }
                    visit[j] = true;
                }

            } else {
                return false;
            }
        }
        return true;
    }//check


}










