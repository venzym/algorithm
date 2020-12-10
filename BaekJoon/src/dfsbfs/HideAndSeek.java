package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideAndSeek {
	private static int n, k;
	private static int[] map;
	private static boolean[] visit;
	
	private static int[] dx = {1, -1, 2};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split(" ");
		
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		map = new int[100001];
		visit = new boolean[100001];
		
		bfs();
		
		System.out.print(map[k]);
		
	}

	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visit[n] = true;
		
		int[] status = new int[3];
		
		while (!q.isEmpty()) {
			int num = q.remove();
			
			if (num == k) break; //방금 넣은 수가 k와 같으면 도착한 것
			
			status[0] = num + dx[0];
			status[1] = num + dx[1];
			status[2] = num * dx[2];
			
			for (int i=0; i<status.length; i++) {
				if (status[i] >= 0 && status[i] < 100001) {
					//0~100001 일 때
					if (!visit[status[i]] && map[status[i]] == 0) {
						//방문하지 않았고, 0일 때
						map[status[i]] = map[num] + 1; //1초씩 더하기
						visit[status[i]] = true; //방문처리
						q.add(status[i]); //큐에 넣기
					}
				}
			}
		}
	}
}







