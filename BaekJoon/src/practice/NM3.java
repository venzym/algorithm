package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NM3 {
	private static int n, m;
	private static int[] map;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[m];

		cycle(0);
		bw.flush();
		bw.close();
	}

	private static void cycle(int start) throws IOException {

		if (start == m) {
			for (int i = 0; i < m; i++) {
//				System.out.print(map[i] + " ");
				bw.write(map[i] + " ");
			}
			bw.newLine();
//			System.out.println();
		} else {

			for (int i = 1; i <= n; i++) {
				map[start] = i;
				cycle(start + 1);
			}

		}

	}
}
