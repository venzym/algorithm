package argorithmStudy;

import java.util.Scanner;

public class HiDust {
	
	//행
	static int r;
	//열
	static int c;
	//초
	static int t;
	//공기청정기 위
	static int upY = -1;
	//공기청정기 아래
	static int downY;
	static int map[][];
	//0,1 || 0,-1 || 1,0 || -1,0 
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		t = sc.nextInt();
		
		map = new int[r][c];
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				
				if (temp == -1) {
					//초기값을 -1로해 위에값을 upY, 아래값을 downY로 한다.
					if (upY == -1) {
						//2,0
						upY = i;
					} else {
						//3,0
						downY = i;
					}
				}
			}
		}
		
		
		//시간초만큼 확산, 순환
		for (int i=0; i<t; i++) {
			//확산
			diffusion();
			//순환
			cycle();
		}
		
		int sum = 0;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (map[i][j]<=0) {
					continue;
				}
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
		
	}

	//확산
	private static void diffusion() {
		
		//새로운 2차원 행렬 생성
		int diffMap[][] = new int[r][c];
		diffMap[upY][0] = -1;
		diffMap[downY][0] = -1;
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				//공기청정기는 패스
				if (map[i][j] <= 0) {
					continue;
				}
				
				int diffCnt = 0;
				int diffNum = map[i][j]/5;
				for (int k=0; k<dy.length; k++) {
					//상하좌우
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					//상하좌우가 0보다 작거나 행렬보다 크면 넘긴다.
					if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
						continue;
					}
					
					//상하좌우에 -1이 있으면 넘긴다.
					if (map[ny][nx] == -1) {
						continue;
					}
					
					//위 두 경우에 해당하지 않을 때, 상하좌우에 나눈값 더하기
					diffMap[ny][nx] += diffNum;
					diffCnt++;
				}
				//주변에 확산한 값 빼기
				diffMap[i][j] += map[i][j] - (diffCnt*diffNum);
				
			}
		}
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				map[i][j] = diffMap[i][j];
			}
		}
	}
	
	
	//순환
	private static void cycle() {
		//위, 아래 구분
		
		//위
		//1열
		//0,0 -> 1,0
		for (int i=upY-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		//1행
		//0,1 -> 0,0 ...
		for (int i=0; i<c-1; i++) {
			map[0][i] = map[0][i+1];
		}
		//8열
		//1,7 -> 0,7 ...
		for (int i=0; i<upY; i++) {
			map[i][c-1] = map[i+1][c-1];
		}
		//3행
		//2,1 -> 2,2
		for (int i=c-1; i>1; i--) {
			map[upY][i] = map[upY][i-1];
		}
		//공기청정기 옆 0만들기
		map[upY][1] = 0;
		
		//아래
		//1행
		//4,0 -> 3,0 ..
		for (int i=downY+1; i<r-1; i++) {
			map[i][0] = map[i+1][0];
		}
		//8행
		//7,1 -> 7,0 ...
		for (int i=0; i<c-1; i++) {
			map[r-1][i] = map[r-1][i+1];
		}
		//8열
		//6,8 -> 7,8
		for (int i=r-1; i>downY; i--) {
			map[i][c-1] = map[i-1][c-1];
		}
		//4헹
		//3,2 -> 3,3
		for (int i=c-1; i>1; i--) {
			map[downY][i] = map[downY][i-1];
		}
		//공기청정기 옆 0만들기
		map[downY][1] = 0;
	}
	
}
