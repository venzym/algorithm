package Math1;

import java.util.Scanner;

public class Sugar_Delivery {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		//3kg /	5kg
		//경우의 수
		//1. 5의 배수
		//	- N/5
		//2. 3의 배수
		//	- n/5 + (n%5)%3
		//3. 아무 배수도 아닐 때
		//	- a. ex) 17 : (17/5) + (17%5)%3
		//	- b. ex) 24 : (24/5) + (24%5)/3 + (24%
		
		
		
		//3 -> 1,0
		//5 -> 0,1
		//6 -> 2,0
		//8 -> 1,1
		//9 -> 3,0
		//10 -> 0,2
		//11 -> 2,1
		//12 -> 4,0
		//13 -> 1,2
					//15 -> 0,3
		//16 -> 2,2
					//18 -> 3,1
		//19 -> 3,2
		//20 -> 0,4
					//21 -> 2,3
		//23 -> 1,4
		//24 -> 3,3
		//25 -> 0,5
		//26 -> 2,4
		//27 -> 4,3
					//28 -> 1,5
		//29 -> 3,4
					//30 -> 0,6
		
		//31 -> 2,5
		//32 -> 4,4
		//33 -> 1,6
		//34 -> 8,2
		//35 -> 5,4
		//36 -> 2,6
		
	}
}











