package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MagicSharkFireBall {
    /**
     * 백준 20056 마법사 상어와 파이어볼(https://www.acmicpc.net/problem/20056)
     */
    private static int N, M, K, r, c, m, d, s;
    private static Node[][] map;

    private static ArrayList<Node>[][] list;

    private static boolean comp = false;

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};//상, 상우, 우, 우하, 하, 하좌, 좌, 좌상
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {

        //NxN
        //파이어볼 M개 발사
        //(r,c), 질량:m, 방향:d, 속력:s

        //??1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다.

        //8방향

        //1. d방향으로 s(속력)칸 이동
        //2. 이동 후 한칸에 파이어볼 2개 이상일 떄
        //  - 하나로 합침
        //  - 4개로 나누어짐
        //      - 질량의 합 / 5
        //      - 속력의 합/ 개수
        //      - 합쳐지는 볼의 방향이 모두 홀수, 짝수 이면 0246 ,아니면 1357
        //      - 질량이 0인 파이어볼은 소멸!

        //남아있는 질량의 합

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken()); //NxN
        M = Integer.parseInt(st.nextToken()); //파이어볼 개수
        K = Integer.parseInt(st.nextToken()); //K번

        map = new Node[N][N];
        list = new ArrayList[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(reader.readLine());

            r = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken())-1;
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            list[r][c].add(new Node(r, c, m, s, d, true));
        }

        for (int i=0; i<K; i++) {
            //파이어볼 이동
            move_fireball();

//            print();

            //각 칸 확인
            sum_divide();

            //comp를 새로 넣은 파이어볼들과 다르게 변경 -> 연산 가능하게
            comp = !comp;
        }

        System.out.println(count_m());
    }

    private static int count_m() {

        int sum = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(list[i][j].size() == 0) continue;
                for (Node node : list[i][j]) {
                    sum += node.m;
                }
            }
        }

        return (sum);

    }//count_m

    private static void print() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (Node a : list[i][j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void sum_divide() {

        //각 칸에 파이어볼이 몇 개 있는지 세기
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int size = list[i][j].size();
                if (size >= 2) {
                    //파이어볼 개수 2개 이상일 때 합침
                    int sum_m = 0;
                    int sum_s = 0;
                    int odd_d = 0;
                    int even_d = 0;

                    for (int k=0; k<size; k++) {
                        Node node = list[i][j].get(k);
                        sum_m += node.m;
                        sum_s += node.s;

                        if (node.d % 2 == 0) {
                            //짝수
                            even_d++;
                        } else {
                            //홀수
                            odd_d++;
                        }
                    }

                    list[i][j].clear();

                    sum_m /= 5;
                    sum_s /= size;

                    if (sum_m == 0) {
                        continue;
                    }

                    int sum_d = 0;
                    if ((even_d > 0 && odd_d == 0) || (even_d == 0 && odd_d > 0)) {
                        //전부 짝수거나 홀수
                        //0 2 4 6
                        sum_d = 0;
                    } else {
                        //1 3 5 7
                        sum_d = 1;
                    }

                    for (int k=sum_d; k<8; k+=2) {
                        list[i][j].add(new Node(i, j, sum_m, sum_s, k, comp));
                    }

                }
            }
        }

    }//sum_divide

    private static void move_fireball() {

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {

                if (list[i][j].size() > 0) {

                    for (int k=0; k<list[i][j].size(); k++) {
                        if (list[i][j].get(k).flag == comp) {
                            continue;
                        }

                        int lr = list[i][j].get(k).r;//x
                        int lc = list[i][j].get(k).c;//y
                        int lm = list[i][j].get(k).m;//질량
                        int ls = list[i][j].get(k).s;//속도
                        int ld = list[i][j].get(k).d;//방향

                        //ls만큼 이동
                        int nx = (lr + dx[ld]*ls) % N;
                        int ny = (lc + dy[ld]*ls) % N;

                        if (nx < 0) {
                            nx += N;
                        }

                        if (ny < 0) {
                            ny += N;
                        }

                        //주어진 방향으로 이동
                        list[nx][ny].add(new Node(nx, ny, lm, ls, ld, comp));
                        list[i][j].remove(k--);
                    }

                }

            }
        }

    }//move_fireball

    static class Node {
        int r, c, m, s, d;
        boolean flag;

        //리스트에 쓰기
        Node (int r, int c, int m, int s, int d, boolean flag) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
            this.flag = flag;
        }

    }
}
