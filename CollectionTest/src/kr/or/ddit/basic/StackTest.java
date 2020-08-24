package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackTest {

	public static void main(String[] args) {
		
		Browser b = new Browser();
		
		b.goURL("1.���̹�");
		b.goURL("2.����");
		b.goURL("3.����");
		b.goURL("4.����");

		b.history();
		
		System.out.println("�ڷΰ���");
		b.goBack();
		b.history();
		
		System.out.println("�ڷΰ���");
		b.goBack();
		b.history();
	}

}
	class Browser{
		private LinkedList<String> back;
		private LinkedList<String> forward;
		private String currentURL;
		
		public Browser(){
			back = new LinkedList<>();
			forward = new LinkedList<>();
			currentURL = "";
		}
		
		public void goURL(String url){
			if(currentURL != null && !"".equals(currentURL)){
				back.push(currentURL);
			}
			currentURL = url;
		}
		
		public void goBack(){
			if(!back.isEmpty()){
				forward.push(currentURL);
				currentURL = back.pop();
			}
		}
		
		public void goForward(){
			if(!forward.isEmpty()){
				back.push(currentURL);
				currentURL = forward.pop();
			}
		}
		
		public void history(){
			System.out.println("-------------------------------------");
			System.out.println(" �� �� �� ��");
			System.out.println("back > " + back);
			System.out.println("���� > " + currentURL);
			System.out.println("forward >" + forward);
			
			
			
		}
	}
	

	
	

