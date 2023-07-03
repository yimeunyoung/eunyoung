package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
/* 이미 port를 사용중이어서 실행이 안되는 경우(서버를 연속 두번 실행하는 경우)
1. 원도우키를 눌러서 cmd를 검색 후 실행
-명령 프롬프트 실행
2. 명령어 입력
-netstat -ano
-netstat : 명령어
- -ano : 옵션
3.사용중인 포트번호를 확인
-로컬주소부분에 xx.xxx.xxx.xxx: 포트번호
4. 포트번호에 맞는 PID 확인
5. 작업관리자 실행
-작업표시줄 우클릭 -> 작업관리자 선택
6. 세부정보 택 클릭 후 확인한 PID에 맞는 프로그램을 작업끝내기 함.
*/
public class ClientEx2 {

	public static void main(String[] args) {
		int port = 5001;//1. 포트번호 설정
		String ip = "192.168.30.209"; // 1-1. 서버 IP설정
		Socket socket = new Socket();//2. 소켓 생성
		try{
			//3. 서버에게(IP,port) 연결 요청
			socket.connect(new InetSocketAddress(ip,port));
			
			Thread sendThread = new Thread(()->{
				Scanner sc = new Scanner(System.in);
				
				try{
					while(true){
						String str = sc.nextLine();
						byte [] bytes = str.getBytes();
						OutputStream os = socket.getOutputStream();
						os.write(bytes);
						os.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			sendThread.start();
			Thread readThread = new Thread(()->{
				try {
					InputStream is = socket.getInputStream();
					while(true) {
						byte [] bytes = new byte[1024];
						is.read(bytes);
						String str = new String(bytes);
						System.out.println("server : " + str);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			readThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}