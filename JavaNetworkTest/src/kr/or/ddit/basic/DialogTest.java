package kr.or.ddit.basic;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class DialogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFileChooser fileChooser = new JFileChooser();
		
		//처음 오픈되는 경로 정하기
		fileChooser.setCurrentDirectory(new File("d:/d_other"));
		//열기용 
//		int result = fileChooser.showOpenDialog(new JPanel());
		
		//저장용
		int result = fileChooser.showSaveDialog(new JPanel());
		
		//----------------
		if (result == JFileChooser.APPROVE_OPTION){
			File selectFile = fileChooser.getSelectedFile();
			System.out.println("선택한 파일은 ? " + selectFile);
		}else{
			System.out.println("작업 취소");
		}
			
	}

}
