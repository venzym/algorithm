package array;

import java.util.Scanner;

public class Eight {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//테스트 케이스의 개수
//		System.out.print("케이스 개수 : ");
		int count1 = scan.nextInt();
		int count2=0;
		float[] result = new float[count1];
		
		for (int i=0; i<count1; i++) {
			//케이스마다 학생 수
//			System.out.print("학생 수 :");
			count2 = scan.nextInt();
			
			float fresult = 0;
			
			//점수 담을 배열
			int[] arr = new int[count2];
			//합계 담을 정수
			float sum = 0;
			
			//점수 입력 & 합계 구할 for문
			for (int j=0; j<count2; j++) {
				arr[j] = scan.nextInt();
				sum += arr[j];
			}
			
			float avg = sum/count2;
			int num = 0;
			
			//한 줄씩 평균을 넘는 학생들의 비율 구할 for문
			for (int k=0; k<count2; k++) {
				if (arr[k] > avg) {
					num++;
				}
			}
			
			fresult = (float)num/count2*100;
			result[i] = fresult;
			
		}
		
		
		for (int i=0; i<count1; i++) {
			System.out.printf("%.3f%%\n", result[i]);
		}
		
	}
}
