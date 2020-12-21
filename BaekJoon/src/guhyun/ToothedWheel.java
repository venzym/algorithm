package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ToothedWheel {
	/**
	 * 백준 14891 톱니바퀴 (https://www.acmicpc.net/problem/14891)
	 */
	public static void main(String[] args) throws IOException {
		
		//톱니 N극 S극
		//가장 왼쪽 1번 -> 2번 -> 3번 -> 4번
		
		//K번 회전 (반시계 or 시계)
		
		//회전한 톱니바퀴의 인접한 극이 다르면 같이 회전, 다르면 회전 x
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] wheel = new int[5][9];
		String[] str = new String[8];
		StringTokenizer st;
		for (int i=1; i<=4; i++) {
			str = reader.readLine().split("");
			for (int j=1; j<=8; j++) {
				wheel[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		int k = Integer.parseInt(reader.readLine());
		
		while (k-- > 0) {
			
			st = new StringTokenizer(reader.readLine());
			
			int wheelNum = Integer.parseInt(st.nextToken()); //톱니바퀴번호
			int direction = Integer.parseInt(st.nextToken()); //회전방향
			
			boolean[] checkPolar = new boolean[4];
			
			//인접극 동일 여부 파악
			for (int i=1; i<4; i++) {
				if (wheel[i][3] == wheel[i+1][7]) {
					checkPolar[i] = true;
				} 
			}
			
			//1 : 시계, -1 : 반시계
		
			//3. 회전시 같으면 인접톱니바퀴 회전 x, 다르면 회전 o
			//4. 인접톱니바퀴의 인접톱니바퀴도 고려해야함
			
			//1. 바퀴의 왼쪽 오른쪽 존재하는지 확인
			if (wheelNum == 1) {
				//왼쪽x, 오른쪽 o
				//2. 왼쪽의 극과 인접한 극 , 오른쪽의 극과 인접한 극 비교

				rotation(direction, wheel, wheelNum);
				if (!checkPolar[wheelNum]) {
					//극이 다르면 둘 다 회전
					//오른쪽은 반대방향으로 
					direction = changeDirection(direction);
					rotation(direction, wheel, wheelNum+1);

					//2-3 극이 다른 경우
					if (!checkPolar[2]) {
						direction = changeDirection(direction);
						rotation(direction, wheel, 3);
						
						//3-4 극이 다른 경우
						if (!checkPolar[3]) {
							direction = changeDirection(direction);
							rotation(direction, wheel, 4);
						}
					}
				}
				
			} else if (wheelNum == 2) {
				//왼쪽o, 오른쪽 o
				//2. 왼쪽의 극과 인접한 극 , 오른쪽의 극과 인접한 극 비교
				rotation(direction, wheel, wheelNum);
				if (!checkPolar[wheelNum-1] || !checkPolar[wheelNum]) {
					//2번째 톱니바퀴 회전
					
					//1번째 톱니바퀴 회전
					if(!checkPolar[wheelNum-1]) {
						direction = changeDirection(direction);
						rotation(direction, wheel, wheelNum-1);
						direction = changeDirection(direction);
					} 
					if (!checkPolar[wheelNum]) {
						//3번째 톱니바퀴 회전
						direction = changeDirection(direction);
						rotation(direction, wheel, wheelNum+1);
						
						//2-3 극이 다른 경우
						if (!checkPolar[3]) {
							direction = changeDirection(direction);
							rotation(direction, wheel, 4);
						}
					}
				}

			} else if (wheelNum == 3) {
				//왼쪽o, 오른쪽 o
				//2. 왼쪽의 극과 인접한 극 , 오른쪽의 극과 인접한 극 비교
				
				rotation(direction, wheel, wheelNum);
				if (!checkPolar[wheelNum] || !checkPolar[wheelNum-1]) {
					//3
					if(!checkPolar[wheelNum]) {
						direction = changeDirection(direction);
						rotation(direction, wheel, wheelNum+1);
						direction = changeDirection(direction);
					} 
					if (!checkPolar[wheelNum-1]) {
						direction = changeDirection(direction);
						rotation(direction, wheel, wheelNum-1);
						
						//1
						if (!checkPolar[1]) {
							direction = changeDirection(direction);
							rotation(direction, wheel, 1);
						}
					}
				}
				
			} else if (wheelNum == 4) {
				//왼쪽o, 오른쪽 x
				//2. 왼쪽의 극과 인접한 극 , 오른쪽의 극과 인접한 극 비교
				rotation(direction, wheel, wheelNum);
				if(!checkPolar[wheelNum-1]) {
					//4,3
					direction = changeDirection(direction);
					rotation(direction, wheel, 3);
					
					if (!checkPolar[2]) {
						direction = changeDirection(direction);
						rotation(direction, wheel, 2);
						if (!checkPolar[1]) {
							direction = changeDirection(direction);
							rotation(direction, wheel, 1);
						}
 					}
				}
			}
			
		}
		
		int sum = 0;
		if (wheel[1][1] == 1) {
			sum += 1;
		} 
		if (wheel[2][1] == 1) {
			sum += 2;
		} 
		if (wheel[3][1] == 1) {
			sum += 4;
		} 
		if (wheel[4][1] == 1) {
			sum += 8;
		}
		
		System.out.println(sum);
		
	}

	private static int changeDirection(int direction) {
		direction = direction == 1 ? -1 : 1;
		return direction;
	}//changeDirection

	private static void rotation(int direction, int[][] wheel, int wheelNum) {
		if (direction == 1) {
			//시계방향
			int temp = wheel[wheelNum][8];
			for (int i=8; i>=2; i--) {
				wheel[wheelNum][i] = wheel[wheelNum][i-1];
			}
			wheel[wheelNum][1] = temp;
			
		} else {
			//반시계방향
			int temp = wheel[wheelNum][1];
			for (int i=2; i<=8; i++) {
				wheel[wheelNum][i-1] = wheel[wheelNum][i];
			}
			wheel[wheelNum][8] = temp;
		}
	}//clockwiseRotation

}












