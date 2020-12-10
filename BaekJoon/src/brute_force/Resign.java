package brute_force;

import java.util.Scanner;

public class Resign {
	private static int n;
	private static int[] t;
	private static int[] p;

	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		t = new int[n + 1];
		p = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}

		dfs(1, 0);

		System.out.println(max);

	}

	private static void dfs(int start, int sum) {

		if (start == n + 1) {
			// start가 8일때만 비교 가능
			max = Math.max(max, sum);

		} else {

			if (start > n) {
				// start가 8이 아니고, n보다 크면 비교 불가능
				return;
			}

			for (int i = start; i <= n; i++) {
				//현재 상담의 기간과 금액을 더해 그 날로 넘어간다.
				dfs(i + t[i], sum + p[i]);
				//연산이 끝나면 다른 경우의 수를 위해 다음 날짜로 넘어간다.
				dfs(i + 1, sum);
			}

		}

	}
}