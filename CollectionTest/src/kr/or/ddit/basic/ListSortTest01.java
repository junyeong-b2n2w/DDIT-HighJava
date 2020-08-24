package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("������");
		list.add("ȫ�浿");
		list.add("���");
		list.add("����");
		list.add("ȫ��");
		list.add("��������");
		
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

