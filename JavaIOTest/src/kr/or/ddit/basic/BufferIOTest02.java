package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferIOTest02 {

	public static void main(String[] args) {
		// 문자 기반의 BufferedStream 사용 연습
		
		try {
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/FileTest01.java");
			
			BufferedReader br = new BufferedReader(fr); // 버퍼의 기본크기 8192 바이트 
			
			String temp = "";
			
			//readLine()메서드 ==> 한줄씩 데이터를 읽어오는 메서드 데이터가 없으면 null을 반환
			for (int i=1; (temp = br.readLine()) != null; i++){
				System.out.printf("%d : %s\n", i , temp);
			}
			
			br.close();
			
		} catch (Exception e) {
		
		}
		
		
	}

}
