package kr.or.ddit.basic;

public class ArgsTest {
	
	public int sumArr(int[] data){
		
		int sum = 0;
		
		for (int i = 0 ; i < data.length; i++){
			sum += data[i];
		}
		
		
		
		return sum; 
	}
	
	public int subArg(int...data){
int sum = 0;
		
		for (int i = 0 ; i < data.length; i++){
			sum += data[i];
		}
		
		
		
		return sum; 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArgsTest test = new ArgsTest();
		
		
		
		
		int[] intArr = {5,3,2,1,23,4,5,231,2};
		
		int result = test.sumArr(intArr);
		
		System.out.println(result);
		
		System.out.println(test.subArg(new int[]{10,20,30,40}));
		
	
	}

}
