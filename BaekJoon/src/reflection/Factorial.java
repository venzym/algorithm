package reflection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(read.readLine());
		
		System.out.println(cycle(n));
		
	}

	private static int cycle(int n) {
		
		if (n <= 1) {
			//0!은 1이다
			return 1;
		} 
		
		return cycle(n-1) * n;
		
	}
}
