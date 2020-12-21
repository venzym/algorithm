package nhntest;

import java.util.ArrayList;
import java.util.Scanner;

class Test2 {
	private static int cnt = 0;

	private static void solution(int day, int width, int[][] blocks) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

		// 오전에 벽돌을 쌓고, 오후에 한번 시멘트를 붓는다
		// 매일 최대한 양의 시멘트를 붓는다.
		// 다음날에는 시멘트 위에 벽돌 쌓을 수 있다.

		// day : 공사 기간 일수
		// width : 작업 영역의 너비

		// 좌우 겹치는 높이 확인
		// 좌우가 넓은 경우 왼쪽과 오른쪽 최대 높이 확인
		// (가운데 비어있고, 오른쪽이 클 때 가운데는 left만큼 증가)
		// 가운데 비어있고, 왼쪽이 클 때 가운데는 right만큼 증가

		for (int i = 0; i < day; i++) {

			//ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < blocks[i].length - 2; j++) {
				int left = blocks[i][j];
				int right = 0;
				int num = 0;
				if (left > blocks[i][j + 1] && left <= blocks[i][j + 2]) {
					// left가 1칸 후보다 크고, 2칸 후가 자기보다 크다
					// 그럼 left - 가운데 벽돌개수 만큼 시멘트 쌓으면 된다.
					num = left - blocks[i][j + 1];
					cnt += num;
					System.out.println("i :: " + i + " , j :: " + j + " , 1 :: " + num);
					blocks[i][j + 1] = left;
				} else if (left > blocks[i][j + 1] && left <= blocks[i][j + 2]) {
					// 가운데 비어있고, 오른쪽이 클 때 가운데는 left만큼 증가
					for (int k = j + 2; k < blocks[i].length; k++) {
						right = blocks[i][k];
						if (left <= right) {
							// 오른쪽에 left 이상인 벽돌이 나왔을 때 시멘트 붓고 멈춘다.
							for (int h = j + 1; h < k; h++) {
								num = left - blocks[i][h];
								System.out.println("2 :: " + num);
								cnt += num;
								blocks[i][h] = left;
							}
							break;
						}
					}

				} else if (left > blocks[i][j + 1] && left <= blocks[i][j + 2]) {
					// (가운데 비어있고, 왼쪽 클 때 가운데는 right만큼 증가)
					for (int k = j + 2; k < blocks[i].length; k++) {
						right = blocks[i][k];
						if (left >= right) {
							// 오른쪽에 left 이상인 벽돌이 나왔을 때 시멘트 붓고 멈춘다.
							for (int h = j + 1; h < k; h++) {
								num = right - blocks[i][h];
								System.out.println("3 :: " + num);
								cnt += num;
								blocks[i][h] = right;
							}
							break;
						}
					}
				}

			}

		}
		
		System.out.println(cnt);

	}

	private static class InputData {
		int day;
		int width;
		int[][] blocks;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.blocks = new int[inputData.day][inputData.width];
			for (int i = 0; i < inputData.day; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.width; j++) {
					inputData.blocks[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.day, inputData.width, inputData.blocks);
	}
}