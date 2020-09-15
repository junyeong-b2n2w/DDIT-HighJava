package kr.or.ddit.mvc.vo;

public class BoardVO {


    int board_no;

    public int getBoard_no() {
        return board_no;
    }

    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    String  board_title;
   String board_writer ;
   int board_cnt ;
   String board_content;
   String board_date;

    public String getBoard_date() {
        return board_date;
    }

    public void setBoard_date(String board_date) {
        this.board_date = board_date;
    }

    public String getBoard_writer() {
        return board_writer;
    }

    public void setBoard_writer(String board_writer) {
        this.board_writer = board_writer;
    }

    public int getBoard_cnt() {
        return board_cnt;
    }

    public void setBoard_cnt(int board_cnt) {
        this.board_cnt = board_cnt;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }
}
