
package bitcamp.lms;

import java.sql.Date;

public class App {

  static java.util.Scanner keyboard = new java.util.Scanner(System.in);

  final static int LENGTH = 10;

  static Lesson[] Lessons = new Lesson[LENGTH];
  static Member[] Members = new Member[LENGTH];
  static Board[] Boards = new Board[LENGTH];

  static String command = keyboard.nextLine();

  static int i = 0;
  static int j = 0;

  public static void main(String[] args) {




    while (i < 10) {
      System.out.print("명령");


      if (command.equals("/lesson/add")) {
        LessonHandler.addLesson();

      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();
      }
      else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.contentEquals("/member/add")) {
        MemberHandler.addMember();

      }
      else if (command.equals("/member/list")) {
        MemberHandler.listMember();
      }
      else if (command.contentEquals("/board/add")) {
        BoardHandler.addBoard();
      }
      else if (command.equals("/board/list")) {
        BoardHandler.listBoard();
      }
      else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      keyboard.close();
    }
  }
}