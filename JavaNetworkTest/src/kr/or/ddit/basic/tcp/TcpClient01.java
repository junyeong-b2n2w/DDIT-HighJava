package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class TcpClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException{
		// 현재 자신의 컴퓨터를 나타내는 방법들
		// 1. 원래의 ip주소
		// 2. 로컬호스트  / localhost
		// 3. 루프백주소  / 127.0.0.1 
		// 4. 원래의 컴퓨터 이름 : DESKTOP PC-25
		
		String serverInfo = "localhost";
		
		System.out.println(serverInfo + "서버에 연결중입니다...");
		
		//서버의 ip주소와 포트번호를 지정하여 소켓 객체 생성
		// Socket객체가 생성이 완료되면 해당 서버에 요청신호를 보낸다.
		Socket socket = new Socket(serverInfo, 7777);
		
		//이부분은 서버와 연결이 완료되야만 실행되는 곳.
		System.out.println("서버에 연결되었습니다.");
		System.out.println();
		
		System.out.println("연결된 서버 정보 ... (상대편 컴퓨터 정보)");
		System.out.println("IP 정보 : " + socket.getInetAddress().getHostAddress());
		System.out.println("port 정보 : " + socket.getPort());
		System.out.println();
		
		System.out.println("접속한 클라이언트 정보(내 정보)");
		System.out.println("IP 주소 : " + socket.getLocalAddress());
		System.out.println("port 정보 : " + socket.getLocalPort());
		System.out.println();
		
		// 서버에서 보낸 메세지를 받기위한 input스트림
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		System.out.println("서버에서 온 메세지 : " + dis.readUTF());
		
		dis.close();
		socket.close();
		
		
	}

}
