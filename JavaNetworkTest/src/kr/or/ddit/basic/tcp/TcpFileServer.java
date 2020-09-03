package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {

	public static void main(String[] args) {
		
		try {
			
			//tcp 소켓 통신을 위해서 ServerSocket 객체를 생성한다.
			ServerSocket server = new ServerSocket(7777);
			
			//accept()메서드
			//	=> 클라이언트에서 연결요청이 올 때까지 계속 기다린다.
			//  => 클라이언트에서 연결 요청이 오면 Socket 객체를 생성해서 클라이언트의 Socket과 연결한다.
			Socket socket = server.accept();
			
			//accept()메서드 이후의 코드들은 클라이언트와 연결이 완료되어야만 실행된다.
			
			InputStream is = socket.getInputStream();
			DataInputStream dos = new DataInputStream(is);
			BufferedInputStream bis = new BufferedInputStream(dos);
			
			File file = new File("d:/d_other/download/호랑이.jpg");
			
			FileOutputStream fos = new FileOutputStream(file);
			
			
			int c;
			
			while( (c = bis.read()) != -1){
				
				fos.write(c);
			}
			
			bis.close();
			
			fos.close();
		
			
			socket.close();
			server.close();
			
		}catch (Exception e){
			
		}
		
	}

}
