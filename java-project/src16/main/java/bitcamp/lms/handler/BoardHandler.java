package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Board;
import bitcamp.lms.domain.Lesson;

public class BoardHandler {

  Scanner keyboard;
  BoardList list;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new BoardList();
  }
  
  public void listBoard() {
    Board[] boards = list.toArray();
    for (Board board : boards) {        
      System.out.printf("%d, %s, 작성일: %s, 조회수: %s\n", 
          board.getNumber(), board.getContents(), board.getCreatedDate(), board.getViewCount());
    }
  }

  public void addBoard() {

    Board boa = new Board();

    System.out.print("번호? ");      
    boa.setNumber(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    boa.setContents(keyboard.nextLine());

    boa.setCreatedDate(new Date(System.currentTimeMillis()));

    boa.setViewCount(0);
    
    list.add(boa);

    System.out.println("저장하였습니다.");
  }

}
