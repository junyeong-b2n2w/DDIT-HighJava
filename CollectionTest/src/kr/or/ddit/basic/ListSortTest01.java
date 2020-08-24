package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("ÀÏÁö¸Å");
		list.add("È«±æµ¿");
		list.add("±è»ñ°«");
		list.add("±è»çºÎ");
		list.add("È«·Ã");
		list.add("ÁıÁ»°¡ÀÚ");
		
		System.out.println(list);
		
		Collections.sort(list);
		
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		Collections.sort(list, new Desc());
		System.out.println(list);
		
		
	}

}

class Desc implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(o1.compareTo(o2)<0){
			return 1;
		}else if(o1.compareTo(o2)==0){
			return 0;
		}else{
			return -1;
		}
	}
}

