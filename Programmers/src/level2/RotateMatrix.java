import java.util.*;

class Solution {
    ArrayList<Integer> list = new ArrayList();
    int[][] map;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        //2차원 배열 초기화
        int num = 1;
        map = new int[rows+1][columns+1];
        for (int i=1; i<=rows; i++) {
            for (int j=1; j<=columns; j++) {
                map[i][j] = num++;
            }
        }
        
        //1. 입력받은 영역 시계방향으로 1칸씩 회전
        for (int i=0; i<queries.length; i++) {
            answer[i] = rotate(rows, columns, queries[i]);
        }
        
        return answer;
    }
    
    void print() {
        for (int i=1; i<map.length; i++) {
            for (int j=1; j<map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    int rotate(int rows, int columns, int[] queries) {
        //3. 테두리만 회전하기
        
        int startX = queries[0];
        int startY = queries[1];
        int endX = queries[2];
        int endY = queries[3];
        
        //2. 회전하면서 최솟값 구하기(전역변수로 비교)
        int min = map[startX][startY];
        
        int x = queries[0];
        int y = queries[1];
        
        int time = 0;//4바퀴 돌리기 위한 변수 카운트, dx|dy에 필요한 인덱스
        int temp = map[startX][startY];//1,1 값 담아놓기 -> 제일 나중에 넣어줄 것
        while (time < 4) {
            
            int nx = x + dx[time];
            int ny = y + dy[time];
            
            if (nx < startX || ny < startY || nx > endX || ny > endY) {
                time++;
            } else {
                map[x][y] = map[nx][ny];
                min = Math.min(min, map[x][y]);
                
                x = nx;
                y = ny;
            }
        }
        map[startX][startY + 1] = temp;
        
        return (min);
    }
}
