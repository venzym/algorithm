class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        //S 내부의 수가 모두 같으면, 하나로 압축시킨다.
        //수가 다르다면, 4개의 정사각형 영역으로 쪼개고 다시 압축을 시도한다.
        //최종적으로 남는 배열을 담아서 return!!
        
        quadTree(arr, 0, 0, arr.length, answer);
        
        return answer;
    }
    
    public void quadTree(int[][] arr, int x, int y, int size, int[] answer) {
        boolean check = false;

        int start = arr[x][y];
        //현재 x, y에서 size더한 만큼 값 확인하기
        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (start != arr[i][j]) {
                    //다른값이 하나 더 있을 때
                    check = true;
                    break;
                }
            }
            if (check) {
                //탈출
                break;
            }
        }
        
        if (check) {
            //같은 수가 있을 때
            //왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 재귀 가즈아
            int halfSize = size / 2;
            quadTree(arr, x, y, halfSize, answer);
            quadTree(arr, x + halfSize, y, halfSize, answer);
            quadTree(arr, x, y + halfSize, halfSize, answer);
            quadTree(arr, x + halfSize, y + halfSize, halfSize, answer);
        } else {
            if (start == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        }
    }
}
