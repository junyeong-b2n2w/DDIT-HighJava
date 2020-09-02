package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {

		// naver 사이트의 아이피 정보
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		
		System.out.println("Host Name : "+ naverIp.getHostName());
		System.out.println("Host Address : "+ naverIp.getHostAddress());
		System.out.println();
		
		
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name : "+ localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address : "+ localIp.getHostAddress());
		System.out.println();
		
		
		InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
		
		for (InetAddress ip : ipArr){
			System.out.println(ip.toString());
		}
		
	}

}
