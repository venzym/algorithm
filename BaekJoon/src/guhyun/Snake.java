package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Snake {
    /**
     * 백준 3190 뱀 (https://www.acmicpc.net/problem/3190)
     */
    private static int n,k,l;
    private static int[][] snake;
    private static boolean[][] visit;

    private static int[] dx = {-1,0,1,0};//상우하좌
    private static int[] dy = {0,1,0,-1};

    private static HashMap<Integer, Character> changeDir;

    private static int result = 0;

    //방향
    //0 : 상
    //1 : 우
    //2 : 하
    //3 : 좌

    public static void main(String[] args) throws IOException {
        
        //사과 먹으면 뱀 길이가 늘어남
        //벽 or 자기자신과 부딪히면 게임 끝

        //왼쪽 맨위에서 시작

        //몸길이 늘려 다음칸에 위치
        //사과 있으면 사과없어지고, 꼬리 그대로
        //사과 없으면 꼬리 딸려옴

        //뱀 위치 - visit배열

        //몇초에 끝나는지!

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine()); //n*n
        k = Integer.parseInt(reader.readLine()); //사과개수

        snake = new int[n+1][n+1];
        visit = new boolean[n+1][n+1];

        StringTokenizer st;
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            snake[x][y] = 1;//사과
        }

        l = Integer.parseInt(reader.readLine());//방향변환횟수

        changeDir = new HashMap<>();
        for (int i=0; i<l; i++){
            //x초 후에 왼쪽(L) or 오른쪽(D)로 90도 방향 회전
            st = new StringTokenizer(reader.readLine());
            int second = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            changeDir.put(second, dir);//초, 방향(왼,오)
        }

        bfs(1,1);

        System.out.println(result+1);

    }

    private static void bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();//전체 이동
        Queue<Pair> snakeInfo = new LinkedList<>();//현재 뱀 길이(해당 위치)

        q.add(new Pair(x,y,0));
        snakeInfo.add(new Pair(x, y));
        //visit[x][y] = true;

        //방향
        //0 : 상
        //1 : 우
        //2 : 하
        //3 : 좌

        int dir = 1;//처음엔 오른쪽

        int snailX = x;
        int snailY = y;

        while (!q.isEmpty()) {

            Pair p = q.remove();
            int qx = p.x;
            int qy = p.y;
            int qt = p.time;

            //현재 방향에 따라서 왼쪽, 오른쪽 달라짐

            if (changeDir.containsKey(qt)) {
                char key = changeDir.get(qt);
                if (key == 'D') {
                    //오른쪽
                    dir = setRight(dir);
                } else {
                    //왼쪽
                    dir = setLeft(dir);
                }
                changeDir.remove(qt);
            }

            int nx = qx+dx[dir];
            int ny = qy+dy[dir];

            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                result = qt;
                break;
            }

            if (visit[nx][ny]) {
                result = qt;
                break;
            }

            if (snake[nx][ny] == 0) {
                //아무것도 없을 때 -> 그냥 칸만 이동 -> 뱀 길이 생각(꼬리제거)
                visit[snailX][snailY] = false;
                snakeInfo.poll();
                snakeInfo.add(new Pair(nx, ny));
                snailX = snakeInfo.peek().x;
                snailY = snakeInfo.peek().y;
            } else {
                //사과 있을 때 -> 몸길이 증가
                snake[nx][ny] = 0;
                snakeInfo.add(new Pair(nx, ny));
            }
            visit[nx][ny] = true;
            q.add(new Pair(nx,ny,qt+1));

        }//while

    }//bfs

    private static int setLeft(int dir) {

        //0 : 상
        //1 : 우
        //2 : 하
        //3 : 좌

        switch (dir) {
            case 0: //상
                return 3;
            case 1: //우
                return 0;
            case 2: //하
                return 1;
            case 3: //좌
                return 2;
        }

        return 0;

    }//setLeft

    private static int setRight(int dir) {

        //dir : 현재 방향
        //c : 왼쪽, 오른쪽

        //0 : 상
        //1 : 우
        //2 : 하
        //3 : 좌

        switch (dir) {
            case 0: //상
                return 1;
            case 1: //우
                return 2;
            case 2: //하
                return 3;
            case 3: //좌
                return 0;
        }

        return 0;

    }//setRight

    static class Pair {
        int x,y,time;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
