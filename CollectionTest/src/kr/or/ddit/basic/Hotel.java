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
		System.out.println("ȣ�ڹ��� �������ϴ�. ����ʽÿ�.");
		System.out.println("*********************************************");
		String roomType= "";
		String name = "";
		for(int i = 200 ; i<=400 ; i=i+100){
			for(int j=1 ; j<=9; j++){
				if(i==200) {
					roomType="�̱۷�";
				}else if(i==300){
					roomType="�����";
				}else if(i==400){
					roomType="����Ʈ��";
				}
				
				hotel.put(i+j, new Room(i+j, roomType));
			}
		}
		System.out.println(hotel);
		
		
		int input = 0;
		while(true){
			
			System.out.println("-----------------------------------------------------------");
			System.out.println("� ������ �Ͻðڽ��ϱ�?");
			System.out.println("1.üũ��\t2.üũ�ƿ�\t3.���ǻ���\t4.��������");
			System.out.println("-----------------------------------------------------------");
			System.out.print("���� > ");
			
			input=  Integer.parseInt(sc.nextLine());
			
			
			
			switch (input) {
			case 1:
				System.out.println("-----------------------------------------------------------");
				
				System.out.println("üũ�� �۾�");
				System.out.println("-----------------------------------------------------------");
				System.out.println("* 201~209 : �̱۷�");
				System.out.println("* 301~309 : �����");
				System.out.println("* 401~409 : ����Ʈ��");
				System.out.println("-----------------------------------------------------------");
				System.out.println("���ȣ �Է�");
				input = Integer.parseInt(sc.nextLine());
				
				if(hotel.get(input).getCusName()==null){
					System.out.println("�̸� �Է� >");
					name = sc.nextLine();
					hotel.get(input).setCusName(name);
					System.out.println("üũ���� �Ϸ� �Ǿ����ϴ�.");
				}else{
					System.out.println(input + "������ ���� �̿��Ͻ� �� �����ϴ�.");
				}
				
				break;
			case 2:
				System.out.println("-----------------------------------------------------------");
				System.out.println("üũ�ƿ� �� �� ��ȣ �Է� > ");
				input = Integer.parseInt(sc.nextLine());
				
				if(hotel.get(input).getCusName()!=null){
					hotel.get(input).setCusName(null);
					System.out.println("üũ�ƿ��� �Ϸ� �Ǿ����ϴ�.");
				}else{
					System.out.println(input + "������ üũ�� �� ����� �����ϴ�.");
				}
				
				
				break;
			case 3:
				System.out.println("-----------------------------------------------------------");
				
				System.out.println("���� ���� ����");
				System.out.println("-----------------------------------------------------------");
				System.out.println("���ȣ\t ������\t ������ �̸�");
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
				System.out.println("ȣ�ڹ� �ݾҽ��ϴ�.");
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