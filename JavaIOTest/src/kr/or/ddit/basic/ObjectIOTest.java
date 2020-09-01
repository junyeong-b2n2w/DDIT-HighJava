package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {
	public static void main(String[] args) {
		// 객체를 파일에 저장하는 예제
		
		Member mem1 = new Member("ㅎㄱㄷ", 25, "ㄷㅈ");
		Member mem2 = new Member("ㄱㄷㄷ", 25, "ㄷㅈ");
		Member mem3 = new Member("ㄴㄴㅇ", 25, "ㄷㅈ");
		Member mem4 = new Member("12ㄱㄷ", 25, "ㄷㅈ");
		Member mem5 = new Member("ㅇㄹㅋㄷ", 25, "ㄷㅈ");
		
		try {
			//객체를 파일에 저장 하기 
			
			//파일 저장용 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/memObj.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			// 쓰기 작업 수행..
			System.out.println("객체 저장 하기 시작");
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);
			oout.writeObject(mem5);
			
			System.out.println("객체 저장 끝");
			
			oout.close();
		
			
			
		} catch (Exception e) {
		}
		
		// -----------------------------
		ObjectInputStream oin=null;
		try {
			// 저장된 객체를 읽어와 그 내용을 화면 안에 출력하기
			
			//입력용 스트림 객체 생성
			oin = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("d:/d_other/memObj.bin")));
			
			Object obj;
			
			//readObject()메서드의 반환 타입은 Object형이다.
			//readObject()메서드가 데이터를 끝까지 다 읽어오면 EOFException이 발생한다.
			
			while((obj= oin.readObject()) != null){
				// 읽어온 데이터를 원래 객체형으로 형변환 후에 사용한다.
				Member mem = (Member)obj;
				
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println();
			}
			
			
			
			
		}catch(EOFException e){
			System.out.println("파일 끝");
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				oin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
// 데이터 저장용 클래스 작성(vo와 같은 역할 하는 클래스)

class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1096438140999733430L;
	private String name;
	private transient int age;
	private transient String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}