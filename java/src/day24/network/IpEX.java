package day24.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpEX {

	public static void main(String[] args) {
		InetAddress inetAddress = null;
		
		try {
			//이름이 localhost인 곳의 IP주소 정보를 가져옴. 모든 PC가 같음
			inetAddress = InetAddress.getByName("localhost");
			System.out.println(inetAddress);
			//네이버 사이트의 IP주소 조회
			inetAddress = InetAddress.getByName("www.naver.com");
			System.out.println(inetAddress);
			//내 PC의 IP조회
			inetAddress = InetAddress.getLocalHost();
			System.out.println(inetAddress);
			InetAddress [] address = 
					InetAddress.getAllByName("www.naver.com"); //getAllByName은 모든 IP주소를 출력해줌
			for(InetAddress tmp : address) {
				System.out.println(tmp);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
