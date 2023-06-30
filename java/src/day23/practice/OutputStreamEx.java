package day23.practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputStreamEx {

	public static void main(String[] args) {
		//정수를 1부터 10까지 파일에 저장하는 코드를 작성하세요.
		//파일명은 output1.txt
		
		try(FileOutputStream fos = new FileOutputStream ("output1.txt")){
			for(int i = 1; i <= 10 ; i++) {
				fos.write(i);
			}
			System.out.println("File writer success!");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try(
			FileOutputStream fos =  new FileOutputStream("output2.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeChars("Hello\n");
			for(int i = 1; i <= 10 ; i++) {
				oos.writeInt(i);
			}
			}catch (IOException e) {
				e.printStackTrace();
			}
	}
}
