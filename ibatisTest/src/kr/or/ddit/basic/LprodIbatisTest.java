package kr.or.ddit.basic;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


//iBatis를 이용하여 DB자료를 처리하는 예제
public class LprodIbatisTest {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 처리 순서
		

		try {
			//1. iBatis설정 파일을 읽어와서 실행한다. (sqlMapConfig.xml파일)
			// 1-1. 문자인코딩 케릭터 셋 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2. 환경 설정파일 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경설정을 완성한 후 
			// 		SQL문을 호출해서 실행할 수 있는 객체를 생성한다.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // 스트림 닫기
			
			//--------------------------
			
			// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
			
			// 2-1. insert연습
			
		/*
			System.out.println("insert 작업 시작 ...");
			System.out.print("Lprod_id 입력 : ");
			int lprodId = scan.nextInt();
			
			System.out.print("Lprod_gu 입력 : ");
			String lprodGu = scan.next();
			
			System.out.print("Lprod_nm 입력 : ");
			String lprodNm = scan.next();
			
			// 1) insert할 데이터 를 VO 객체에 담기
			LprodVO lprodVO = new LprodVO();
			lprodVO.setLprod_id(lprodId);
			lprodVO.setLprod_gu(lprodGu);
			lprodVO.setLprod_nm(lprodNm);
			*/
			
			
			// 2) sqlMapClient 객체의 객체변수를 이용해서 처리할 쿼리문을 호출하여 실행한다.
			// 형식) smc.insert("실행할 쿼리문이 있는 문서의 namespace.실행할쿼리문의 id 속성값", 파라미터 클래스);
			// 반환값 : insert성공 : null, 실패 : 오류객체 반환
			/*
			Object obj = smc.insert("lprod.insertLprod",lprodVO);
			
			if(obj == null){
				System.out.println("insert 작업 성공");
			}else{
				System.out.println("insert 작업 실패!!");
			}
		*/
			
			///----------------------
			
		/*	
			
			// update 할 데이터
			System.out.println("insert 작업 시작 ...");
			
			System.out.print("Lprod_gu 입력 : ");
			String lprodGu = scan.next();
			
			System.out.print("Lprod_id 입력 : ");
			int lprodId = scan.nextInt();
			
			System.out.print("Lprod_nm 입력 : ");
			String lprodNm = scan.next();
			
			// update 할 데이터 담기
			LprodVO lprodVO = new LprodVO();
			lprodVO.setLprod_id(lprodId);
			lprodVO.setLprod_gu(lprodGu);
			lprodVO.setLprod_nm(lprodNm);
			
			// 2) mc.update("실행할 쿼리문이 있는 문서의 namespace.실행할쿼리문의 id 속성값", 파라미터 클래스);
			// 반환값 : 성공한 레코드수
			int cnt = smc.update("lprod.updateLprod",lprodVO);
			
			if(cnt > 0){
				System.out.println("update 작업 성공");
			}else{
				System.out.println("update 작업 실패!!");
			}
		*/
		/*	
			// 3. delete 작업
			
			
			System.out.println("delete 작업 시작 ...");
			System.out.print("Lprod_gu 입력 : ");
			String delGu = scan.next();
			
			//
			int cnt = smc.delete("lprod.deleteLprod", delGu);
			
			if(cnt > 0){
				System.out.println("delete 작업 성공");
			}else{
				System.out.println("delete 작업 실패!!");
			}
		*/
			// 4. select 작업
			
		/*	//1) select 결과가 여러개의 레코드 일경우
			System.out.println("select 작업시작 ( 결과가 여러개일 경우 )");
			
			//select 응답 결과가 여러개일 경우에는 queryForList()메서드를 사용하는데
			//이메서드는 여러개의 레코드 각각을 VO에 담은 후 이VO데이터를 list에 추가해 주는 작업을 
			// 자동으로 수행한다.
			// 형식) smc.queryForList("namespace값.id속성값",파라미터클래스)
			// 반환값 : VO객체가 저장된 List객체
			
			List<LprodVO> lprodList = smc.queryForList("lprod.getAllprod");
			
			for(LprodVO prod : lprodList){
				System.out.println(prod.getLprod_id() + "\t" + prod.getLprod_gu() + "\t"+ prod.getLprod_nm());
			}
		*/	
			//2) select 결과 한개의 레코드일 경우
			System.out.println("select 작업시작 ( 결과가 1개일 경우 )");
			
			System.out.print("검색할 lprod_gu 입력 : ");
			String searchGu = scan.next();
			
			// select의 처리 결과가 1개가 확실할 경우 queryForObject()메서드를 사용한다,
			// 형식 ) smc.queryForObject("namespace값.id속성값",파라미터클래스)
			// 반환값 : select한 결과가 저장된 VO 객체(resultClass에 지정한 객체)
			
			LprodVO lprodVO = (LprodVO) smc.queryForObject("lprod.getLprod",searchGu);
			
			if(lprodVO == null){
				System.out.println("검색한 데이터가 하나도 없습니다.");
			}else{
			System.out.println(lprodVO.getLprod_id() + "\t" + lprodVO.getLprod_gu() + "\t"+ lprodVO.getLprod_nm());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//2. 
		
		
		
	}

}
