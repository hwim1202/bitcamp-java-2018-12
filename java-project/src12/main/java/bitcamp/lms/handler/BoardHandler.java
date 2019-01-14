package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Board;

public class BoardHandler {
  
  static Board[] Boards = new Board[10];
  static Scanner keyboard = new Scanner(System.in);
  static int i = 0;

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
  public static void addBoard() {

    Board boa = new Board();
    Boards[i] = boa;
    i++;

    System.out.print("번호? ");      
    boa.number = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용? ");
    boa.contents = keyboard.nextLine();

    boa.createdDate = new Date(System.currentTimeMillis());

    boa.viewCount = 0;

    System.out.println("저장하였습니다.");
  }
  public static void listBoard() {
    for (int j = 0; j < i; j++) {        
      System.out.printf("%d, %s, 작성일: %s, 조회수: %s\n", 
          Boards[j].number, Boards[j].contents, Boards[j].createdDate, Boards[j].viewCount);
    }
  }

}
