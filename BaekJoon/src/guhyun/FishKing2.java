package guhyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FishKing2 {
	/**
	 * 백준 17143 낚시왕 (https://www.acmicpc.net/problem/17143)
	 */
	
	private static int r, c, m;
	private static int result = 0;
	
	//방향 & 이동
	//1 : 위 
	//2 : 아래 
	//3 : 오른쪽
	//4 : 왼쪽 
	private static int[] dx = {0, -1, 1, 0, 0};
	private static int[] dy = {0, 0, 0, 1, -1};
	
	//상어집단
	private static ArrayList<Shark> list = new ArrayList<Shark>();
	
	public static void main(String[] args) throws IOException {
		
		//r : x
		//c : y
		//s : 속력
		//d : 방향
		//z : 크기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//상어 0마리면 0반환
		if (m == 0) {
			System.out.println(0);
			return;
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			list.add(new Shark(x, y, s, d, z));
		}
		
		
		for (int i=1; i<=c; i++) {
			//낚시!
			fish(i);
			
			//상어 이동
			moveShark();
			
			//약육강식
			eatShark();
		}
			
		System.out.println(result);
		
	}

	private static void eatShark() {
		
		// 이동 후 같은 칸에 여러개 있을 때 큰놈만 살아남기
		for (int i = 0; i < list.size(); i++) {
			Shark shark = list.get(i);

			int qx = shark.x;// r
			int qy = shark.y;// c
			int qz = shark.z;// 크기

			for (int j = 0; j < list.size(); j++) {
				if (i == j)
					continue;

				Shark shark2 = list.get(j);

				int nx = shark2.x;// r
				int ny = shark2.y;// c
				int nz = shark2.z;// 크기

				if (qx == nx && qy == ny) {
					if (qz > nz) {
						list.remove(j);
						// i가 j보다 앞쪽인 경우
//								if (i < j) {
//									i--;
//								}
						j--;
					} else if (qz < nz) {
						list.remove(i);
						// j가 i보다 앞쪽인 경우
//								if (j < i) {
//									j--;
//								}
						i--;
					}
				}

			}

		}
		
	}

	//낚시 
	private static void fish(int y) {
		//i : 열
		
		//가장 가까운 녀석 잡기
		
		int index = 0;
		int size = 0;
		int tempX = 0;
		
		for (int x=1; x<=r; x++) {
			tempX = Integer.MAX_VALUE;
			index = 0;
			size = 0;
			for (int i=0; i<list.size(); i++) {
				int qx = list.get(i).x;//r
				int qy = list.get(i).y;
				int qz = list.get(i).z;
				
				//같은 열에서
				if (qy == y) {
					//제일 작은 친구 찾기
					if (tempX > qx) {
						tempX = qx;
						index = i;
						size = qz;
					}
				}
				
			}
			
		}
		
		if (tempX != Integer.MAX_VALUE) {
			result += size;
			list.remove(index);
		}
	}

	private static void moveShark() {
		
		//상어 대 이동
		for (int i=0; i<list.size(); i++) {
			Shark shark = list.get(i);
			
			int qx = shark.x;//r
			int qy = shark.y;//c
			int qs = shark.s;//속력
			int qd = shark.d;//방향
			int qz = shark.z;//크기
			
			int nx = 0;
			int ny = 0;
			for (int j=0; j<qs; j++) {
				//qs만큼 칸 이동
				
				//방향에 따라 변경
				// x=1인 경우 위(1)을 바라볼 때 아래(2)로 변경
				// x=2인 경우 아래(2)를 바라볼 때 위(1)로 변경
				// x=3인 경우 오른쪽(3)을 바라볼 때 왼쪽(4)로 변경
				// x=4인 경우 왼쪽(4)을 바라볼 때 오른쪽(3)으로 변경
				
				boolean flag = false;
				//처음에 벽에 있는 경우 방향전환
				if (qd == 1 && qx <= 1) {
					qd = changeWay(qd);
					flag = true;
				} else if (qd == 2 && qx >= r) {
					qd = changeWay(qd);
					flag = true;
				} else if (qd == 3 && qy >= c) {
					qd = changeWay(qd);
					flag = true;
				} else if (qd == 4 && qy <= 1) {
					qd = changeWay(qd);
					flag = true;
				}
				
				//방향으로 1칸씩 이동
				nx = dx[qd];
				ny = dy[qd];
				
				//x, y 이동
				qx += nx;
				qy += ny;
				
				if (!flag) {
					//이동했는데 벽에 있는 경우 방향전환
					if (qd == 1 && qx <= 1) {
						qd = changeWay(qd);
					} else if (qd == 2 && qx >= r) {
						qd = changeWay(qd);
					} else if (qd == 3 && qy >= c) {
						qd = changeWay(qd);
					} else if (qd == 4 && qy <= 1) {
						qd = changeWay(qd);
					}
				}
				
			}//qs

//			System.out.println("i :: " + i + " , qx :: " + qx + " , qy :: " + qy + " , qs :: " + qs + " , qd :: " + qd + " , qz :: " + qz);
			list.set(i, new Shark(qx, qy, qs, qd, qz));
		}//list
//		System.out.println();
		
	}

	private static int changeWay(int qd) {
		
		switch (qd) {
		case 1://상
			return 2;
		case 2://하
			return 1;
		case 3://우
			return 4;
		case 4://좌
			return 3;
		}
		
		return 0;
		
	}
	
	static class Shark {
		int x, y, s, d, z;
		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}	

}

















