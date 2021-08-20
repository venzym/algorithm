import java.util.*;

class Solution {
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        
        //(i, j) : i학생이 평가한 j학생의 점수
        //자기 자신을 평가한 점수가 유일한 최고점, 최저점 이라면 제외하고 평균 구하기
        
        //1. 열행 순으로 연산하기
        //2. 합(sum), 최댓값(max), 최솟값(min) 구하고 (i,i)가 최솟값이나 최댓값과 겹치는지 확인 후 평균구하기
            //2-1. 만약 겹친다면 (합 - 겹친값) / scores.length - 1으로 평균 구하기
        //3. 학점(메소드 생성) 메기기
        
        double sum = 0;
        int min = 0;
        int max = 0;
        int avg = 0;
        for (int j=0; j<scores[0].length; j++) {//열
            sum = 0;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int i=0; i<scores.length; i++) {//행
                sum += scores[i][j];//총합 구하기
                min = Math.min(min, scores[i][j]);//최솟값 구하기
                max = Math.max(max, scores[i][j]);//최댓값 구하기
            }
            
            if (min == scores[j][j] && isUnique(min, j, scores)) {
                //자신이 최솟값이라면 빼기
                sum -= min;
                answer.append(getGrade(getAvg(sum, scores.length - 1)));
            } else if (max == scores[j][j] && isUnique(max, j, scores)) {
                //자신이 최댓값이라면 빼기
                sum -= max;
                answer.append(getGrade(getAvg(sum, scores.length - 1)));
            } else {
                answer.append(getGrade(getAvg(sum, scores.length)));
            }
            
        }//for
        
        
        
        return answer.toString();
    }//solution
    
    private boolean isUnique(int val, int col, int[][] scores) {
        
        int cnt = 0;
        
        for (int i=0; i<scores.length; i++) {
            if (scores[i][col] == val) {
                cnt++;
                if (cnt > 1) {
                    return (false);
                }
            }
        }
        
        return (true);
    }//isUnique
    
    private String getGrade(double num) {
        
        if (num >= 90) {
            return "A";
        } else if (num < 90 && num >= 80) {
            return "B";
        } else if (num < 80 && num >= 70) {
            return "C";
        } else if (num < 70 && num >= 50) {
            return "D";
        } else {
            return "F";
        }
        
    }//getGrade
                                   
    private double getAvg(double sum, int size) {
        return (sum / size);
    }//getAvg
}
