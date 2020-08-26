package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {

		Thread th = new Thread(new MyRunner());
		
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		try{
			th.join();
		}catch(InterruptedException e){
			
		}
		
		long endTime =  System.currentTimeMillis();
		
		System.out.println((Long)endTime - startTime);
		
	}

}

class MyRunner implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long sum = 0L;
		for (long i = 1L; i<=1_000_000_000L;i++){
			sum+=i;
		}
		System.out.println("합계 = "+ sum);
	}
	
}