package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 udp 방식 : 비연결성, 데이터의 신뢰성이 없다, 데이터가 순서대로 도착한다는 보장이 없다.
 그렇지만 tcp방식보다 속도가 빠르다.
 
 - DatagramSocket 객체와 DatagramPacket 객체를 이용하여 통신한다.
 1) DatagramSocket : 데이터의 송수신과 관련된 작업을 수행한다. ( 우체부 )
 2) DatagramPacket : 주고받는 데이터와 완련된 작업을 수행한다. ( 택배 )
 			=> 수신을 위한 생성자와 송신을 위한 생성자를 따로 제공 한다.
 			
 			-TCP 방식의 경우 스트림을 이용해서 송수신하지만
 			UDP 방식은 데이터그램을 이용해서 송수신 한다.
 
 */
public class UdpServer {

	public static void main(String[] args) {
		try {
			//통신할 포트번호를 지정하여 소켓을 생성한다.
			DatagramSocket socket = new DatagramSocket(8888);
			
			// 송신용 패킷 변수와 수신용 패킷변수를 선언한다.
			
			DatagramPacket inpacket ,outpacket;
			
			System.out.println("서버실행 중 ...");
			
			while(true){
				// 데이터 저장될 byte형 배열 변수 선언
				byte[] bMsg = new byte[1024];
				
				// 수신용 패킷객체 생성
				//   -> 생성자에 데이터가 저장될 byte형 배열과 배열의 길이를 넣어서 생성한다.
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 데이터를 수신 => receive() 사용
				//    이 메서드는 데이터가 올때까지 기다립니다.
				//	  수신된 데이터의 패킷정보는 지정된 패킷변수에 저장된다.
				socket.receive(inpacket);
				
				// 수신받은 패킷에서 상대방의 주소, 포트번호 등을 알수 있다.
				
				InetAddress address = inpacket.getAddress();
				int port = inpacket.getPort();
				
				System.out.println("상대방의 ip 정보 : " + address);
				System.out.println("상대방의 port정보 : " + port);
				System.out.println();
				
				// 상대방이 보낸 메세지 출력하기
				//    - 수신용 패킷변수.getLength();  -==> 실제 읽어온 데이터의 길이를 반환
				//    - 수신용 패킷변수.getData();  ==> 실제 읽어온 데이터를 byte형 배열로 반환한다.
				// 							    ==> 실제 읽어온 데이터는 수신용 패킷을 생성할때 지정한 배열에도 저장된다.
				
				
//				String receiveMsg = new String(bMsg, 0 , inpacket.getLength());
				String receiveMsg = new String(inpacket.getData(), 0 , inpacket.getLength());
				
				System.out.println("클라이언트가 보내온 메시지 : " + receiveMsg);
				System.out.println();
				
				//----------------
				
				
				// 상대방에게 데이터 송신하기 ( 수신된 데이터를 그대로 송신하는 예제 )
				
				// 송신할 데이터를 byte형 배열로 변환한다.
				
				byte[] sendMsg = receiveMsg.getBytes();
				
				if("/end".equals(sendMsg)){   // '/end' 메세지가 오면 접속 종료
					break;
				}
				// 송신용 패킷 객체 생성
				//	 	=> 생성자에 '전송할 데이터가 저장된 byte형 배열',
				// 			전송할 자료의 길이(배열길이),'상대방주소정보','상대방포트번호',
				//			위 4가지를 생성자에 넣어서 생성한다.
				outpacket = new DatagramPacket(sendMsg, sendMsg.length, address, port);
				
				// 데이터 송신하기 => send() 메서드 이용
				socket.send(outpacket);
				
				System.out.println("송신 완료..");
				
				if("/end".equals(sendMsg)){   // '/end' 메세지가 오면 접속 종료
					break;
				}
				
				
			} // while 종료
			
			
			System.out.println("서버 종료..");
			socket.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
