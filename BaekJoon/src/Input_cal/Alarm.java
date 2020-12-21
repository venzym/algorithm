package Input_cal;

import java.util.Scanner;

public class Alarm {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int h = scan.nextInt();
		int m = scan.nextInt();
		
		int hCh = h;
		int mCh = m-45;
		
		if (mCh < 0) {
			mCh += 60;
			hCh--;
			if (hCh < 0) {
				hCh += 24;
			}
		}
		System.out.println(hCh + " " + mCh);
		
	}
}
