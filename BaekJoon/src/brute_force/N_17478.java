package brute_force;

import java.util.Scanner;

public class N_17478 {
	private static int n;
	private static String answer1 = "\"재귀함수가 뭔가요?\"\n";
	private static String answer2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	private static String answer3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	private static String answer4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	private static String last = "라고 답변하였지.";
	private static String front = "----";
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		cycle(0);
		System.out.print(last);
	}

	private static void cycle(int count) {
		
		if (count == 0) {
			//첫번째 경우
			System.out.print("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
			System.out.print(answer1);
			System.out.print(answer2);
			System.out.print(answer3);
			System.out.print(answer4);
			cycle(count+1);
		} else {
			
			String dash = "";
			for (int i=0; i<count; i++) {
				dash += front;
			}
			
			if (count == n) {
				//마지막 경우
				System.out.print(dash + answer1);
				System.out.print(dash + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
				System.out.println(dash + last);
				return;
			} else {
				
				//처음+1 ~ 마지막-1
				System.out.print(dash + answer1);
				System.out.print(dash + answer2);
				System.out.print(dash + answer3);
				System.out.print(dash + answer4);
				cycle(count + 1);
				System.out.println(dash + last);
				
			}
			
		}
		
	}
}
