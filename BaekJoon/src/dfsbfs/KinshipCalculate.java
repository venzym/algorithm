package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class KinshipCalculate {
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 할아버지 - 2촌
		// 아버지 - 1촌 형제들 - 3촌
		// 나

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 사람 수
		int n = Integer.parseInt(reader.readLine());

		boolean[] visit = new boolean[n + 1];
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		int[] result = new int[n+1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		// 촌수 계산 값 넣기
		String[] input = reader.readLine().split(" ");
		int start = Integer.parseInt(input[0]);
		int parent = Integer.parseInt(input[1]);

		// 부모 자식들 관계의 개수
		int m = Integer.parseInt(reader.readLine());

		for (int i = 0; i < m; i++) {
			String[] str = reader.readLine().split(" ");
			int num1 = Integer.parseInt(str[0]);
			int num2 = Integer.parseInt(str[1]);

			list[num1].add(num2);
			list[num2].add(num1);
		}

		//System.out.println(bfs(start, parent, 0, list, visit));
		dfs(start, parent, result, list, visit);
		
		for (int i=1; i<=n; i++) {
			//System.out.println("result[" + i + "] :: " + result[i]);
			result[i] = result[i] == 0 ? -1 : result[i];
		}
		System.out.println(result[parent]);
	}

	private static void dfs(int start, int y, int[] result, ArrayList<Integer>[] list, boolean[] visit) {

		if (start == y) {
			//다른 노드 방문할 필요 없게 한다.
            Arrays.fill(visit, true);
			return;
		}
		
		// 처음 방문 처리
		visit[start] = true;

		// 해당 리스트에서 방문한적 없으면 탐색
		for (int i : list[start]) {
			if (!visit[i]) {
				//cnt++;
				result[i] = result[start]+1;
				dfs(i, y, result, list, visit);
			}
		}
		
	}
}
