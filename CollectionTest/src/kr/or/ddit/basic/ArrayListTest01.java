package kr.or.ddit.basic;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

public class ArrayListTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list1 = new ArrayList<>();
		
		list1.add("hihello");
		list1.add(new Integer(12332));
		list1.add(123);
		list1.add('a');
		list1.add(true);
		list1.add(3.14f);
		
		System.out.println("size : " + list1.size());
		System.out.println("현재 리스트 => " + list1);
		
		list1.add(0,"ccc");
		System.out.println("현재 리스트 => " + list1);
		
		String temp = String.valueOf(list1.set(0, "zzz"));
		System.out.println("현재 리스트 => " + list1);
		System.out.println("원래 데이터 => " + temp);
		
		temp = (String)list1.remove(0);
		System.out.println("현재 리스트 => " + list1);
		System.out.println("삭제된 데이터 => " + temp);
		
		
		boolean deletedData = list1.remove("hihello");
		System.out.println("현재 리스트 => " + list1);
		System.out.println(deletedData);
		
		list1.remove((Integer)123);
		list1.remove((Character)'a');
		System.out.println("현재 리스트 => " + list1);
		
		
		list1.clear();
		System.out.println(list1);
		
		
		list1.add("AAA");
		list1.add("BBB");
		list1.add("CCC");
		list1.add("DDD");
		
		String data = (String)list1.get(1);
		System.out.println("현재 리스트 => " + list1);
		System.out.println(data);
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		list2.add("FFF");
	

		
		ArrayList<String> list3 = new ArrayList<>();
		
		list3.add("BBB");
		list3.add("DDD");
		list3.add("EEE");
		
		
		
		System.out.println(list2);
		
		System.out.println("DDD값 :" + list2.contains("DDD"));
		
		System.out.println("DDD값 :" + list2.indexOf("DDD"));
		System.out.println("KKK값 :" + list2.indexOf("KKK"));
		
		
		Object[] objArr= list2.toArray();
		System.out.println("배열의 갯수 : " + objArr.length );
		
		for (int i = 0; i < objArr.length; i++) {
			System.out.println(i + "번째 자료 : "+ objArr[i]);
			
		}
		
		String[] strArr = list2.toArray(new String[0]);
		
		for(String str : strArr){
			System.out.println("자료 : "+ str);
		}
		
		
	}

}
