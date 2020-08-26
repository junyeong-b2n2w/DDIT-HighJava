package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		String str = JOptionPane.showInputDialog("아무거나 입력하쇼");
		
		System.out.println("입력값 : " + str);
		
		
		
		
		for(int i = 10; i>= 0; i--){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
