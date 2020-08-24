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
			System.out.println("1. ��ȭ��ȣ ���");
			System.out.println("2. ��ȭ��ȣ ����");
			System.out.println("3. ��ȭ��ȣ ����");
			System.out.println("4. ��ȭ��ȣ �˻�");
			System.out.println("5. ��ȭ��ȣ ��ü���");
			System.out.println("0. ���α׷� ����");
			System.out.println("=========================");
			System.out.println("�Է� >");
			input = Integer.parseInt(sc.next());
			
			switch (input) {
			case 1:
				System.out.print("����Ͻ� �̸��� �Է��� �ּ��� > ");
				name = sc.next();
				if (phoneBook.containsKey(name)){
					System.out.println("�ش� �̸��� �̹� ��ȭ��ȣ�ο� �����մϴ�");
				}else{
					System.out.print("����Ͻ� �ּҸ� �Է��� �ּ��� > ");
					addr = sc.next();
					System.out.print("����Ͻ� ������ �Է��� �ּ��� > ");
					age = sc.next();
					System.out.print("����Ͻ� ��ȭ��ȣ�� �Է��� �ּ��� > ");
					tel = sc.next();
					
					phoneBook.put(name, new Phone(name, age,addr,tel));
					System.out.println(name+ "���� ������ ��ϵǾ����ϴ�.");
				}
				break;
			case 2:
				System.out.print("�����Ͻ� �̸��� �Է��� �ּ��� > ");
				name = sc.next();
				if (phoneBook.containsKey(name)){
					System.out.print("�����Ͻ� �ּҸ� �Է��� �ּ��� > ");
					addr = sc.next();
					System.out.print("�����Ͻ� ������ �Է��� �ּ��� > ");
					age = sc.next();
					System.out.print("�����Ͻ� ��ȭ��ȣ�� �Է��� �ּ��� > ");
					tel = sc.next();
					
					phoneBook.put(name, new Phone(name, age,addr,tel));
					System.out.print(name + "���� ������ �����Ǿ����ϴ�.");
					System.out.println();
					
				}else{
					System.out.println("�ش� �̸��� ��ȭ��ȣ�ο� �������� �ʽ��ϴ�");
					System.out.println();
				}
				break;
			case 3:
				System.out.print("�����Ͻ� �̸��� �Է��� �ּ��� > ");
				name = sc.next();
				if (phoneBook.containsKey(name)){
					phoneBook.remove(name);
					System.out.println(name + "�� �� ��ȭ��ȣ ������ ���� �Ǿ����ϴ�");
					System.out.println();
				}else{
					System.out.println("�ش� �̸��� ��ȭ��ȣ�ο� �������� �ʽ��ϴ�");
					System.out.println();
				}
				break;
			case 4:
				System.out.print("�˻��Ͻ� �̸��� �Է��� �ּ��� > ");
				name = sc.next();
				if (phoneBook.containsKey(name)){
					System.out.println("=========================");
					System.out.println("�̸� : " + name);
					System.out.println("�ּ� : " + phoneBook.get(name).addr);
					System.out.println("���� : " + phoneBook.get(name).age);
					System.out.println("��ȭ��ȣ : " + phoneBook.get(name).tel);
					System.out.println("=========================");
					
				}else{
					System.out.println("�ش� �̸��� ��ȭ��ȣ�ο� �������� �ʽ��ϴ�");
				}
				break;
			case 5:
				System.out.println("=========================");
				System.out.println("��ȣ\t�̸�\t��ȭ��ȣ\t����\t��°�");
				Set<String> phoneSet = phoneBook.keySet();
				int count = 0;
				for(String key : phoneSet){
					count ++;
					System.out.println(count + "\t" + key +"\t" + phoneBook.get(key).toString());
				}
				
				
				System.out.println("=========================");
				break;

			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
		}
		
		
		
	}

	/*
 	����) �̸�, �ּ�, ����, ��ȭ��ȣ�� ��������� ���� PhoneŬ������ �����
 		 Map�� �̿��Ͽ� ��ȭ��ȣ ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 		 
 		 - �� ���α׷����� ��ȭ��ȣ�� ���, ����, ����, �˻�, ��ü ����ϴ� ����� �ִ�.
 		 - ������ �˻� ����� '�̸�'�� �Է� �޾� ó���Ѵ�.
 		 - (Map�� ������ key������ �� ����� '�̸�'�� ����ϰ�,
 		              value�����δ� 'PhoneŬ������ �ν��Ͻ�'�� �Ѵ�.)
 
 	���࿹��)
 		���� �޴��� �����ϼ���.
 		1. ��ȭ��ȣ ���
 		2. ��ȭ��ȣ ����
 		3. ��ȭ��ȣ ����
 		4. ��ȭ��ȣ �˻�
 		5. ��ȭ��ȣ ��ü���
 		0. ���α׷� ����
 		---------------
 		��ȣ�Է�> 1
 		
 		���Ӱ� ����� ��ȭ��ȣ ������ �Է��ϼ���
 		�̸� >> ȫ�浿
 		��ȭ��ȣ >> 010-1111-1111
 		���� >> 30
 		�ּ� >> ������ �߱� ���ﵿ
 		
 		'ȫ�浿' ��ȭ��ȣ ��� �Ϸ�!!
 		
 		
 		
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