package kr.or.ddit.basic;

public class ThreadTest17 {

	private int balance; //잔액이 저장될 변수
	
	
	
	public synchronized int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}

	//입금을 처리하는 메서드
	public void deposit(int money){
		balance += money;
	}
	
	//출금을 처리하는 메서드
	//출금 성공시 true, 실패시 false
	public synchronized boolean withdraw(int money){
		if(balance >=  money){  // 잔액 확인
			for(int i=1; i<= 100000000; i++){} // 시간지연용
			
			
			balance-=money;
			System.out.println("메서드 안에서 balance = "+ balance);
			return true;
		}else
			return false;
	}
	

	public static void main(String[] args) {

		final ThreadTest17 account = new ThreadTest17();
		account.setBalance(10000);
		
		Runnable r1 = new Runnable(){
			public void run() {
				boolean result = account.withdraw(6000);
				System.out.println("쓰레드에서 result = " + result + ", balance = "+ account.getBalance() );
			}
		};
		
		
		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r1);
		
		th1.start();
		th2.start();
		
		
	}

}
