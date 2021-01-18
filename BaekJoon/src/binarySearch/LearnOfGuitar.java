package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LearnOfGuitar {
    /**
     * 백준 2343 기타 레슨 (https://www.acmicpc.net/problem/2343)
     */
    public static void main(String[] args) throws IOException {

        //N개의 레슨
        //순서 유지
        //i~j

        //블루레이 개수 줄이기
        //m개의 블루레이에 모든 동영상 녹화
        //블루레이의 크기(녹화 가능한 길이)를 최소로 하기
        //m개의 블루레이는 모두 같은 크기여야 함

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lesson = new int[n];

        int start = 0;//레슨 최대값
        int end = 0;//모든 레슨크기 합

        st = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            if (start < lesson[i]) {
                start = lesson[i];
            }
            end += lesson[i];
        }
        System.out.println(start + " " + end);

        //1+2+3+4 10
        //5+6+7 18
        //8+9 17

        //블루레이 크기 이분탐색

        while (start <= end) {
            int mid = (start+end)/2;
            int sum = 0;
            int cnt = 0;
            for (int i=0; i<n; i++) {
                if (sum+lesson[i] > mid) {
                    System.out.println("mid :: " + mid + " , sum+lesson["+ i +"] :: " + (sum+lesson[i]));
                    sum = 0;//초기화
                    cnt++;
                }
                sum += lesson[i];
            }
            System.out.println("start :: " + start + " , mid :: " + mid + " , end :: " + end + " , sum :: " + sum + " , cnt :: " + cnt);

            if (sum != 0) {
                //mid보다 큰 경우
                System.out.println("?!?!?!?! :: " + " , start :: " + start + " , mid :: " + mid + " , end :: " + end + " , sum :: " + sum + " , cnt :: " + cnt);
                cnt++;
            }
            if (cnt <= m) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        System.out.println(start + " " + end);

    }
}















