package kr.or.ddit.basic;

public class EnumTest {

	public enum Color{RED, GREEN, BLUE};
	public enum Count{ONE, TWO, THREE};
	
	public enum Season{
		봄("3월부터 5월까지",10),
		여름("6월부터 8월까지",20),
		가을("9월부터 11월까지",30),
		겨울("12월부터 2월까지",40);
		
		private String span;
		private int num;
		
		private Season(String months, int num){
			span = months;
			this.num = num;
		}
		
		
		public String getSpan(){
			return span;
		}
		
		public int getNum(){
			return num;
		}
		
		
	}
	
	
	public static void main(String[] args) {
//		System.out.println("RED : " + ConstTest.RED);
//		System.out.println("THREE : " + ConstTest.THREE);
//
//		if(ConstTest.RED == ConstTest.TWO){
//			System.out.println("같다 .");
//		}else{
//			System.out.println("같지않다");
//		}
		
		
		Color mycol = Color.BLUE;
		Count mycnt = Count.valueOf("TWO");
		
		System.out.println("mycol : "+ mycol.name());
		System.out.println("mycnt : " +mycnt.name());
		
		System.out.println("mycol ordinal :" + mycol.ordinal());
		System.out.println("mycnt ordinal :" + mycnt.ordinal());
	
		if(mycol == Color.valueOf("BLUE")){
			System.out.println("같다 .");
			}else{
				System.out.println("같지않다");
			}
			
		Season ss = Season.valueOf("봄");
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println(ss.getSpan() + ss.getNum());
	
	
		for(Season time : Season.values()){
			System.out.println(time + " == " + time.name() + "==> " +time.getSpan() + ", "+ time.getNum());
			
		}
		
		for(Color col : Color.values()){
			System.out.println(col + " => " + col.ordinal());
		}
		
	}

	
	
}
