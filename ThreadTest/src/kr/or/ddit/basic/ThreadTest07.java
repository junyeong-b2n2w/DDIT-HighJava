package kr.or.ddit.basic;

import javax.sound.midi.Track;
import javax.swing.JOptionPane;


/*
 * 컴퓨터와 가위바위보
 * 
 * 컴퓨터 가위바위보는 난수를 이요해서 구하고
 * 사용자의 가위바위보는 showInputDialog() 를 이용해서 입력받는다
 * 
 * 입력시간은 5초제한카운트다운
 * 
 * 5초안에 입력이 없으면 게임에 진것으로 처리함
 * 
 * 5초안에 입력이 완료되면 승패를 구해서 출력한다.
 * 
 * 컴퓨터 : 가위
 * 사람    : 바위
 * 
 * 결과 : 당신이 이겼습니다.
 * 
 * 
 * 
 * 
 * 
 */

public class ThreadTest07 {

	public static void main(String[] args) {
	
		int comRSP = (int)(Math.random()*3)+1;
		String strComRSP;
		if(comRSP ==1){ strComRSP = "가위";}
		else if(comRSP ==2){ strComRSP = "바위";}
		else{ strComRSP = "보";}
			
		Thread th1 = new DataInputThread1();
		Thread th2 = new CountDownThread1();
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		
		String result = whoWin(strComRSP, DataInputThread1.personInput );
		
		System.out.println("컴퓨터 : " + strComRSP);
		System.out.println("사용자 : " + DataInputThread1.personInput);
		System.out.println(result);
		
	}

	private static String whoWin(String strComRSP, String personInput) {
		
		if(strComRSP.equals(personInput)){
			return "게임에서 비겼습니다";
		}else if(strComRSP.equals("가위") && personInput.equals("바위")){
			return "사용자가 승리하였습니다";
		}else if(strComRSP.equals("가위") && personInput.equals("보")){
			return "컴퓨터가 승리하였습니다";
		}else if(strComRSP.equals("바위") && personInput.equals("보")){
			return "사용자가 승리하였습니다";
		}else if(strComRSP.equals("바위") && personInput.equals("가위")){
			return "컴퓨터가 승리하였습니다";
		}else if(strComRSP.equals("보") && personInput.equals("바위")){
			return "컴퓨터가 승리하였습니다";
		}else if(strComRSP.equals("보") && personInput.equals("가위")){
			return "사용자가 승리하였습니다";
		}
		
		return "입력이 올바르지 않습니다";
	}
	
}

class DataInputThread1 extends Thread{
	public static boolean inputCheck;
	public static String personInput;
	@Override
	public void run() {
		
		personInput = JOptionPane.showInputDialog("가위바위보 입력하세요");
		inputCheck=true;
		System.out.println("사용자 입력 : " + personInput);
		
		
		
	}
}



class CountDownThread1 extends Thread{
	@Override
	public void run() {
		System.out.println("5초내 입력하지 않을시 컴퓨터가 이깁니다.");
		for(int i = 5; i>= 0; i--){
			if(DataInputThread1.inputCheck == true){
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
	
		System.out.println("지정된 시간이 경과헀습니다 컴퓨터가 이겼습니다.");
		System.exit(0);
		
		
	}
}