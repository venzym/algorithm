package guhyun;

import java.util.ArrayList;
import java.util.Scanner;

public class N_2747 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(0);
		list.add(1);
		list.add(1);
		
		for (int i=3; i<=n; i++) {
			int temp = list.get(i-2) + list.get(i-1);
			list.add(temp);
		}
		
		System.out.println(list.get(list.size()-1));
	}
}
