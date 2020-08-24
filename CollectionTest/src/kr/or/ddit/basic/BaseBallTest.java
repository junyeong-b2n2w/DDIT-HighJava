package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class BaseBallTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Integer> baseNum = new HashSet<>();
		while (baseNum.size()<3){
		baseNum.add((int) (Math.random() * 9) + 1);
		}
		
		System.out.println(baseNum.toString());
		
		Iterator<Integer> it = baseNum.iterator();
		ArrayList<Integer> baseNumList = new ArrayList<>();
		
		while(it.hasNext()){
			baseNumList.add(it.next());
		}
		
		Collections.shuffle(baseNumList);
		
		System.out.println(baseNumList);
		
		Scanner sc = new Scanner(System.in);

		
		int str = 0, ball, out;
		
		while (str != 3) {

			str = 0;
			ball = 0;
			out = 0;
			
			
			System.out.println("입력 > ");
			int get1 = Integer.parseInt(sc.next());
			int get2 = Integer.parseInt(sc.next());
			int get3 = Integer.parseInt(sc.next());
			
			//get1 검증?
			if (baseNumList.get(0) == get1) {
				str++;
			} else if (baseNumList.get(0) == get2 || baseNumList.get(0) == get3) {
				ball++;
			} else {
				out++;
			}
			// get2 검증 
			if (baseNumList.get(1) == get2) {
				str++;
			} else if (baseNumList.get(1) == get1 || baseNumList.get(1) == get3) {
				ball++;
			} else {
				out++;
			}
			// get3 검증
			if (baseNumList.get(2) == get3) {
				str++;
			} else if (baseNumList.get(2) == get2 || baseNumList.get(2) == get1) {
				ball++;
			} else {
				out++;
			}

			
			
		

		

			System.out.println(baseNumList + "str :" + str + " / " + "ball :" + ball + " / "
					+ "out :" + out);
		}
		
	}

}
