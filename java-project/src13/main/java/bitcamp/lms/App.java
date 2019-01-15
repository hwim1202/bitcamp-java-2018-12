package bitcamp.lms;

import java.util.Scanner;
import bitcamp. lms.handler.BoardHandler;
import bitcamp.lms.handler.LessonHandler;
import bitcamp.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    LessonHandler lessonhandler = new LessonHandler();
    lessonhandler.keyboard = keyboard;
    
    MemberHandler memberhandler = new MemberHandler();
    memberhandler.keyboard = keyboard;

    BoardHandler boardhandler1 = new BoardHandler();
    boardhandler1.keyboard = keyboard;

    BoardHandler boardhandler2 = new BoardHandler();
    boardhandler2.keyboard = keyboard;

    
    while (true) {
      System.out.print("명령");
      String command = keyboard.nextLine();
      
      if (command.equals("/lesson/add")) {
        lessonhandler.addLesson();
      } else if (command.equals("/lesson/list")) {
        lessonhandler.listLesson();
      } else if (command.equals("/member/add")) {
        memberhandler.addMember();
      }else if (command.equals("/member/list")) {
        memberhandler.listMember();
      }else if (command.equals("/board/add")) {
        boardhandler1.addBoard();
      }else if (command.equals("/board/list")) {
        boardhandler1.listBoard();
      }else if (command.equals("/board2/add")) {
        boardhandler2.addBoard();
      }else if (command.equals("/board2/list")) {
        boardhandler2.listBoard();
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