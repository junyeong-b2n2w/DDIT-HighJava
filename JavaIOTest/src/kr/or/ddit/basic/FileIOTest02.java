package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		// 파일에 데이터를 출력하는 예제
		try {
			// 파일 출력용 스트림 객체 생성
			File  f = new File("d:/d_other/out.txt");
			FileOutputStream fout = new FileOutputStream(f);  // 파일이 없다면 새로만들고 있다면 덮어쓴다.
			
			
			for (char ch = 'A' ; ch <='Z'; ch++){
				fout.write(ch);  // ch변수의 데이터를 파일로 출력한다
			}
			
			System.out.println("작업완료..");
			
			fout.close();  // 스트림 닫기
			
			//-----------------
			
			// 저장된 파일 내용르 읽어와 출력하기
			
			FileInputStream fin = new FileInputStream(f);
			int c;
			
			System.out.println( f.getName() + " 파일에서 읽어온 내용 : ");
			
			while( (c=fin.read()) != -1 ){
				System.out.print((char)c); 
			}
			
			fin.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
