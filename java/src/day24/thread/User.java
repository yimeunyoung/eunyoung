package day24.thread;

import lombok.Data;

public class User extends Thread {
	private Passbook pb;//통장
	private String name; //이름
	public User(String name, Passbook pb) {
		this.name = name;
		this.pb = pb;
	}
	@Override
	public void run() {
		pb.deposit(name, 10000);
	}
}

@Data
class Passbook{
	private int balance;
	//예금
	public synchronized void deposit(String name, int money) {//한 명이 입금중일 때 다른 사람이 입금하면 값이 달라지기 때문에 synchronized(동기화)를 입력하여 
		 													  //한 사람이 작업중일때 다른 사람이 작업하지 못하도록 함. 즉 한개의 스레드만 실행할 수 있음
		this.balance += money;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " : " + money);
		System.out.println("balance : " + this.balance);
	}
}


