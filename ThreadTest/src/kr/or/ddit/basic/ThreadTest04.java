package kr.or.ddit.basic;

public class ThreadTest04 {

	public static void main(String[] args) {

		//단독 처리 쓰레드
		SumThread sm = new SumThread(1L, 2_000_000_000L);
		
		// 협력쓰레드
		SumThread[] smArr = new SumThread[]{
				new SumThread(1L, 500_000_000L),
				new SumThread(500_000_001L, 1000_000_000L),
				new SumThread(1000_000_001L, 1500_000_000L),
				new SumThread(1500_000_001L, 2000_000_000L)
		};
		
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime =  System.currentTimeMillis();
		
		System.out.println("단독처리 : " + (endTime - startTime));
		
		System.out.println("------------");
		
		
		startTime = System.currentTimeMillis();
		
		
		for(int i = 0; i < smArr.length; i++){
			smArr[i].start();
		}
		
		for(SumThread sms : smArr){
			try {
				sms.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("멀티처리 : " + (endTime - startTime));
		
		
	}

}


class SumThread extends Thread{
	
	private long start, end;
	
	public SumThread(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for (long i = start; i<= end; i++){
			sum += i;
		}
		System.out.println("합계 :" + sum);
	}
}