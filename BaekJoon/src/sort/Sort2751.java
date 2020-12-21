package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort2751 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] data = new int[num];
		for(int i=0; i<num; i++) {
			data[i] = scan.nextInt();
		}
		quickSort(data, 0, num-1);
		for (int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}

	static void quickSort(int[] data, int start, int end) {
		//원소 1개인 경우
		if (start >= end) {
			return;
		}
		
		int key = start;
		int i = start+1;
		int j = end;
		int temp = 0;
		
		//엇갈리기 전까지 왼쪽, 오른쪽 비교
		while (i <= j) {
			while (i <= end && data[i] <= data[key]) {
				i++;
			}
			while (j > start && data[j] >= data[key]) {
				j--;
			}
		}
		
		//엇갈릴 때
		if (i > j) {
			temp = data[j];
			data[j] = data[key];
			data[key] = temp;
		}
		
		//왼쪽 -> 오른쪽(큰수찾기)
		quickSort(data, start, j-1);
		//오른쪽 <- 왼쪽(작은 수 찾기)
		quickSort(data, j+1, end);
		
	}
}

