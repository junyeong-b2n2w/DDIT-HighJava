package kr.or.ddit.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		//읽어온 정보를 저장할 properties 객체 생성
		Properties prop = new Properties();
		
		File file = new File("res/dbinfo.properties");
		
		FileInputStream fin = null;
		
		try {
			//파일 내용을 읽어올 스트림 객체 생성
			fin = new FileInputStream(file);
		
			// 입력용 스트림을 이용하여 파일내용을 읽어와 Properties 객체에 저장하기
			prop.load(fin);  // 파일내용을 읽어와 key값과 value값을 분류한 후 Propersies 객체에 추가한다.
			
			System.out.println(prop.getProperty("driver"));
			
			fin.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
