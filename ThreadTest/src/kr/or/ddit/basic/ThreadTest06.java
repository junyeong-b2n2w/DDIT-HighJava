package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread th1 = new DataInputThread();
		Thread th2 = new CountDownThread();
		
		th1.start();
		th2.start();
		
		
		
	}

}


class DataInputThread extends Thread{
	public static boolean inputCheck;
	@Override
	public void run() {
		
		String str = JOptionPane.showInputDialog("아무거나 입력하쇼");
		inputCheck=true;
		System.out.println("입력값 : " + str);
		
		
		
	}
}

class CountDownThread extends Thread{
	@Override
	public void run() {

		for(int i = 10; i>= 0; i--){
			
			if(DataInputThread.inputCheck == true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		System.out.println("지정된 시간이 경과헀습니다 프로그램을 종료합니다");
		System.exit(0);
		
		
	}
}