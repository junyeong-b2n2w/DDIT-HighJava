package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, Room> hotel = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("*********************************************");
		System.out.println("호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		String roomType= "";
		String name = "";
		for(int i = 200 ; i<=400 ; i=i+100){
			for(int j=1 ; j<=9; j++){
				if(i==200) {
					roomType="싱글룸";
				}else if(i==300){
					roomType="더블룸";
				}else if(i==400){
					roomType="스위트룸";
				}
				
				hotel.put(i+j, new Room(i+j, roomType));
			}
		}
		System.out.println(hotel);
		
		
		int input = 0;
		while(true){
			
			System.out.println("-----------------------------------------------------------");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인\t2.체크아웃\t3.객실상태\t4.업무종료");
			System.out.println("-----------------------------------------------------------");
			System.out.print("선택 > ");
			
			input=  Integer.parseInt(sc.nextLine());
			
			
			
			switch (input) {
			case 1:
				System.out.println("-----------------------------------------------------------");
				
				System.out.println("체크인 작업");
				System.out.println("-----------------------------------------------------------");
				System.out.println("* 201~209 : 싱글룸");
				System.out.println("* 301~309 : 더블룸");
				System.out.println("* 401~409 : 스위트룸");
				System.out.println("-----------------------------------------------------------");
				System.out.println("방번호 입력");
				input = Integer.parseInt(sc.nextLine());
				
				if(hotel.get(input).getCusName()==null){
					System.out.println("이름 입력 >");
					name = sc.nextLine();
					hotel.get(input).setCusName(name);
					System.out.println("체크인이 완료 되었습니다.");
				}else{
					System.out.println(input + "객실은 현재 이용하실 수 없습니다.");
				}
				
				break;
			case 2:
				System.out.println("-----------------------------------------------------------");
				System.out.println("체크아웃 할 방 번호 입력 > ");
				input = Integer.parseInt(sc.nextLine());
				
				if(hotel.get(input).getCusName()!=null){
					hotel.get(input).setCusName(null);
					System.out.println("체크아웃이 완료 되었습니다.");
				}else{
					System.out.println(input + "객실은 체크인 한 사람이 없습니다.");
				}
				
				
				break;
			case 3:
				System.out.println("-----------------------------------------------------------");
				
				System.out.println("현재 객실 상태");
				System.out.println("-----------------------------------------------------------");
				System.out.println("방번호\t 방종류\t 투숙객 이름");
				Set<Integer> hotelRoom = hotel.keySet();
					
				List roomList = new ArrayList<>(hotelRoom);
				Collections.sort(roomList);
				for(int i = 0; i<roomList.size(); i++){
					System.out.println(hotel.get(roomList.get(i)).toString());
				}
				System.out.println("-----------------------------------------------------------");

				
				break;
			case 4:
				System.out.println("*********************************************");
				System.out.println("호텔문 닫았습니다.");
				System.out.println("*********************************************");
				System.exit(0);
				break;

			
			}
		}
		
		
		
	}

}


class Room{
	int roomNum;
	String rommType;
	String cusName = null;
	public Room(int roomNum, String rommType) {
		super();
		this.roomNum = roomNum;
		this.rommType = rommType;
		
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getRommType() {
		return rommType;
	}
	public void setRommType(String rommType) {
		this.rommType = rommType;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	@Override
	public String toString() {
		return roomNum + "\t" + rommType
				+ "\t" + (cusName==null?"-":cusName);
	}
	
	
}