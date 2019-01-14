package bitcamp.lms;

import java.util.Scanner;
import bitcamp. lms.handler.BoardHandler;
import bitcamp.lms.handler.LessonHandler;
import bitcamp.lms.handler.MemberHandler;
import bitcamp. lms.handler.BoardHandler2;

public class App {

  static int i = 0 ;

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    while (i < 10) {
      System.out.print("명령");
      String command = keyboard.nextLine();

      if (command.equals("/lesson/add")) {
        LessonHandler.addLesson();
      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();
      } else if (command.equals("/member/add")) {
        MemberHandler.addMember();
      }else if (command.equals("/member/list")) {
        MemberHandler.listMember();
      }else if (command.equals("/board/add")) {
        BoardHandler.addBoard();
      }else if (command.equals("/board/list")) {
        BoardHandler.listBoard();
      }else if (command.equals("/board2/add")) {
        BoardHandler2.addBoard();
      }else if (command.equals("/board2/list")) {
        BoardHandler2.listBoard();
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      }
      else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }
  }
}