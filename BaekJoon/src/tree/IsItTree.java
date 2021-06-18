package tree;

import java.io.IOException;
import java.util.*;

public class IsItTree {
    /**
     * 백준 6416 트리인가? (https://www.acmicpc.net/problem/6416)
     */
    public static void main(String[] args) throws IOException {

        //u - 나가는 간선, v - 들어오는 간선

        //트리
        //1. 루트 노드
        //2. 반드시 단 하나의 들어오는 간선 존재
        //3. 루트 -> 다른 노드.

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> tree;

        int time = 1;

        while (true) {

            tree = new HashMap();
            int cnt = 0;

            while (true) {

                int start = sc.nextInt();
                int end = sc.nextInt();

                if (start == -1 && end == -1) {
                    //프로그램 종료
                    return ;
                } else if (start == 0 && end == 0) {
                    //결과 출력 후 다른 케이스 이동
                    break;
                }

                tree.put(start, tree.getOrDefault(start, 0));
                tree.put(end, tree.getOrDefault(end, 0) + 1);

                cnt++;
            }//while

            int root = 0;
            boolean flag = true;

            for (Integer key : tree.keySet()) {
                if (tree.get(key) == 0) {
                    //end 노드가 0개면 루트노드
                    root++;
                } else if (tree.get(key) > 1) {
                    //노드가 2개 이상 들어오면 안돼
                    //루트 노드를 제외한 모든 노드는 반드시 단 하나의 들어오는 간선이 존재한다.
                    flag = false;
                    break;
                }
            }

            if (tree.size() == 0) {
                System.out.printf("Case %d is a tree.\n", time);
            } else if (!flag || root > 1 || cnt != tree.size() - 1) {
                System.out.printf("Case %d is not a tree.\n", time);
            } else {
                System.out.printf("Case %d is a tree.\n", time);
            }

            time++;
        }//while

    }
}
