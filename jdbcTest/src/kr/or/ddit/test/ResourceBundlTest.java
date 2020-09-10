package kr.or.ddit.test;

import java.util.ResourceBundle;

public class ResourceBundlTest {

	public static void main(String[] args) {
			// 읽어올 파일을 지정할때 파일명만 지정하고 확장자는 지정치 않음
			ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
			System.out.println(bundle.getString("driver"));
	}

}
