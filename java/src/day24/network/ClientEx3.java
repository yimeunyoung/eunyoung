package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx3 {

	public static void main(String[] args) {
		int port = 5001;//1. 포트번호 설정
		String ip = "192.168.30.209"; // 1-1. 서버 IP설정 //클라이언트는 항상 서버 IP를 입력해야함
		Socket socket = new Socket();//2. 소켓 생성
		try{
			//3. 서버에게(IP,port) 연결 요청
			socket.connect(new InetSocketAddress(ip,port));
			//연결이 완료되면, 읽기/쓰기 기능을 실행
			Client client = new Client(socket);
			client.read();
			client.send();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}