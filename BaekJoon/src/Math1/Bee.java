package Math1;

public class Bee {
	public static void main(String[] args) {
		
		//1 -> 2 -> 9 -> 22 -> 41 -> 66
		//	1	 7	  13	19	  25
		
		//1 -> 3 -> 11 -> 25 -> 45
		//	2	  8	   14    20
		
		//1 -> 4 -> 13 -> 28 -> 49
		//	3    9     15    21
		
		//1 -> 5 -> 15 -> 31 -> 53
		//	4	10		16	22
		
		//1 -> 6 -> 17 -> 34 -> 57
		//	5	 11     17    23
		
		//1 -> 7 -> 19 -> 37 -> 61
		//	6	12	   18	 24
		
		//2~7		5
		//8~19		11
		//20~37		17
		//38~61		23
		//62~91		29
		//92~
		
		//각 회전 시작 숫자
		int start = 2;
		
		int num = 2;
		
		//전체 회전 증가
		int count1 = 5;
		
		
		//회전 수
		int index = 1;
		
		boolean flag = true;
		
		while (flag) {
			
			start++;
			
			if (start > num + count1) {
				if (index == 1) {
					num += 6;
				} else {
					num += count1+1;
				}
				count1 += 6;
				index++;
					
			}
			System.out.println("회전 처음 숫자 : " + num);
			System.out.println("시작숫자 : " + start);
			System.out.println("회원증가수 : " + count1);
			System.out.println();
			
			if (start > 91) {
				break;
			}
			
		}
		
	}
}
