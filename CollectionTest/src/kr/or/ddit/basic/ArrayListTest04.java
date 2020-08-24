package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {
	public static void main(String[] args) {
		
		ArrayList<String> name = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("º°¸í > ");
			name.add(sc.nextLine());
		}
		
		int max = 0;
		
		ArrayList<String> index = new ArrayList<>();
		
		for (int i = 0; i<name.size();i++){
			if(max < name.get(i).length()){
				index.clear();
				max = name.get(i).length();
				index.add(name.get(i));
			}else if(max == name.get(i).length()){
				index.add(name.get(i));
			}
		}
		
		System.out.println(index);

	
		
		
	}
}
