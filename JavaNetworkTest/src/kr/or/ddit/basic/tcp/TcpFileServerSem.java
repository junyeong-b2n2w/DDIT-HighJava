package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServerSem {
	private ServerSocket server;
	private Socket socket;
	
	private DataInputStream dis; // 문자수신용
	private BufferedInputStream bis; // 데이터 수신용
	private BufferedOutputStream bos;  // 파일 저장용
	
	
	
	
	private void serverStart(){
		File saveDir = new File("d:/d_other/download"); // 저장할 폴더이름
		if(!saveDir.exists()){
			saveDir.mkdirs();
		}
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			
			socket = server.accept(); // 클라이언트의 접속 요청을 기다린다.
			
			System.out.println("파일 다운로드 시작...");
			
			//클라이언트에서 처음으로 보내는 데이터 받기(파일명)
			dis = new DataInputStream(socket.getInputStream());
			String fileName = dis.readUTF();
			
			// 저장할 파일 위치와 파일이름을 지정하며 File객체 생성
			File saveFile = new File(saveDir, fileName);
			
			bis = new BufferedInputStream(socket.getInputStream());
			
			// 파일 저장용 스트림 객체 생성
			bos = new BufferedOutputStream(new FileOutputStream(saveFile));
			
			byte[] temp = new byte[1024];
			int len = 0;
			
			//소켓으로 수신된 데이터를 읽어오기
			while( (len = bis.read(temp)) > 0){
				bos.write(temp, 0, len);
			}
			bos.flush();
			
			System.out.println("파일 다운로드 완료...");
			
			
		} catch (Exception e) {
			System.out.println("파일 다운로드 실패");
		} finally{
			// 사용한 스트림 닫기
			if(dis != null) try{dis.close();} catch(IOException e){ }
			if(bis != null) try{bis.close();} catch(IOException e){ }
			if(bos != null) try{bos.close();} catch(IOException e){ }
			if(socket != null) try{socket.close();} catch(IOException e){ }
		}
		
	}
	
	public static void main(String[] args) {
		new TcpFileServerSem().serverStart();
	}

}
