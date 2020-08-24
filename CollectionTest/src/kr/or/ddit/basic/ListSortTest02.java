package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1, "준영1", "010-1111-1111"));
		memList.add(new Member(5, "준영5", "010-2222-2222"));
		memList.add(new Member(4, "준영4", "010-3333-3333"));
		memList.add(new Member(1, "준영1", "010-4444-4444"));
		memList.add(new Member(7, "준영7", "010-5555-5555"));
		memList.add(new Member(2, "준영2", "010-6666-6666"));
		memList.add(new Member(10, "준영10", "010-7777-7777"));
		memList.add(new Member(6, "준영6", "010-8888-8888"));
		memList.add(new Member(9, "준영9", "010-9999-9999"));
		memList.add(new Member(8, "준영8", "010-1010-1010"));
		
		System.out.println("정렬전..");
		for (Member mem : memList){
			System.out.println(mem);
		}
		
		System.out.println("--------------------------------");
		
		
		Collections.sort(memList, new Desc2());
		System.out.println("정렬후..");
		for (Member mem : memList){
			System.out.println(mem);
		}
		
	}

}

class Member /*implements Comparable<Member>*/{
	private int num;
	private String name;
	private String tel;
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
//	@Override
//	public int compareTo(Member mem) {
//		
//		
//		return this.name.compareTo(mem.getName());
//	}
//	@Override
//	public int compareTo(Member mem) {
//		
//		
//		return  mem.getNum() - this.num ;
//	}
	
}

class Desc2 implements Comparator<Member>{
	@Override
	public int compare(Member o1, Member o2) {
		// TODO Auto-generated method stub
		if(o1.getTel().compareTo(o2.getTel())<0){
			return 1;
		}else if(o1.getTel().compareTo(o2.getTel())==0){
			return 0;
		}else{
			return -1;
		}
	}
}