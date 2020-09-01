package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataIOTest {

	public static void main(String[] args) {

		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/test.dat");
			
			//자료형 단위로 출력할 보조 스트림
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(200); 		// 정수형으로 데이터출력
			dout.writeFloat(123.45f); 	// 실수형으로 데이터출력
			dout.writeBoolean(false);	// 논리형으로 데이터출력
			dout.writeUTF("alskdjflk");	// 문자열형식으로 데이터 출력
			
			System.out.println("출력완료,,,");
			
			dout.close();
			
			
			//----------------
			
			// 위에서 출력한 자료 읽어오기
			
			FileInputStream fin = new FileInputStream("d:/d_other/test.dat");
			
			DataInputStream din = new DataInputStream(fin);
			
			
			//DataInputStream 으로 자료를 읽어올 때는 
			// 출력할때와 같은 순서로 읽어와야한다.
			System.out.println("정수형 : "+ din.readInt());
			System.out.println("실수형 : "+ din.readFloat());
			System.out.println("논리형 : "+ din.readBoolean());
			System.out.println("문자열 : "+ din.readUTF());
			
			
			
			
			
		} catch (Exception e) {
			
		}
		
		
		
	}

}
