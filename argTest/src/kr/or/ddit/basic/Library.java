package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Library {
	
	static HashMap<String, Book> bookShelf = new HashMap<>();
	public static void main(String[] args) {
		
		

		/*
		 * 1. 등록
		 * 2. 수정
		 * 3. 삭제
		 * 4. 검색
		 * 5. 전체정보 출력
		 * 6. 반납 및 대여
		 * 0. 종료
		 * 
		 * 
		 */
		
		Library library = new Library();
		library.start();
		
		
		
	}

	private void start() {
		
		Scanner sc = new Scanner(System.in);
		int input = 0;
		while(true){
		
		System.out.println("==============================");
		System.out.println("  도서관리 프로그램");
		System.out.println("==============================");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 수정");
		System.out.println("3. 도서 삭제");
		System.out.println("4. 도서 검색");
		System.out.println("5. 전체 도서 검색");
		System.out.println("6. 도서 반납 및 대여");
		System.out.println("0. 종료");
		System.out.println("==============================");
		System.out.print("입력 >");
		input = Integer.parseInt(sc.nextLine());
		switch (input) {
		case 1:
			Library.bookAdd();
			break;
		case 2:
			Library.bookEdit();
			break;
		case 3:
			Library.bookDel();
			break;
		case 4:
			Library.bookSearch();
			break;
		case 5:
			Library.bookSearchAll();
			break;
		case 6:
			Library.bookRent();
			break;
		case 0:
			System.out.println("종료합니다.");
			System.exit(0);
			break;

		}
		
		}
	}

	private static void bookRent() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================================");
		System.out.println("책 대여 / 반납을 진행 합니다.");
		System.out.println("1. 대여\t 2.반납");
		System.out.print("입력 > ");
		String choice = sc.nextLine();
		if (choice.equals("1")){
			System.out.println("대여하실 책 번호를 입력해주세요.");
			System.out.print("입력 > ");
			String bookNo = sc.nextLine();
			if(!bookShelf.containsKey(bookNo)){
				System.out.println("해당 책번호가 존재하지 않습니다");
				return;
			}else if(bookShelf.get(bookNo).isRentable()){
				System.out.println(bookNo + "번 책을 대여합니다");
				bookShelf.get(bookNo).setRentable(false);
				return;
			}else{
				System.out.println("해당 책은 이미 대여중 입니다.");
				return;
			}
		}
		if (choice.equals("2")){
			System.out.println("반납하실 책 번호를 입력해주세요.");
			System.out.print("입력 > ");
			String bookNo = sc.nextLine();
			if(!bookShelf.containsKey(bookNo)){
				System.out.println("해당 책번호가 존재하지 않습니다");
				return;
			}else if(!bookShelf.get(bookNo).isRentable()){
				System.out.println(bookNo + "번 책을 반납합니다");
				bookShelf.get(bookNo).setRentable(true);
				return;
			}else{
				System.out.println("해당 책은 대여되지 않은 책 입니다.");
			}
		}
			
	}

	private static void bookSearchAll() {
		System.out.println("================================");
		System.out.println("번호\t제목\t저자\t장르\t대여여부");
		Set<String> bookKey = bookShelf.keySet();
		List<String> bookList = new ArrayList<>(bookKey);
		
		Collections.sort(bookList);
		
		for(String book : bookList){
			System.out.println(bookShelf.get(book));
		}
		
		System.out.println("================================");
		return;
	}

	private static void bookSearch() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================================");
		System.out.println("책 정보를 검색합니다.");
		System.out.println("================================");
		System.out.println("정보를 검색하실 책 번호를 입력해주세요.");
		System.out.print("입력 > ");
		String bookNo = sc.nextLine();
		if(!bookShelf.containsKey(bookNo)){
			System.out.println("해당 번호로 등록된 책이 존재하지 않습니다.");
			return;
		}
		
		System.out.println("--------------------");
		System.out.println("책번호 : "+ bookShelf.get(bookNo).getBookNo());
		System.out.println("책제목 : "+ bookShelf.get(bookNo).getTitle());
		System.out.println("책저자 : "+ bookShelf.get(bookNo).getAuthor());
		System.out.println("책장르 : "+ bookShelf.get(bookNo).getGenre());
		System.out.println("책저자 : "+ (bookShelf.get(bookNo).isRentable()?"대여 가능":"대여 중"));
		System.out.println("--------------------");
		return;
		
	}

	private static void bookDel() {
	Scanner sc = new Scanner(System.in);
		
		System.out.println("================================");
		System.out.println("책 정보를 삭제합니다.");
		System.out.println("================================");
		System.out.println("정보를 수정하실 책 번호를 입력해주세요.");
		System.out.print("입력 > ");
		String bookNo = sc.nextLine();
		if(!bookShelf.containsKey(bookNo)){
			System.out.println("해당 번호로 등록된 책이 존재하지 않습니다.");
			return;
		}
		bookShelf.remove(bookNo);
		System.out.println(bookNo + "번 책 정보가 삭제 되었습니다.");
		return;
	}

	private static void bookEdit() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================================");
		System.out.println("책 정보를 수정합니다.");
		System.out.println("================================");
		System.out.println("정보를 수정하실 책 번호를 입력해주세요.");
		System.out.print("입력 > ");
		String bookNo = sc.nextLine();
		if(!bookShelf.containsKey(bookNo)){
			System.out.println("해당 번호로 등록된 책이 존재하지 않습니다.");
			return;
		}
		System.out.println("수정하실 책 제목를 입력해주세요.");
		System.out.print("입력 > ");
		String title = sc.nextLine();
		System.out.println("수정하실 책의 저자를 입력해주세요.");
		System.out.print("입력 > ");
		String author = sc.nextLine();
		System.out.println("수정하실 책의 장르를 입력해주세요.");
		System.out.print("입력 > ");
		String genre = sc.nextLine();
		
		bookShelf.put(bookNo, new Book(bookNo, title, author, genre));
		System.out.println(bookNo+"번 "+title+"이 수정 완료되었습니다.");
		
		return;
	}

	private static void bookAdd() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================================");
		System.out.println("새로운 책을 등록합니다.");
		System.out.println("================================");
		System.out.println("등록하실 책 번호를 입력해주세요.");
		System.out.print("입력 > ");
		String bookNo = sc.nextLine();
		if(bookShelf.containsKey(bookNo)){
			System.out.println("해당 번호로 등록된 책이 존재합니다.");
			return;
		}
		
		System.out.println("등록하실 책 제목를 입력해주세요.");
		System.out.print("입력 > ");
		String title = sc.nextLine();
		System.out.println("등록하실 책의 저자를 입력해주세요.");
		System.out.print("입력 > ");
		String author = sc.nextLine();
		System.out.println("등록하실 책의 장르를 입력해주세요.");
		System.out.print("입력 > ");
		String genre = sc.nextLine();
		
		bookShelf.put(bookNo, new Book(bookNo, title, author, genre));
		System.out.println(bookNo+"번 "+title+"이 등록 완료되었습니다.");
		return;
	}

	
	
}

class Book{
	String bookNo;
	String title;
	String author;
	String genre;
	boolean rentable;
	
	public Book(String bookNo, String title, String author, String genre) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.rentable = true;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isRentable() {
		return rentable;
	}

	public void setRentable(boolean rentable) {
		this.rentable = rentable;
	}

	@Override
	public String toString() {
		return bookNo + "\t" + title + "\t"
				+ author + "\t" + genre + "\t" + (rentable?"대여 가능":"대여 중");
	}
	
	
	
}