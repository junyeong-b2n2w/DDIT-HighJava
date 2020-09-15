package kr.or.ddit.singleton;

public class SingletonTest {

	public static void main(String[] args) {

		//MySingleton test1 = new MySingleton(); // 외부에서 new 명령으로 객체 생성불가
		
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
	}

}
