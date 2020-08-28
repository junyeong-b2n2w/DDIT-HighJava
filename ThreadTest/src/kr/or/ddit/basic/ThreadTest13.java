package kr.or.ddit.basic;

import java.awt.DisplayMode;

public class ThreadTest13 {

	public static void main(String[] args) {
//		10마리의 말들이 경주하는 경마 프로그램 작성하기
		
//		말은 Horse라는 이름의 클래스로 구성한다.(이 각각의 말들은 하나의 쓰레드가 된다.)
//		이 클래스는 말 이름(String), 등수(int), 말의 현재 위치(int)를 멤버변수로 갖는다
//		그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다. (Comparable인터페이스 구하기)
		
//		경기 구간은 1 ~ 50구간으로 되어있다.
		
//		경기중 중간중간에 각 말들의 위치를 나타내시오
		
//		경기가 끝나면 등수 순으로 출력
		Horse[] horse = new Horse[]{
				new Horse("진성호"),
				new Horse("이루빈"),
				new Horse("문제현")
				
			};
		for (Horse hs : horse) {
			hs.start();
		}
		
		for (Horse hs : horse) {
			try {
				hs.join();
			} catch (Exception e) {
			}
		}
	}
}

class Horse extends Thread implements Comparable<Horse>{
	String name;
	int rank;
	int location;
	
	public Horse(String name) {
		this.name = name;
		this.rank = rank;
	}
	
	public String getName1() {
		return name;
	}
	
	public void setName1(String name) {
		this.name = name;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getLocation() {
		return location;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	
	@Override
	public void run(){
		for (int i = 0; i < 50; i++) {
			
			for (int j = 1; j <= 50; j++) {
				if(j == location){
					System.out.print(">");
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
			
			try {
				Thread.sleep((int)(Math.random() * 1000) + 400);
				
			} catch (Exception e) {
			}
		}
		
	}

	@Override
	public int compareTo(Horse o) {
		
		return 0;
	}
}
