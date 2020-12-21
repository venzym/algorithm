package Wwwwhile;

public class Cycle {
	public static void main(String[] args) {
		
		int input = 26;
		
		int num = 0;
		int num2 = 0;
		int num3 = 0;
		while (true) {
			
			num = input/10 + input%10;
			System.out.println(num);
			num2 = num/10 + num%10;
			System.out.println(num2);
			num3 = num2/10 + num2%10;			
			System.out.println(num3);
			
			if (num3 == input) {
				break;
			}
		}
		
		
	}
}
