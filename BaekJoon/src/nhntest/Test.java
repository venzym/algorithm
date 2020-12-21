package nhntest;

import java.util.Scanner;

class Test {
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

		//둥그렇게 마주본다
		//술래 : 수건들고 돌면서 다른 사람에게 수건 내려놓음
		//첫 게임 : A가 술래
		//시계방향으로 B CDE...
		//술래에 절대 안걸리는 사람들 수, 명시
		
		
		//참여하는 사람들 배열
		char[] map = new char[numOfAllPlayers];
		
		//술래걸린 횟수
		int[] tagger = new int[numOfAllPlayers];
		//A는 시작부터 술래
		tagger[0] = 1;
		
		//술래 위치 저장
		//시작은 1번부터
		int location = 1;
		
		
		//A~ 입력
		for (int i=0; i<map.length; i++) {
			map[i] = (char)('A' + i);
		}
		
		//0번째 원소가 술래
		
		//namesOfQuickPlayers - 술래에 안걸리는 친구들
		
		//B, C는 술래가 되도 이전 술래를 따라잡는다.
		//술래가 되면 카운트+1, 이전 술래가 자기 위치에 존재
		
		//나머지는 술래가되면 자기 위치 그대로, 이전 술래가 자기위치에 존재한다.
		
		for (int i=0; i<numOfGames; i++) {
			//i번 게임 진행
			
			//이동 , 1 + 3 = 4(E)
			location += numOfMovesPerGame[i];
				
			if (!fast(location, map, tagger, namesOfQuickPlayers)) {
				//빠른친구들 없으면
				
				//술래횟수증가
				tagger[location] += 1;
				
				//술래 자리교환
				char temp = map[0];
				map[0] = map[location];
				map[location] = temp;
				
				//횟수도 자리교환
				int temp2 = tagger[0];
				tagger[0] = tagger[location];
				tagger[location] = temp2;
				
			} else {
				//빠른친구들이 있으면 
				
				//술래는 변하지 않고 이전 술래의 횟수만 증가
				tagger[0] += 1;
				
			}
			
			
			System.out.println("location :: " + location + " , map[location] :: " + map[location]);
			
		}
		
		for (int i=1; i<numOfAllPlayers; i++) {
			System.out.println(map[i] + " " + tagger[i]);
		}
		System.out.println(map[0] + " " + tagger[0]);
		
		
	}

	private static boolean fast(int location, char[] map, int[] tagger, char[] namesOfQuickPlayers) {
		
		char temp = map[location];
		for (int i=0; i<namesOfQuickPlayers.length; i++) {
			if (temp == namesOfQuickPlayers[i]) {
				return true;
			}
		}
		return false;
		
	}

	private static class InputData {
		int numOfAllPlayers;
		int numOfQuickPlayers;
		char[] namesOfQuickPlayers;
		int numOfGames;
		int[] numOfMovesPerGame;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0,
					inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
			for (int i = 0; i < inputData.numOfGames; i++) {
				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers,
				inputData.numOfGames, inputData.numOfMovesPerGame);
	}
}
