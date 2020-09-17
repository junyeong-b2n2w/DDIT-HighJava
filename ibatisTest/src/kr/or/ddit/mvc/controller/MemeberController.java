package kr.or.ddit.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.AES256Util;

public class MemeberController {
	private IMemberService service;
	private Scanner scan;
	private AES256Util aes256 ;
	public MemeberController() throws UnsupportedEncodingException {
		service = MemberServiceImpl.getInstance();
		scan = new Scanner(System.in);
		aes256 = new AES256Util();
	}
		
		public static void main(String[] args) throws UnsupportedEncodingException {
			new MemeberController().start();
		}

		private void start() {
		 
			int input = 0;
			
			while(true){
			System.out.println("--- 작 업 선 택 ---");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("5. 선택수정");
			
			System.out.println("0. 종료");
			System.out.println("---------------");
			System.out.print("입력 >>");
			input = Integer.parseInt(scan.nextLine());
			
			switch (input) {
			case 1:
				try {
					dataInsert();
				} catch (NoSuchAlgorithmException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (UnsupportedEncodingException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (GeneralSecurityException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				break;
			case 2:
				dataDelete();
				break;
			case 3:
				try {
					dataUpdate();
				} catch (NoSuchAlgorithmException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (UnsupportedEncodingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (GeneralSecurityException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case 4:
				try {
					showData();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (GeneralSecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 5:
				try {
					dataUpdate2();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (GeneralSecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				
				break;

			
			
				}
			}
			
			
		}

		private void dataUpdate2() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
			MemberVO memVo = new MemberVO();
			System.out.println("자료를 수정합니다.");
			System.out.print("아이디 : ");
			String id = scan.nextLine();
			
			if(service.getMemberCount( aes256.encrypt(id)) == 0){
				while(true){
				System.out.println("해당 아이디가 존재하지 않습니다.");
				System.out.print("아이디 : ");
				id = scan.nextLine();
				if(service.getMemberCount( aes256.encrypt(id)) ==1) break;
				}
			}
			
			int num;
			String updateFiled = null;
			String updateTitle = null;
			
			do{
				System.out.println();
				System.out.println("수정할 항목을 선택하세요");
				System.out.println("1.회원이름 2.전화번호 3.회원주소");
				System.out.print("수정할 항목 >>");
				num= scan.nextInt();
				
				
				switch (num) {
				case 1:
					updateFiled = "MEM_NAME";
					updateTitle = "회원 이름";
					break;
				case 2:
					updateFiled = "MEM_TEL";
					updateTitle = "전화 번호";
					break;
				case 3:
					updateFiled = "MEM_ADDR";
					updateTitle = "회원 주소";
					break;

				default:
					System.out.println("수정항목을 잘못 선택하였습니다.");
					System.out.println("다시 선택해주세요");
					
					break;
				}
			}while(num < 1 || num >3 );
			
			
			System.out.println();
			scan.nextLine();
			
			System.out.println("새로운" + updateTitle +  ">>");
			String updateData = scan.nextLine();
			
			
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("mem_id",  aes256.encrypt(id));
			paramMap.put("field", updateFiled);
			paramMap.put("data", updateData);
			
			int cnt = service.updateMemeber2(paramMap);
			
			if(cnt >0){
				System.out.println("수정완료!");
			}else{
				System.out.println("수정실패");
			}
			
			
		}

		private void showData() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
			
			List<MemberVO> memList = service.getAllMember();
			System.out.println("----------전체데이터 -------");
			System.out.println("ID\tName\tTel\tAddr");
			for(MemberVO mem : memList){
				System.out.println(aes256.decrypt(mem.getMem_id()) + "\t"+mem.getMem_name() + "\t"+
						mem.getMem_tel() + "\t"+mem.getMem_addr());
			}
			System.out.println("------------------------");
			
			
		}



		private void dataUpdate() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
			MemberVO memVo = new MemberVO();
			System.out.println("자료를 수정합니다.");
			System.out.print("아이디 : ");
			String id = scan.nextLine();
			
			if(service.getMemberCount(aes256.encrypt(id)) == 0){
				while(true){
				System.out.println("해당 아이디가 존재하지 않습니다.");
				System.out.print("아이디 : ");
				id = scan.nextLine();
				if(service.getMemberCount(aes256.encrypt(id)) ==1) break;
				}
			}
			
			System.out.print("이름 : ");
			String name = scan.nextLine();
			System.out.print("연락처 : ");
			String tel = scan.nextLine();
			System.out.print("주소 : ");
			String addr = scan.nextLine();
			
			memVo.setMem_id(aes256.encrypt(id));
			memVo.setMem_name(name);
			memVo.setMem_tel(tel);
			memVo.setMem_addr(addr);
			
			
			int result = service.updateMember(memVo);
			
			System.out.println(result + "건 수정 성공하였습니다.");
			
			return;
		}

		

		private void dataDelete() {
			System.out.println("자료를 삭제합니다.");
			System.out.print("삭제할 아이디 : ");
			String id = scan.nextLine();
			
			if(service.getMemberCount(aes256.encrypt(id)) == 0){
				while(true){
				System.out.println("해당 아이디가 존재하지 않습니다.");
				System.out.print("아이디 : ");
				id = scan.nextLine();
				if(service.getMemberCount(aes256.encrypt(id)) ==1) break;
				}
			}
			
			int result = service.deleteMember(aes256.encrypt(id));
			
			System.out.println(result + "건 삭제 성공하였습니다.");
			
			return;
		}

		private void dataInsert() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
			MemberVO memVo = new MemberVO();
			System.out.println("자료를 입력합니다.");
			System.out.print("아이디 : ");
			String id = scan.nextLine();
			
			// 아이디 중복확인
			if(service.getMemberCount(aes256.encrypt(id)) == 1){
				while(true){
				System.out.println("해당 아이디가 존재합니다 다른 아이디를 입력해주세요");
				System.out.print("아이디 : ");
				id = scan.nextLine();
				if(service.getMemberCount(aes256.encrypt(id)) ==0) break;
				}
			}
			
			System.out.print("이름 : ");
			String name = scan.nextLine();
			System.out.print("연락처 : ");
			String tel = scan.nextLine();
			System.out.print("주소 : ");
			String addr = scan.nextLine();
			
			memVo.setMem_id(aes256.encrypt(id));
			memVo.setMem_name(name);
			memVo.setMem_tel(tel);
			memVo.setMem_addr(addr);
			
			int result = service.insertMember(memVo) ;
			
			System.out.println(result + "건 등록 성공하였습니다.");
			
			return;
		}

}
	

