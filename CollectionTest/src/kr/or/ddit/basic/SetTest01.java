package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HashSet hs1 = new HashSet<>();
		
		hs1.add("bb");
		hs1.add("aa");
		hs1.add(2);
		hs1.add("cc");
		hs1.add("dd");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("set의 개수는 : "+hs1.size());
		System.out.println("set 데이터 : " + hs1);
		
		System.out.println(hs1.add(5));
		
		
		HashSet<Integer> intset = new HashSet<>();
		
		intset.add(10);
		intset.add(7);
		intset.add(9);
		intset.add(3);
		intset.add(5);
		
		Iterator<Integer> it = intset.iterator();
		
		int sum = 0;
		
		while(it.hasNext()){
			int num = it.next();
			sum += num;
			System.out.println(num);
		}
		
		System.out.println(sum);
		
		
		
		
		
	}

}
