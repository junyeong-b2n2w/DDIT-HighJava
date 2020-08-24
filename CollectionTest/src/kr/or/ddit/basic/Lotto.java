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
			System.out.println("        Lotto 프로그램");
			
			System.out.println("-------------------------------");
			System.out.println("1. 로또 구입");
			System.out.println("2. 종료");
			System.out.println("===============================");
			System.out.println("입력 >");
			input = Integer.parseInt(sc.next());
			
			switch (input) {
			case 1:
				ArrayList<HashSet<Integer>> lotto = new ArrayList<>();
				
				System.out.println("로또는 1게임에 1000 원 입니다.");
				System.out.println("구매 금액을 입력해 주세요 >");
				money = Integer.parseInt(sc.next());
				if(money > 101000){
					System.out.println("구매금액이 너무 큽니다");
				}else if(money < 1000){
					System.out.println("금액이 부족합니다");
				}
					
				for(int i= 0 ; i < money/1000; i++){
					lotto.add(lotto());
				}
				for(HashSet<Integer> lo : lotto){
					System.out.println(lo);
				}
				
				System.out.println("거스름돈 : " + money%1000);
				
				System.out.println("===============================");
				break;
			case 2:
				System.out.println("종료합니다.");
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

