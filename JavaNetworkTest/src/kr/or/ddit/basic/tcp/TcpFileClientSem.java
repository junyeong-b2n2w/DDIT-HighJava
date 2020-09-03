package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class TcpFileClientSem {

	private Socket socket;
	private BufferedOutputStream bos;
	private DataOutputStream dos;
	
	private BufferedInputStream bis;
	
	
	
	public static void main(String[] args) {
		new TcpFileClientSem().clientStart();
	}

	private void clientStart() {
//		File file = new File("d:/d_other/호랑이.jpg");
//		String fileName = file.getName();
//		
//		if(!file.exists()){
//			System.out.println(fileName + " 파일이 없습닏.");
//			return;
//		}
//		
		String fileName = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("d:/d_other"));
		File file = null;
		int result = fileChooser.showOpenDialog(new JPanel());
		if(result == fileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
			fileName = file.getName();
		}else{
			System.out.println("파일 전송을 취소합니다.");
			return;
		}
		
		
		try {
			
			socket = new Socket("192.168.43.35", 7777);
			
			System.out.println("파일 전송 시작 ...");
			//처음 접속되면 파일이름을 전송한다
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(fileName);
			
			// 파일 읽기용 스트림 객체 생성
			bis = new BufferedInputStream(new FileInputStream(file));
			
			// 서버로 전송할 스트림 객체 생성
			bos = new BufferedOutputStream(socket.getOutputStream());
			
			byte[] temp = new byte[1024];
			int len = 0;
			
			// 파일 내용을 읽어와 소켓을 통해 전송한다.
			while((len = bis.read(temp)) > 0){
				bos.write(temp, 0, len);
			}
			bos.flush(); // 마지막 버퍼 비우기 
			
			System.out.println("파일 전송 완료");
			
			
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패");
			
		} finally{
			// 사용한 스트림 닫기
			if(dos != null) try{dos.close();} catch(IOException e){ }
			if(bis != null) try{bis.close();} catch(IOException e){ }
			if(bos != null) try{bos.close();} catch(IOException e){ }
			if(socket != null) try{socket.close();} catch(IOException e){ }
		}
		
		
	}

}
