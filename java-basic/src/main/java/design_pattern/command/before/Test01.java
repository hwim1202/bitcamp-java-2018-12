package design_pattern.command.before;

import java.util.HashMap;
import java.util.Scanner;
import design_pattern.command.after.BoardAddCommand;
import design_pattern.command.after.BoardDeleteCommand;
import design_pattern.command.after.BoardDetailCommand;
import design_pattern.command.after.BoardListCommand;
import design_pattern.command.after.BoardUpdateCommand;
import design_pattern.command.after.Command;
import design_pattern.command.after.HelloCommand;
import design_pattern.command.after.MemberAddCommand;
import design_pattern.command.after.MemberDeleteCommand;
import design_pattern.command.after.MemberDetailCommand;
import design_pattern.command.after.MemberListCommand;
import design_pattern.command.after.MemberUpdateCommand;

public class Test01 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    HashMap<String, Command> commandMap = new HashMap<>();
    commandMap.put("/board/add", new BoardAddCommand());
    commandMap.put("/board/detail", new BoardDetailCommand());
    commandMap.put("/board/list", new BoardListCommand());
    commandMap.put("/board/update", new BoardUpdateCommand());
    commandMap.put("/board/delete", new BoardDeleteCommand());

    commandMap.put("/member/add", new MemberAddCommand());
    commandMap.put("/member/detail", new MemberDetailCommand());
    commandMap.put("/member/list", new MemberListCommand());
    commandMap.put("/member/update", new MemberUpdateCommand());
    commandMap.put("/member/delete", new MemberDeleteCommand());

    commandMap.put("hello", new HelloCommand());

    while(true) {
      System.out.println("명령> ");
      String input = keyboard.nextLine();

      Command command = commandMap.get(input);

      if (command != null) {
        command.execute();
        
      } else if ("quit".equals(input)) {
        break;
        
      } else {
        System.out.println("처리할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    keyboard.close();
  }
}
