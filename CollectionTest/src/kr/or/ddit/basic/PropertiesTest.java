package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Properties p = new Properties();
		
		p.setProperty("name", "jun");
		p.setProperty("age", "27");
		p.setProperty("addr", "jeonju");
		
		System.out.println(p.getProperty("name") + " / " + p.getProperty("age") + " / " + p.getProperty("addr"));
		
		
	}

}
