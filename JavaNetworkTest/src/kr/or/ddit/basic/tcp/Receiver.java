package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.net.Socket;

//이 클래스는 소켓을 통해서 메세지를 받아서 화면에 출력한다.
public class Receiver extends Thread{
	
	private Socket socket;
	private DataInputStream dis;
	// 생성자
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			// 수신용 스트림 객체
			dis = new DataInputStream(socket.getInputStream());
		
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		while(dis!=null){
			try {
				System.out.println( dis.readUTF() );
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	}
	
}
