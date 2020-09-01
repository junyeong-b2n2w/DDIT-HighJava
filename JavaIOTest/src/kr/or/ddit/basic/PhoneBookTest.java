package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		HashMap<String, Phone> phoneBook = new HashMap<>();
		
		String name ="";
		String addr ="";
		String age ="";
		String tel ="";
		
		
		int input = 0;
		while(true){
//			System.out.println(phoneBook);
			System.out.println("=========================");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체출력");
			System.out.println("0. 프로그램 종료");
			System.out.println("=========================");
			System.out.println("입력 >");
			input = Integer.parseInt(sc.next());
			
			switch (input) {
			case 1:
				System.out.print("등록하실 이름을 입력해 주세요 > ");
				name = sc.next();
				if (phoneBook.containsKey(name)){
					System.out.println("해당 이름이 이미 전화번호부에 존재합니다");
				}else{
					System.out.print("등록하실 주소를 입력해 주세요 > ");
					addr = sc.next();
					System.out.print("등록하실 나이을 입력해 주세요 > ");
					age = sc.next();
					System.out.print("등록하실 전화번호를 입력해 주세요 > ");
					tel = sc.next();
					
					phoneBook.put(name, new Phone(name, age,addr,tel));
					System.out.println(name+ "님의 정보가 등록되었습니다.");
				}
				break;
			case 2:
				System.out.print("수정하실 이름을 입력해 주세요 > ");
				name = sc.next();
				if (phoneBook.containsKey(name)){
					System.out.print("수정하실 주소를 입력해 주세요 > ");
					addr = sc.next();
					System.out.print("수정하실 나이을 입력해 주세요 > ");
					age = sc.next();
					System.out.print("수정하실 전화번호를 입력해 주세요 > ");
					tel = sc.next();
					
					phoneBook.put(name, new Phone(name, age,addr,tel));
					System.out.print(name + "님의 정보가 수정되었습니다.");
					System.out.println();
					
				}else{
					System.out.println("해당 이름이 전화번호부에 존재하지 않습니다");
					System.out.println();
				}
				break;
			case 3:
				System.out.print("삭제하실 이름을 입력해 주세요 > ");
				name = sc.next();
				if (phoneBook.containsKey(name)){
					phoneBook.remove(name);
					System.out.println(name + "님 의 전화번호 정보가 삭제 되었습니다");
					System.out.println();
				}else{
					System.out.println("해당 이름이 전화번호부에 존재하지 않습니다");
					System.out.println();
				}
				break;
			case 4:
				System.out.print("검색하실 이름을 입력해 주세요 > ");
				name = sc.next();
				if (phoneBook.containsKey(name)){
					System.out.println("=========================");
					System.out.println("이름 : " + name);
					System.out.println("주소 : " + phoneBook.get(name).addr);
					System.out.println("나이 : " + phoneBook.get(name).age);
					System.out.println("전화번호 : " + phoneBook.get(name).tel);
					System.out.println("=========================");
					
				}else{
					System.out.println("해당 이름이 전화번호부에 존재하지 않습니다");
				}
				break;
			case 5:
				System.out.println("=========================");
				System.out.println("번호\t이름\t전화번호\t나이\t사는곳");
				Set<String> phoneSet = phoneBook.keySet();
				int count = 0;
				for(String key : phoneSet){
					count ++;
					System.out.println(count + "\t" + key +"\t" + phoneBook.get(key).toString());
				}
				
				
				System.out.println("=========================");
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
		
		
		
	}

	/*
 	문제) 이름, 주소, 나이, 전화번호를 멤버변수로 갖는 Phone클래스를 만들고
 		 Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 		 
 		 - 이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체 출력하는 기능이 있다.
 		 - 삭제와 검색 기능은 '이름'을 입력 받아 처리한다.
 		 - (Map의 구조는 key값으로 그 사람의 '이름'을 사용하고,
 		              value값으로는 'Phone클래스의 인스턴스'로 한다.)
 
 	실행예시)
 		다음 메뉴를 선택하세요.
 		1. 전화번호 등록
 		2. 전화번호 수정
 		3. 전화번호 삭제
 		4. 전화번호 검색
 		5. 전화번호 전체출력
 		0. 프로그램 종료
 		---------------
 		번호입력> 1
 		
 		새롭게 등록할 전화번호 정보를 입력하세요
 		이름 >> 홍길동
 		전화번호 >> 010-1111-1111
 		나이 >> 30
 		주소 >> 대전시 중구 대흥동
 		
 		'홍길동' 전화번호 등록 완료!!
 		
 		
 		- 추가조건 _
 		6.
 		1) 전화번호 저장을 추가하고 구현한다
 		저장파일명ㅇ느 phoneData.dat
 		2) 프로그램이 처음시작될때 저장된 파일이 있으면 그 데이터를 읽어와서 map에 셋팅한다.
 		3) 프로그램을 종료할때 Map의 데이터가 변경되었거나 추가 또는 삭제 되면 새로 저장한 후 종료	
 */	
	
}

class Phone{
	String name;
	String age;
	String addr;
	String tel;
	
	public Phone(String name, String age, String addr, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return tel + "\t" + age + "\t" + addr;
	}
	
	
	
}