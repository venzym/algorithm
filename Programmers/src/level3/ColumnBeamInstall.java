package level3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ColumnBeamInstall {
    /**
     * 프로그래머스 level3 기둥과 보 설치 (https://programmers.co.kr/learn/courses/30/lessons/60061)
     */
    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        Solution sol = new Solution();
        sol.solution(n, build_frame);
    }

    //기둥과 보 설치
    //길이 1

    //기둥 - 바닥 위, 보의 한쪾 끝 부분 위, 다른 기둥 위
    //보 - 한쪽 끝 부분이 기둥 위, 양쪽 끝 부분이 다른 보와 동시 연결

    //[x,y,a,b]
    //x : 가로
    //y : 세로
    //a - 0:기둥, 1:보
    //b - 0:삭제, 1:설치

    //바닥 보 x

    //return [x,y,a]
    //x좌표 기준 오름차순 -> y좌표 기준 오름차순

    private static ArrayList<Frame> list = new ArrayList<>();

   static class Solution {
        public int[][] solution(int n, int[][] build_frame) {

            for (int i=0; i<build_frame.length; i++) {
                int x = build_frame[i][1];
                int y = build_frame[i][0];
                int a = build_frame[i][2];
                int b = build_frame[i][3];

                installDelete(x, y, a, b);
            }

            int[][] answer = new int[list.size()][3];

            for (int i=0; i<list.size(); i++) {
                Frame f = list.get(i);
//                System.out.println(f.y + " " + f.x + " " + f.species);
                answer[i][0] = f.y;
                answer[i][1] = f.x;
                answer[i][2] = f.species;
            }

            Arrays.sort(answer, (o1, o2) -> {
                if(o1[0]==o2[0]){
                    if(o1[1]==o2[1]){
                        return o1[2]-o2[2];
                    } else {
                        return o1[1]-o2[1];
                    }
                } else {
                    return o1[0]-o2[0];
                }
            });

            return answer;
        }

       private void installDelete(int x, int y, int a, int b) {
           if (b == 0) {
               //삭제
               list.remove(new Frame(x,y,a));
               if (!isDelete(x,y)) {
//                   System.out.println("delete :: " + x + " " + y);
                    list.add(new Frame(x,y,a));
               }
           } else {
               //설치
               if (a == 0) {
                   //기둥 생성
                   if (isColumn(x, y)) {
//                       System.out.println("col1 :; " + x + " " + y);
                       list.add(new Frame(x, y, a));
                   }
               } else {
                   //보 생성
                   if (isBeam(x, y)) {
//                       System.out.println("beam1 :; " + x + " " + y);
                       list.add(new Frame(x, y, b));
                   }
               }
           }
       }

       private boolean isDelete(int x, int y) {

            for (int i=0; i<list.size(); i++) {
                Frame f = list.get(i);
                if (f.species == 0) {
                    //기둥
                    if (!isColumn(f.x, f.y)) {
                        return false;
                    }
                } else {
                    //보
                    if (!isBeam(f.x, f.y)) {
                        return false;
                    }
                }
            }

            return true;

       }//isDelete

       private boolean isBeam(int x, int y) {
            //보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
            if (list.contains(new Frame(x-1,y,0)) || list.contains(new Frame(x-1, y+1, 0))) {
                //한쪽 끝 부분이 기둥 위
                return true;
            }
            if (list.contains(new Frame(x,y-1, 1)) && list.contains(new Frame(x, y+1, 1))) {
                //양쪽 끝 부분이 다른 보와 동시에 연결
                return true;
            }
            return false;
        }//isBeam

       private boolean isColumn(int x, int y) {
            //바닥 위, 보의 한쪾 끝 부분 위, 다른 기둥 위

            if (x==0) {
                //바닥 위
                return true;
            }
            if (list.contains(new Frame(x-1,y,0))) {
                //다른 기둥 위
                return true;
            }
            if (list.contains(new Frame(x, y-1, 1)) || list.contains(new Frame(x,y,1))) {
                //보의 한쪽 끝 부분 위
                return true;
            }
            return false;
       }//isColumn

   }

   static class Frame {
       int x, y, species;
       Frame (int x, int y, int species) {
           this.x = x;
           this.y = y;
           this.species = species;
       }

       @Override
       public boolean equals(Object object){
           Frame frame = (Frame)object;

           if(x==frame.x && y==frame.y && species==frame.species){
               return true;
           } else {
               return false;
           }
       }

   }//Frame
}
