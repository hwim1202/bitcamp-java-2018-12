package bitcamp.lms.handler;
import java.util.List;
import java.util.Scanner;
import bitcamp.lms.domain.Board;

public class BoardListCommand implements Command{
   
  Scanner keyboard;
  List<Board> list;
  
  public BoardListCommand(Scanner keyboard, List<Board> list) {
    this.keyboard = keyboard;
    this.list = list;
  }
  
  public void execute() {
    Board[] boards = new Board[list.size()];
    list.toArray(boards);
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }
}
