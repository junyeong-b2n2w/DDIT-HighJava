package kr.or.ddit.singleton;

public class MySingleton {

	// 1번
	private static MySingleton single;
	
	// 2번
	
	private MySingleton() {
		System.out.println("생성자입니다.");
	}
	
	// 3번
	public static MySingleton getInstance(){
		if(single == null){
			single = new MySingleton();
		}
			return single;
		
		
		
	// 기타 이클래스가 처리할 내용 기술	
	}
	
	public void displayTest() {
		System.out.println("메서드 호출~");
	}
	
}
