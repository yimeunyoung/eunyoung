package day11.homework;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import array.Array;

public class BaseballGameEx {

	public static void main(String[] args) {
		/*숫자 야구 게임을 구현하세요.
		 * 1 ~ 9사이의 중복되지 않은 세 수를 맞추는 게임.
		 * 규칙 :
		 * B : 같은 숫자가 있지만 위치가 다름
		 * S : 같은 숫자가 있고 위치가 같음
		 * 3O : 일치하는 숫자가 하나도 없음
		 * 예:
		 * 랜덤 숫자 : 1 9 5 
		 * 사용자 : 1 2 3
		 * 1S
		 * 사용자 : 4 5 6
		 * 1B
		 * 사용자 : 1 2 9
		 * 1S1B
		 * 사용자 : 2 3 4
		 * 3O
		 * 사용자 : 1 9 5
		 * 3S
		 * Good!
		 */
		int com[] = new int[3]; // 랜덤으로 생성된 수를 저장할 배열 
		int user[] = new int[3];// 사용자가 입력한 수를 저장할 배열
		int min =1, max =9;
		int strike = 0; //스트라이크 개수
		int ball = 0; //볼의 개수
		Scanner sc = new Scanner(System.in);
		List<BaseballGameEx> list = new ArrayList<>();
		
		//맞춰야할 숫자 3개를 랜덤으로 생성(중복X)
		Array.createRandomArray(min, max, com);
		//Array.printArray(com); // 나중에 주석처리
		
		//반복문
		String FileName = "src/day11/homework/game.txt";
		loadGame(FileName);
		do {
			//사용자가 숫자 3개를 입력
			System.out.print("user : ");
			for(int i = 0; i<user.length; i++) {
				user[i] = sc.nextInt();
			}
			//사용자 입력 체크 (중복된 것이 있으면 안됨)
			if(Array.arrayCheck(user)) {
				System.out.println("You must not enter the same number!");
				continue;
			}

			//판별
			//스트라이크 개수 판별
			strike = strike(com,user);
			
			//볼의 개수 판별
			ball = ball(com,user);
			
			//스트라이크와 볼의 개수에 맞게 출력
			printResult(strike, ball);
		}while(strike < 3);
		saveGame(FileName);
		
		System.out.println("Good!");
		sc.close();
	}
	
	private static void saveGame(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			BaseballGameEx bs = new BaseballGameEx();
				oos.writeObject(bs);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static void loadGame(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				BaseballGameEx tmp = (BaseballGameEx)ois.readObject();
				list.add(tmp);
				}
			}catch(FileNotFoundException e) {
				System.out.println("불러올 파일이 없습니다.");
			}catch(EOFException e) {	
				System.out.println("불러오기 완료.");
			}catch(IOException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				System.out.println("BaseballGame 클래스를 찾을 수 없습니다.");
			}
	}
	
	/** 스트라이크 개수를 판별하는 메서드
	 * => 두 배열에서 같은 번지에 있는 값들이 몇개 같은지 알려주는 메서드
	 * 매개변수 : 두 배열 => int arr1[], int arr2[]
	 * 리턴타입 : 같은 번지에 있는 값들이 몇개 같은지 => 몇개 => 정수 => int
	 * 메서드명 : strike
	 * */
	public static int strike(int arr1[], int arr2[]) {
		//배열 생성이 안된 배열이 1라도 있으면 비교할 수 없어서 0을 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		//배열의 개수가 다른 경우 작은 크기의 배열을 기준으로 비교하기 위해 size 계산
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		int count = 0; //스트라이크 개수
		for(int i = 0; i < size; i++) {
			//같은 번지에 있는 값들이 서로 같으면(스트라이크면)
			if(arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}
	
	/** 볼 개수를 판별하는 메서드
	 * => 두 배열에서 다른 번지에 있는 값들이 몇개 같은지 알려주는 메서드
	 * 매개변수 : 두 배열 => int arr1[], int arr2[]
	 * 리턴타입 : 다른 번지에 있는 값들이 몇개 같은지 => 몇개 => 정수 => int
	 * 메서드명 : strike
	 * */
	public static int ball(int arr1[], int arr2[]) {
		//배열 생성이 안된 배열이 1라도 있으면 비교할 수 없어서 0을 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int count = 0;
		//다른 번지를 비교해서 찾아도 되지만
		//두 배열에서 같은 숫자의 개수에서 스트라이크 개수를 빼면 볼의 개수
		for(int tmp : arr1) {
			//배열 1에서 꺼낸 값이 arr2에 있으면 개수를 증가 
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count - strike(arr1, arr2);
		// 이중 반복문을 이용해서 다른 번지를 비교하는 코드
		/*for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if(i == j) {
					continue;
				}
				if(arr1[i] == arr2[i]) {
				count++;
				}
			}
		}
		return count;
		*/
	}
	
	/** 스트라이크와 볼의 개수가 주어지면 결과를 출력하는 메서드 
	 * 매개변수 : 스트라이크 개수, 볼의 개수 => int strike, int ball
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printResult
	 * */
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
		System.out.print("30");
		}
		System.out.println();
	}
}



