class Solution {
    int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;

        //n행 4열
        //모든 칸 점수
        //한 행씩 내려간다
        //1행에서 1칸만 밟으면 된다.
        //같은 열 연속해서 밟을 수 없다.
        
        //얻을 수 있는 점수의 최대값
        //10억 : 완탐 삑
        
        //1    2    3    5 그대로
        //10   11   12   11 위 행과 더했을 때 구할 수 있는 최댓값
        //16!  15.  13.  13 위 행과 더했을 때 구할 수 있는 최댓값 -> 16
        
        //풀이
        //자신과 이전 행의 최댓값을 더해라(같은 열 제외)
        //반복
        
        int num = 0;
        for (int i = 1; i < land.length; i++) {
            
            for (int j = 0; j < 4; j++) {
                //j : 자신이 있는 열
                
                num = land[i][j];
                
                for (int k = 0; k < 4; k++) {
                    //k : 이전 열과 비교
                    
                    //같은 열 제외
                    if (j == k) {
                        continue;
                    }
                    
                    land[i][j] = Math.max(land[i][j], num + land[i - 1][k]);
                    answer = Math.max(answer, land[i][j]);
                }
            }
        }
        
        return answer;
    }
}
