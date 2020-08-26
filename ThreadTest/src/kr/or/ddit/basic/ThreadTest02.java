package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		
		
		MyThread1 mt1 = new MyThread1();
		mt1.start();
		
		
		Runnable r1 = new MyRun();
		Thread th2 = new Thread(r1);
		th2.start();
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i< 200; i++){
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
				
			}
		};
		
		Thread th3 = new Thread(r2);
		th3.start();
		
	}

}

class MyThread1 extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i = 0; i< 200; i++){
			System.out.print("*");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

class MyRun implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i< 200; i++){
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
	}
	
}