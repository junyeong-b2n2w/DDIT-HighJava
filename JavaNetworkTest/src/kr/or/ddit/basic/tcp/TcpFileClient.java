package kr.or.ddit.basic.tcp;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpFileClient {

	public static void main(String[] args) {
		
		try {
		
		String serverInfo = "localhost";
		
		System.out.println(serverInfo + "서버에 연결중입니다...");
		
		//서버의 ip주소와 포트번호를 지정하여 소켓 객체 생성
		// Socket객체가 생성이 완료되면 해당 서버에 요청신호를 보낸다.
		Socket socket = new Socket("192.168.43.35", 7777);
		

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		BufferedOutputStream bos = new BufferedOutputStream(dos);
		
		File file = new File("D:/D_Other/호랑이.jpg");
		
		FileInputStream fin = new FileInputStream(file);
		
		
		
		int c;
		
		
		while( (c=fin.read()) != -1 ){
			bos.write(c);
		}
		
//		bos.flush();
	
		
		
		bos.close();
		fin.close();
		socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
