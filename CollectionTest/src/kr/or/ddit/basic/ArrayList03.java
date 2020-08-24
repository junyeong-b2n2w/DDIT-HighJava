package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList03 {

	public static void main(String[] args) {
		
		ArrayList<String> name = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("º°¸í > ");
			name.add(sc.nextLine());
		}
		
		int max = 0, index = 0;
		
		for (int i = 0; i<name.size();i++){
			if(max < name.get(i).length()){
				max = name.get(i).length();
				index = i;
			}
		}
		
		System.out.println(name.get(index));
		
		
	}
	
}
