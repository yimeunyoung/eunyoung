package day18.homework;

import java.util.Scanner;

public class ImgEx implements Program {
		/* 파일명을 입력받아 파일이 이미지인지 확인하는 코드를 작성하세요.
		이미지 확장자 : jpg, bmp, png(더 있지만 간단하게 3개만 체크)
		input : dog.jpg
		dog.jpg : Image

		input : dog.exe
		dog.exe : Not image */
	private Scanner sc = new Scanner(System.in);
	
	private final static int EXIT = 2;
	
	private final static String imgs[] = {"jpg", "bmp", "png"};
	
	@Override
	public void run() {

		int menu;
		do {
			
			printMenu();
			
			menu = sc.nextInt();
			
			System.out.println("===============");
			
			runMenu(menu);
			
		}while(menu != EXIT);
		
	}

	@Override
	public void printMenu() {
		System.out.println("===============");
		System.out.println("1. Input File Name");
		System.out.println("2. EXIT");
		System.out.print("Select Menu : ");
		
	}

	@Override
	public void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			InputFileName();
			break;
		case 2:
			System.out.println("EXIT!");
			break;
		default:
			System.out.println("Wrong menu!");
		}
	}

	private void InputFileName() {

		//파일명 입력
		System.out.print("Input File name : ");
		sc.nextLine();//엔터 처리
		String fileName = sc.nextLine();
		//확장자 추출
		//오른쪽부터 시작해서 처음 .의 위치 찾기
		int index = fileName.lastIndexOf('.');
		//오른쪽에서 첫 점부터 끝까지 확장자 추출
		String suffix = fileName.substring(index+1);
		//확장자가 이미지이면 
		if(checkImage(suffix)) {
			System.out.println(fileName + " : Image");
		}else {
			System.out.println(fileName + " : Not image");
		}
		
	}
	//확장자가 이미지인지 아닌지 알려주는 메서드
	private boolean checkImage(String suffix) {
		for(String img : imgs) {
			if(img.equals(suffix)) {
				return true;
			}
		}
		return false;
	}
	
}