package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {

		File f = new File("d:/d_other/호랑이.jpg");
		
		
		
		try {
			FileInputStream fin = new FileInputStream(f);
			
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/호랑이_복사본.jpg");
			
			int c;
			
			while( (c=fin.read()) != -1 ){
				fout.write(c); 
			}
			
			fin.close();
			fout.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
