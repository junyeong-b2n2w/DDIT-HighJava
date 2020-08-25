package kr.or.ddit.basic;



class NonGenericClass{
	private Object val;
	
	public void setVal(Object val){
		this.val = val;
	}
	public Object getVal(){
		return val;
	}
}

class MyGeneric<T>{
	private T val;
	
	public void setVal(T val){
		this.val = val; 
	}
	public T getVal(){
		return val;
	}
}


public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		NonGenericClass ngc1 = new NonGenericClass();
		ngc1.setVal("가나다라");
		
		NonGenericClass ngc2 = new NonGenericClass();
		ngc2.setVal(123);
		
		String rtnStr = (String)ngc1.getVal();
		System.out.println("문자열 반환값 : " + rtnStr);
		int rtnInt = (int)ngc2.getVal();
		System.out.println("정수형 반환값 : " + rtnInt);
		
		MyGeneric<String> mgc1 = new MyGeneric<>();
		mgc1.setVal("가갸거겨");
		
		MyGeneric<Integer> mgc2 = new MyGeneric<>();
		mgc2.setVal(123);
		
		System.out.println(mgc1.getVal());
		System.out.println(mgc2.getVal());
		
	}

}
