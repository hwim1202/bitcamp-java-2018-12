package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Board;

public class BoardHandler {

  Board[] Boards = new Board[10];
  public Scanner keyboard;
  int i = 0;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void addBoard() {

    Board boa = new Board();
    
    Boards[i] = boa;

    System.out.print("번호? ");      
    boa.number = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용? ");
    boa.contents = keyboard.nextLine();

    boa.createdDate = new Date(System.currentTimeMillis());

    boa.viewCount = 0;

    System.out.println("저장하였습니다.");
    
    i++;
  }
  public void listBoard() {
    for (int j = 0; j < i; j++) {        
      System.out.printf("%d, %s, 작성일: %s, 조회수: %s\n", 
          Boards[j].number, Boards[j].contents, Boards[j].createdDate, Boards[j].viewCount);
    }
  }

}
