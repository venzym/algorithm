package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaseBall {
	private static int n;
	private static int[][] map;
	private static int[] player;
	private static boolean[] visit;
	
	private static int max = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//N이닝
		//한 이닝에 3아웃 발생하면 종료
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1][10];
		
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[10];
		player = new int[10];
		
		player[4] = 1;
		visit[4] = true;
		
		dfs(2);
		
		System.out.println(max);
	}

	private static void dfs(int count) {
		
		if (count == 10) {
			
//			System.out.println();
//			for (int i=1; i<=9; i++) {
//				System.out.print(player[i] + " ");
//			}
//			System.out.println();
			
			play();
			
		} else {
			
			for (int i=1; i<10; i++) {
				if (!visit[i]) {
					visit[i] = true;
					player[i] = count;
					dfs(count+1);
					visit[i] = false;
				}
			}
			
		}
		
	}//dfs

	private static void play() {
		
		int score = 0;
		boolean[] base;
		int startPlayer = 1;
		
		for (int i=1; i<=n; i++) {
			int outCount = 0;
			base = new boolean[4];
			
			finish : while (true) {
				for (int j=startPlayer; j<=9; j++) {
					int hitter = map[i][player[j]];
					
					switch (hitter) {
					case 0:
						outCount++;
						break;
					case 1:
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								if (k==3) {
									score++;
									base[k] = false;
									continue;
								}
								
								base[k] = false;
								base[k+1] = true;
							}
						}
						
						base[1] = true;
						break;
					case 2:
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								if (k==3 || k==2) {
									score++;
									base[k] = false;
									continue;
								}
								base[k+2] = true;
								base[k] = false;
							}
						}
						
						base[2] = true;
						break;
					case 3:
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								score++;
								base[k] = false;
								continue;
							}
						}
						base[3] = true;
						break;
					case 4:
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								score++;
								base[k] = false;
								continue;
							}
						}
						score++;
						break;
					}
					
					if (outCount == 3) {
						startPlayer = j+1;
						if (startPlayer == 10) {
							startPlayer = 1;
						}
						break finish;
					}
				}
				
				startPlayer = 1;
			}
			
		}
		
		max = Math.max(max, score);
	}//play
}








