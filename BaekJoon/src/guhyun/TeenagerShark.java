package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TeenagerShark {
    /**
     * 백준 19236 청소년 상어 (https://www.acmicpc.net/problem/19236)
     */
    private static int n = 4;

    private static int max = 0;

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};//상 좌상 좌 좌하 하 우하 우 우상
    private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {

        //4x4
        //크기 1x1
        //한 칸에 물고기 한 마리
        //번호와 방향을 가짐
        //1 <= 번호 <= 16
        //같은 번호 물고기는 없다.
        //방향은 8방향

        //번호작은 순서대로 이동
        //빈칸, 다른 물고기 있는칸 이동 가능
        //상어, 범위 넘어가면 이동 불가능
        //방향 이동할 수 있는 칸 갈 때까지 방향 45도 회전시킴
        //다른 물고기가 있는 칸으로 이동시 서로 위치 변경(swap)

        //물고기 이동 후 상어 이동
        //방향에 있는 칸으로 이동 가능
        //한번에 여러 칸 이동 가능
        //물고기 있는 칸으로 이동했다면 물고기를 먹고, 물고기의 방향을 가지게 된다.
        //이동 중 지나가는 칸에 있는 물고기는 먹지 않는다.
        //물고기 없는 칸으로 이동 불가능
        //이동 가능한 칸 없으면 사라짐

        //상어가 먹을 수 있는 물고기 번호의 합의 최댓값

        //풀이
        //물고기
        //순서대로 이동해야 하니까 정렬
        //1. 방향에 물고기 있는지 확인 -> 있으면 이동 , 없으면 방향 전환
        //2. 물고기와 자리 변경

        //상어
        //1. 해당 방향에 물고기 있는지 확인
        //2. 어떻게 최대를 구할까

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[n][n];

        ArrayList<Fish> list = new ArrayList<>();

        StringTokenizer st;
        for (int i=0; i<4 ; i++){
            st = new StringTokenizer(reader.readLine());
            for (int j=0; j<4; j++) {
                Fish fish = new Fish();
                fish.x = i;
                fish.y = j;
                fish.num = Integer.parseInt(st.nextToken());
                fish.dir = Integer.parseInt(st.nextToken())-1;

                list.add(fish);
                map[i][j] = fish.num;
            }
        }

        fish_sort(list);//번호순 정렬

        Fish fish = list.get(map[0][0] - 1); //list는 0부터 시작
        Shark shark = new Shark(0, 0, fish.dir, fish.num);
        map[0][0] = -1; //상어 - -1
        fish.life = false;

        dfs(map, shark, list);
        System.out.println(max);
    }

    private static void dfs(int[][] map, Shark shark, ArrayList<Fish> list) {

        //최대값
        if (max < shark.sum) {
            max = shark.sum;
        }

        //물고기 이동
        moveFish(map, list);

        //상어 이동
        for (int i=1; i<4; i++) {
            int nx = shark.x + dx[shark.dir]*i;
            int ny = shark.y + dy[shark.dir]*i;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            if (map[nx][ny] <= 0) {
                continue;
            }

            //복사
            int[][] copyMap = new int[n][n];
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    copyMap[j][k] = map[j][k];
                }
            }
            //복사
            ArrayList<Fish> copyFish = new ArrayList<>();
            for (int j=0; j<list.size(); j++) {
                Fish f = list.get(j);
                copyFish.add(new Fish(f.x, f.y, f.num, f.dir, f.life));
            }

            //물고기 잡아먹기
            copyMap[shark.x][shark.y] = 0;
            Fish temp = copyFish.get(map[nx][ny]-1);
            Shark tempShark = new Shark(temp.x, temp.y, temp.dir, shark.sum + temp.num);
            temp.life = false;
            copyMap[temp.x][temp.y] = -1;

            dfs(copyMap, tempShark, copyFish);
        }

    }//dfs

    private static void moveFish(int[][] map, ArrayList<Fish> list) {

        for (int i=0; i<16; i++) {

            Fish fish = list.get(i);

            if (fish.life == false) {
                continue;
            }

            //방향전환 필요할 때때
           for (int j=0; j<dx.length; j++) {
               int ndir = (fish.dir + j)%8;
               int nx = fish.x + dx[ndir];
               int ny = fish.y + dy[ndir];

               if (isAvail(map, nx, ny)) {
                   continue;
               }

               map[fish.x][fish.y] = 0;

               if (map[nx][ny] == 0) {
                   //빈칸일 때
                   fish.x = nx;
                   fish.y = ny;
               } else if (map[nx][ny] > 0) {
                   //물고기 있을 때
                   //물고기 swap
                   Fish temp = list.get(map[nx][ny] - 1);
                   temp.x = fish.x;
                   temp.y = fish.y;

                   map[fish.x][fish.y] = temp.num;

                   //이동할 위치로 변경
                   fish.x = nx;
                   fish.y = ny;
               }

                map[nx][ny] = fish.num;
                fish.dir = ndir;
                break;
           }

        }

    }//moveFish

    private static boolean isAvail(int[][] map, int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == -1) {
            return true;
        }
        return false;
    }

    private static void fish_sort(ArrayList<Fish> list) {

        Collections.sort(list, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.num - o2.num;
            }
        });

    }

    static class Fish {
        int x, y, num, dir;
        boolean life = true;
        Fish(int x, int y, int num, int dir, boolean life) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.life = life;
        }

        public Fish() {

        }
    }

    static class Shark {
        int x, y, dir, sum;

        Shark(int x, int y, int dir, int sum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.sum = sum;
        }
    }
}













