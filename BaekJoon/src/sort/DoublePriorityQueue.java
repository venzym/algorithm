package sort;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DoublePriorityQueue {
    /**
     * 백준 7662 이중 우선순위 큐 (https://www.acmicpc.net/problem/7662)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        StringTokenizer st;

        while (t-- > 0) {
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();

            int k = Integer.parseInt(reader.readLine());

            while (k-- > 0) {

                st = new StringTokenizer(reader.readLine());

                char order = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (order == 'I') {
                    //삽입
                    maxQ.add(num);
                    minQ.add(num);

                } else {
                    //삭제

                    if (maxQ.size() > 0 || minQ.size() > 0) {
                        //비어있지 않을 때
                        if (num == 1) {
                            //최댓값 삭제
                            maxQ.remove();
                        } else {
                            //최솟값 삭제
                            minQ.remove();
                        }
                    } else {

                    }
                }
            }//k while

            //asdfasdfasdfasdf


        }//t while

    }

}



















