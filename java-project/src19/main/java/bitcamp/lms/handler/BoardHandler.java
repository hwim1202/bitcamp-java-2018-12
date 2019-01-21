package bitcamp.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Board;
import bitcamp.lms.util.ArrayList;

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
      System.out.printf("번호: %d, 내용: %s, 작성일: %s, 조회수: %s\n", 
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
  public void detailBoard() {
    int no = promptBoardNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
    Board board = list.get(index);
    
    if (board == null) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }

    System.out.printf("번호: %d\n", board.getNumber());
    System.out.printf("내용: %s\n", board.getContents());
    System.out.printf("작성일: %s\n", board.getCreatedDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

  public void updateBoard() {
    int no = promptBoardNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
    Board board = list.get(index);
    
      Board temp = new Board();

      temp.setNumber(board.getNumber());

      System.out.printf("내용(%s)? ", board.getContents());
      String input = keyboard.nextLine();
      temp.setContents(input.length() > 0 ? input : board.getContents());

      list.set(index, temp);
  }
  public void deleteBoard() {
    int no = promptBoardNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
    list.remove(index);
    System.out.println("게시글을 삭제했습니다.");
  }


  private boolean validate(int index) {
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return false;
    }
    return true;
  }


  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      Board b = list.get(i);
      if (b.getNumber() == no) {
        return i;
      }
    }
    
    return -1;
  }


  private int promptBoardNo() {
    System.out.print("번호? ");
  return Integer.parseInt(keyboard.nextLine());
  }

}
