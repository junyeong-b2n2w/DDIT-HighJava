package kr.or.ddit.baisc;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import kr.or.ddit.util.AES256Util;
import kr.or.ddit.util.CryptoUtil;

public class CryptoTest {

	public static void main(String[] args) throws Exception {

//		String testData = "Hello, world";
		String testData = "암호홯하자ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ";
		
		try {
			System.out.println("    md5 : "+ CryptoUtil.md5(testData));
			System.out.println("sha-256 : "+ CryptoUtil.sha256(testData));
			System.out.println("sha-512 : "+ CryptoUtil.sha512(testData));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//-----------------------------
		
		
			AES256Util aes256 = new AES256Util();
			System.out.println("AES256 암호화 전 : " + testData);
		
			// 암호화 작업
			String str = aes256.encrypt(testData);
			System.out.println("AES256 암호화 후 : " + str);
			
			//복호화작업
			String deStr = aes256.decrypt(str);
			System.out.println("AES256 복호화 후 : " + deStr);
		
		
	}

}
