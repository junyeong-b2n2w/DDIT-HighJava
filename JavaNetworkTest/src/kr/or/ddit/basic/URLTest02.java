package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {

	public static void main(String[] args) throws IOException {
		//URLConnection  ->

		
		URL url = new URL("https://www.naver.com/index.html");
		
		URLConnection urlCon = url.openConnection();
		
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		System.out.println("header 정보 출력");
		for(String headerKey : headerMap.keySet()){
			System.out.println(headerKey + " : " + headerMap.get(headerKey));
		}
		System.out.println("----------------");
		/*
		//방법1 ==> URLConnection객체를  이용하기
		// 파일의 내용을 가져오기 위한 스틺 객체 생성
		InputStream is = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		//자료를 읽어와서 출력하기
		while(true){
			String str = br.readLine();
			if(str==null){
				break;
			}
			System.out.println(str);
		}
		
		br.close();
		
		*/
		
		//방법 2 URL객체의 openStream()을 이용
		
		InputStream is2 = url.openStream();
		InputStreamReader isr2 = new InputStreamReader(is2, "utf-8");
		BufferedReader br2 = new BufferedReader(isr2);
		
		//자료를 읽어와서 출력하기
				while(true){
					String str = br2.readLine();
					if(str==null){
						break;
					}
					System.out.println(str);
				}
				
				br2.close();
		
	}

}
