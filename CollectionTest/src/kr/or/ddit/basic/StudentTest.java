package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {

	public static void setRanking(List<Student> stdList){
		
		for(Student std1 : stdList){
			std1.setRank(1);
			for(Student std2 : stdList){
				if(std1.getSum() < std2.getSum()){
					std1.setRank(std1.getRank()+1);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<Student> students = new ArrayList<>();
		
		
		
		students.add(new Student(1,"1锅积", 10,10,10) );
		students.add(new Student(2, "2锅积", 20,20,20));
		students.add(new Student(3, "3锅积", 30,30,30));
		students.add(new Student(5, "5锅积", 40,40,40));
		students.add(new Student(4, "4锅积", 40,40,40));
		students.add(new Student(6, "6锅积", 60,60,60));
		setRanking(students);
		
		for(Student st : students){
			System.out.println(st);
			}
		
System.out.println("----");
		
		Collections.sort(students);
		for(Student st : students){
		System.out.println(st);
		}
		
		System.out.println("----");
		
		Collections.sort(students, new SortBySum());
		for(Student st : students){
			System.out.println(st);			}
	}
}

class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	

	public Student(int num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.setSum(kor+eng+math);
		this.rank = 1;
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
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public int compareTo(Student std) {
		
		return new Integer(this.num).compareTo(std.getNum()) ;
	}

	
	


@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor
				+ ", eng=" + eng + ", math=" + math + ", sum=" + getSum()
				+ ", rank=" + rank + "]";
	}
public int getSum() {
	return sum;
}
public void setSum(int sum) {
	this.sum = sum;
}


}




class SortBySum implements Comparator<Student>{
	
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getSum() == o2.getSum()){
			return o1.getName().compareTo(o2.getName());
		}
		return new Integer(o1.getSum()).compareTo(o2.getSum()) * -1 ;
	}
	
}