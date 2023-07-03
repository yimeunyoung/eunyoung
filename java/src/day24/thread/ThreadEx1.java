package day24.thread;

public class ThreadEx1 {

	public static void main(String[] args) {//single thread는 앞의 작업이 다끝나야 다음 작업 시작 가능
		ChildThread1 chThread = new ChildThread1();
		chThread.start();
		for(int i = 0; i < 10; i++) {
			System.out.println("Work1");
		}
		/*
		for(int i = 0; i < 10; i++) {
   		System.out.println("Work2");
		}
		*/
		
	}

}
class ChildThread1 extends Thread{//multi thread
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Work2");
		}
	}
}