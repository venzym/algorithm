package samsung;

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

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; //상 좌상 좌 좌하 하 우하 우 우상
    private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[n+1][n+1];

        ArrayList<Fish> list = new ArrayList<>();

        StringTokenizer st;
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                Fish fish = new Fish();
                fish.x = i;
                fish.y = j;
                fish.num = Integer.parseInt(st.nextToken());
                fish.dir = Integer.parseInt(st.nextToken()) - 1;

                list.add(fish);
                map[i][j] = fish.num;
            }
        }

        map_sort(list);

        Fish fish                                                                                               = list.get(map[1][1] - 1);
        Shark shark = new Shark(1, 1, fish.dir, fish.num);
        map[1][1] = -1; //상어
        fish.live = false;

        dfs(map, shark, list);
        System.out.println(max);
    }

    private static void dfs(int[][] map, Shark shark, ArrayList<Fish> list) {

        //합계
        max = Math.max(max, shark.sum);

        //물고기 대이동
        move_fish(map, list);

        //상어 이동
        for (int i=1; i<4; i++) {
            int nx = shark.x + dx[shark.dir]*i;
            int ny = shark.y + dy[shark.dir]*i;

            if (nx < 1 || ny < 1 || nx > n || ny > n)
            {
                continue;
            }
            if (map[nx][ny] == 0) {
                continue;
            }

            //map복사
            int[][] copyMap = new int[n+1][n+1];
            for (int x=1; x<=n; x++) {
                copyMap[x] = map[x].clone();
            }

            //list복사
            ArrayList<Fish> copyList = new ArrayList<>();
            for (int x=0; x<list.size(); x++) {
                Fish f = list.get(x);
                copyList.add(new Fish(f.x, f.y, f.num, f.dir, f.live));
            }

            //물고기 잡아먹기
            copyMap[shark.x][shark.y] = 0;
            Fish tempFish = copyList.get(map[nx][ny] - 1);
            Shark tempShark = new Shark(tempFish.x, tempFish.y, tempFish.dir, shark.sum + tempFish.num);
            tempFish.live = false;
            copyMap[tempFish.x][tempFish.y] = -1;

            dfs(copyMap, tempShark, copyList);
        }//for


    }//dfs

    private static void map_print(int[][] map) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }//map

    private static void move_fish(int[][] map, ArrayList<Fish> list) {

        for (int i=0; i<list.size(); i++) {

            Fish fish = list.get(i);

            if (!fish.live) {
                continue;
            }

            for (int j=0; j<dx.length; j++) {
                int ndir = (fish.dir + j)%8;
                int nx = fish.x + dx[ndir];
                int ny = fish.y + dy[ndir];

                if (nx < 1 || ny < 1 || nx > n || ny > n || map[nx][ny] == -1) {
                    continue;
                }

                map[fish.x][fish.y] = 0;

                if (map[nx][ny] == 0) {
                    //물고기 없을 때
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    //물고기 있을 때
                    //swap
                    Fish temp = list.get(map[nx][ny] - 1);
                    temp.x = fish.x;
                    temp.y = fish.y;

                    map[fish.x][fish.y] = temp.num;

                    fish.x = nx;
                    fish.y = ny;
                }

                //이동할 칸에 번호, 방향 넣기기
                map[nx][ny] = fish.num;
                fish.dir = ndir;
                break;
            }

        }

    }//move_fish

    private static void map_sort(ArrayList<Fish> list) {
        Collections.sort(list, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.num - o2.num;
            }
        });
    }//map_sort

    static class Fish {
        int x, y, num, dir;
        boolean live = true;

        Fish(int x, int y, int num, int dir, boolean live) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
            this.live = live;
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

        public Shark() {

        }
    }
}
