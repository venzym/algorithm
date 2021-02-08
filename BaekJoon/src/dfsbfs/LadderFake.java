package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LadderFake {
    /**
     * 백준 15684 - 사다리 조작 (https://www.acmicpc.net/problem/15684)
     */
    private static int n,m,h;
    private static boolean[][] map;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static boolean flag = false;

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        //M*N
        //두 가로선이 연속하거나 접하면 안된다.
        //가로선은 점선 위에 있어야 한다.
        //i번 세로선의 결과가 i번이 나와야 한다.
        //추가해야 하는 가로선 개수의 최솟값

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());//세로선
        m = Integer.parseInt(st.nextToken());//가로선
        h = Integer.parseInt(st.nextToken());//세로선마다 가로선을 놓을 수 있는 위치의 개수

        map = new boolean[h+1][n+1];

        //m개 가로선
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //자신 오른쪽 기준으로 넣기(b - b+1)
            map[a][b] = true;
        }

        if (m==0) {
            //가로선 없을 때
            result = 0;
        } else {

            for (int i=0; i<=3; i++) {
                //추가 가로선 사용 개수
                flag = false;
                dfs(0,i);
                if (flag) {
                    result = i;
                    break;
                }
            }

        }

        if (result > 3) {
            //가로선 개수가 3보다 크거나 추가못했을 때
            result = -1;
        }

        System.out.println(result);


    }

    private static void dfs(int count, int max) {

        if (flag) {
            //
            return;
        }
        if (max == count) {
            //i개만큼 가로선 설치했을 때
            if (move()) {
                //동일한 행으로 끝났을 때
                flag = true;
            }
            return;
        }

        for (int j=1; j<=h; j++) {
            for(int i=1; i<n; i++) {
                if (!map[j][i-1] && !map[j][i] && !map[j][i+1]) {
                    //왼쪽, 현재, 오른쪽 가로선 없을 때 가로선 설치
                    map[j][i] = true;
                    dfs(count+1, max);
                    map[j][i] = false;
                }
            }
        }


    }//dfs

    private static boolean move() {

        for (int i=1; i<=n; i++) {
            //열
            int index = i;
            int level = 1;
            while (level <= h) {
                //행
                if (map[level][index]) {
                    //오른쪽으로 이동
                    index += 1;
                } else if (map[level][index-1]) {
                    //왼쪽으로 이동
                    index -= 1;
                }
                //행 한칸 밑으로
                level++;
            }

            if (index == i) {
                //동일한 행이면 패스
                continue;
            } else {
                return false;
            }
        }

        return true;

    }//move

}

















