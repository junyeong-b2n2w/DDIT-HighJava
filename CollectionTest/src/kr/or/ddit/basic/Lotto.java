package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input= 0;
		int money = 0;
		while(true){
		
			System.out.println("===============================");
			System.out.println("        Lotto ���α׷�");
			
			System.out.println("-------------------------------");
			System.out.println("1. �ζ� ����");
			System.out.println("2. ����");
			System.out.println("===============================");
			System.out.println("�Է� >");
			input = Integer.parseInt(sc.next());
			
			switch (input) {
			case 1:
				ArrayList<HashSet<Integer>> lotto = new ArrayList<>();
				
				System.out.println("�ζǴ� 1���ӿ� 1000 �� �Դϴ�.");
				System.out.println("���� �ݾ��� �Է��� �ּ��� >");
				money = Integer.parseInt(sc.next());
				if(money > 101000){
					System.out.println("���űݾ��� �ʹ� Ů�ϴ�");
				}else if(money < 1000){
					System.out.println("�ݾ��� �����մϴ�");
				}
					
				for(int i= 0 ; i < money/1000; i++){
					lotto.add(lotto());
				}
				for(HashSet<Integer> lo : lotto){
					System.out.println(lo);
				}
				
				System.out.println("�Ž����� : " + money%1000);
				
				System.out.println("===============================");
				break;
			case 2:
				System.out.println("�����մϴ�.");
				System.exit(0);
				break;

	
			}
			
		
			
		
		}
		
	}

	private static HashSet<Integer> lotto() {
		
		HashSet<Integer> Lotto = new HashSet<>();
		while (Lotto.size()<6){
		Lotto.add((int) (Math.random() * 45) + 1);
		}
			
		
		return Lotto;
	}

	
	
}

