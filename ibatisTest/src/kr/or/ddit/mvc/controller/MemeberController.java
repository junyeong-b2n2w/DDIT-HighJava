package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemeberController {
	private IMemberService service;
	private Scanner scan;

	public MemeberController() {
		service = MemberServiceImpl.getInstance();
		scan = new Scanner(System.in);
	}
		
		public static void main(String[] args) {
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
				dataInsert();
				
				break;
			case 2:
				dataDelete();
				break;
			case 3:
				dataUpdate();
				break;
			case 4:
				showData();
				break;
			case 5:
				dataUpdate2();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				
				break;

			
			
				}
			}
			
			
		}

		private void dataUpdate2() {
			MemberVO memVo = new MemberVO();
			System.out.println("자료를 수정합니다.");
			System.out.print("아이디 : ");
			String id = scan.nextLine();
			
			if(service.getMemberCount(id) == 0){
				while(true){
				System.out.println("해당 아이디가 존재하지 않습니다.");
				System.out.print("아이디 : ");
				id = scan.nextLine();
				if(service.getMemberCount(id) ==1) break;
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
			paramMap.put("mem_id", id);
			paramMap.put("field", updateFiled);
			paramMap.put("data", updateData);
			
			int cnt = service.updateMemeber2(paramMap);
			
			if(cnt >0){
				System.out.println("수정완료!");
			}else{
				System.out.println("수정실패");
			}
			
			
		}

		private void showData() {
			
			List<MemberVO> memList = service.getAllMember();
			System.out.println("----------전체데이터 -------");
			System.out.println("ID\tName\tTel\tAddr");
			for(MemberVO mem : memList){
				System.out.println(mem.getMem_id() + "\t"+mem.getMem_name() + "\t"+
						mem.getMem_tel() + "\t"+mem.getMem_addr());
			}
			System.out.println("------------------------");
			
			
		}



		private void dataUpdate() {
			MemberVO memVo = new MemberVO();
			System.out.println("자료를 수정합니다.");
			System.out.print("아이디 : ");
			String id = scan.nextLine();
			
			if(service.getMemberCount(id) == 0){
				while(true){
				System.out.println("해당 아이디가 존재하지 않습니다.");
				System.out.print("아이디 : ");
				id = scan.nextLine();
				if(service.getMemberCount(id) ==1) break;
				}
			}
			
			System.out.print("이름 : ");
			String name = scan.nextLine();
			System.out.print("연락처 : ");
			String tel = scan.nextLine();
			System.out.print("주소 : ");
			String addr = scan.nextLine();
			
			memVo.setMem_id(id);
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
			
			if(service.getMemberCount(id) == 0){
				while(true){
				System.out.println("해당 아이디가 존재하지 않습니다.");
				System.out.print("아이디 : ");
				id = scan.nextLine();
				if(service.getMemberCount(id) ==1) break;
				}
			}
			
			int result = service.deleteMember(id);
			
			System.out.println(result + "건 삭제 성공하였습니다.");
			
			return;
		}

		private void dataInsert() {
			MemberVO memVo = new MemberVO();
			System.out.println("자료를 입력합니다.");
			System.out.print("아이디 : ");
			String id = scan.nextLine();
			
			// 아이디 중복확인
			if(service.getMemberCount(id) == 1){
				while(true){
				System.out.println("해당 아이디가 존재합니다 다른 아이디를 입력해주세요");
				System.out.print("아이디 : ");
				id = scan.nextLine();
				if(service.getMemberCount(id) ==0) break;
				}
			}
			
			System.out.print("이름 : ");
			String name = scan.nextLine();
			System.out.print("연락처 : ");
			String tel = scan.nextLine();
			System.out.print("주소 : ");
			String addr = scan.nextLine();
			
			memVo.setMem_id(id);
			memVo.setMem_name(name);
			memVo.setMem_tel(tel);
			memVo.setMem_addr(addr);
			
			int result = service.insertMember(memVo) ;
			
			System.out.println(result + "건 등록 성공하였습니다.");
			
			return;
		}

}
	

