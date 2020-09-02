package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

				//tcp 소켓 통신을 위해서 ServerSocket 객체를 생성한다.
				ServerSocket server = new ServerSocket(7777);
				
				//accept()메서드
				//	=> 클라이언트에서 연결요청이 올 때까지 계속 기다린다.
				//  => 클라이언트에서 연결 요청이 오면 Socket 객체를 생성해서 클라이언트의 Socket과 연결한다.
				Socket socket = server.accept();
				
				//accept()메서드 이후의 코드들은 클라이언트와 연결이 완료되어야만 실행된다.
				
				System.out.println("클라이언트와 연결되었습니다.");
				System.out.println();
				
				System.out.println("접속한 클라이언트의 정보...");
				System.out.println("IP 정보 : " + socket.getInetAddress().getHostAddress());
				System.out.println("port 정보 : " + socket.getPort());
				System.out.println();
				
				System.out.println("연결된 서버의 정보 ....(내 컴퓨터 정보)");
				System.out.println("IP 주소 : " + socket.getLocalAddress());
				System.out.println("port 정보 : " + socket.getLocalPort());
				System.out.println();
				
				// 클라이언트에게 메세지 보내기
				// OutputStream을 구성해서전송한다. ==> Socket의 getOutputStream()을 이용
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//
				dos.writeUTF("환영합니다.");
				System.out.println("메세지를 보냈습닏,,,");
				
				//소켓과 스트림 닫기
				dos.close();
				socket.close();
				server.close();
				
				

	}

}
