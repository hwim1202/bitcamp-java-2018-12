package bitcamp.lms;

import java.sql.Date;

import bitcamp.lms.domain.Board;

public class BoardHandler {

  static java.util.Scanner keyboard = new java.util.Scanner(System.in);

  final static int LENGTH = 10;

  static Board[] Boards = new Board[LENGTH];

  static int i = 0;
  static int j = 0;

  static void addBoard() {
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
  static void listBoard() {
    for (int j = 0; j < i; j++) {        
      System.out.printf("%d, %s, 작성일: %s, 조회수: %s\n", 
          Boards[j].number, Boards[j].contents, Boards[j].createdDate, Boards[j].viewCount);
    }
  }

}
