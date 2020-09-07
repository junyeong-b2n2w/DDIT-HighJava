package kr.or.ddit.basic.server;

import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.basic.inf.RemoteInterface;
import kr.or.ddit.basic.vo.FileInfoVO;
import kr.or.ddit.basic.vo.TestVO;


// RMI 기술을 제공하는 클래스
//		=> RMI용 인터페이스를 구현하고 , UnicastRemoteObject를 상속해서 작성한다.

public class RemoteServer extends UnicastRemoteObject implements RemoteInterface{

	//모든 생성자도 반드시 RemoteExceptin을 throws 하도록 작성한다.
	
	public RemoteServer() throws RemoteException{}
	
	public static void main(String[] args) {
		try {
			//RMI 서비스를 제공하는 과정
			
			// 1. RMI 인터페이스를 구현한 객체의 인스턴스를 만든다.
			// (이때의 변수는 RMI 용 인터페이스 자료형으로 선언한다)
			
			RemoteInterface server = new RemoteServer();
			
			// 2. 구현한 객체를 클라이언트에서 찾을수 있도록 관리하는 Registry 객체를 생성한다.
			// (작성할 때는 통신에서 사용할 포트번호를 지정해서 생성한다)
			// (RMI의 기본포트 번호는 1099이다)
			
			Registry reg = LocateRegistry.createRegistry(9999);
			
			// 3. Registy 에 서버에서 제공할 객체를 등록한다.\
			// 즉 RMI 용 인터페이스를 구현한 객체의 인스턴스를 등록한다
			// 등록방법 _) Registry객체변수.rebind("객체의Alias", RMI 용 객체의 인스턴스);
			//   	=> 등록할때 지정한 '객체의 Alias'는 클라이언트에서 이 객체를 구할때 사용하는 이름이 된다.)
			
			reg.rebind("rmiServer", server);
			
			System.out.println("서버가 준비되었습니다.....");
			
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int doRemotePrint(String str) throws RemoteException {
		System.out.println("doRemotePrint() 메서드 시작...");
		
		System.out.println("클라이언트에서 보낸 내용 : " + str);
		
		System.out.println("doRemotePrint() 메서드 끝...");
		System.out.println();
		
		return 200;  // 이반환값은 서버에서 클라이언트 쪽으로 보내는 값
	}

	@Override
	public void doPrintList(List<String> list) throws RemoteException {
		System.out.println("doPrintList() 메서드 시작");
		for(int i =0; i<list.size(); i++){
			System.out.println(i + "번째 자료 : "+list.get(i));
		}
		System.out.println("doPrintList() 메서드 끝");
		System.out.println();
		
	}

	@Override
	public void doPrintVo(TestVO vo) throws RemoteException {
		System.out.println("doPrintVo() 메서드 시작 ...");
		System.out.println("번호 : " + vo.getNumber());
		System.out.println("이름 : " + vo.getName());
		System.out.println("doPrintVo() 메서드 끝 ...");
		System.out.println();
		
	}
	
	// 클라이언트가 보내올 파일 정보를 이용하여 서버쪽에 해당 파일을 저장하는 메소드
	@Override
	public void setFile(FileInfoVO fileVo) throws RemoteException {
		String dir = "d:/d_other/rmi/"; 	//파일을 저장할 폴더
		System.out.println("파일 저장 시작");
		
		//파일 저장용 스트림 객체변수 선언
		FileOutputStream fout = null;
		try {
			// 클라이언트가 보내온 파일명을 이용하여 저장할 파일 스트림 객체변수 생성
			fout = new FileOutputStream(dir+ fileVo.getFileName());
			
			fout.write(fileVo.getFileData());
			
			fout.flush();
			fout.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("파일 저장 끝");
	}
	
}
