package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> name = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("�̸� > ");
			name.add(sc.nextLine());
		}
		
		for (int i = 0; i < name.size(); i++) {
			
			if(name.get(i).substring(0,1).equals("��")){
				System.out.println(name.get(i));
				}
		}
		
		
	}

}
