package kr.or.ddit.basic;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		URL url = new URL("https://www.ddit.or.kr/index.html?ttt=123");
		
		System.out.println("protocol : " + url.getProtocol());
		System.out.println("Host : " + url.getHost());
		System.out.println("Port : " + url.getPort());
		System.out.println("File : " + url.getFile());
		System.out.println("Path : " + url.getPath());
		System.out.println("Query : " + url.getQuery());
		
		
		
	}

}
