package bitcamp.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Board;

public class BoardHandler {

  Scanner keyboard;
  ArrayList<Board> list;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new ArrayList<>();
  }
  
  public void listBoard() {
    Board[] boards = list.toArray(new Board[0]);
    
    for (Board board : boards) {
      System.out.printf("%d, %s, 작성일: %s, 조회수: %s\n", 
          board.getNumber(), board.getContents(), board.getCreatedDate(), board.getViewCount());
    }
  }

  public void addBoard() {

    Board board = new Board();

    System.out.print("번호? ");      
    board.setNumber(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis()));

    board.setViewCount(0);
    
    list.add(board);

    System.out.println("저장하였습니다.");
  }

}