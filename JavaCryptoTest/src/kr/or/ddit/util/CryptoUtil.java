package kr.or.ddit.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//단방향 암호화 하기
public class CryptoUtil {
	//byte배열을 Hex문자열로 변환하는 메서드
	public static String btyeToHexString(byte[] data){
		StringBuilder sb = new StringBuilder();
		for(byte b: data){
			//16진수 2자리의 문자열로 만든다
			sb.append(Integer.toHexString((b & 0xFF) + 0x100).substring(1) );
		}
	
		return sb.toString();
	}
	
	
	public static String md5(String msg) throws NoSuchAlgorithmException{

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(msg.getBytes());
		return CryptoUtil.btyeToHexString(md.digest());
	}
	public static String sha256(String msg) throws NoSuchAlgorithmException{

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		return CryptoUtil.btyeToHexString(md.digest());
	}
	
	public static String sha512(String msg) throws NoSuchAlgorithmException{

		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(msg.getBytes());
		return CryptoUtil.btyeToHexString(md.digest());
	}
	
}
