
package bitcamp.lms;

public class App {

  static java.util.Scanner keyboard = new java.util.Scanner(System.in);

  static int i = 0;

  public static void main(String[] args) {

    while (i < 10) {
      
      String command = order();

      if (command.equals("/lesson/add")) {
        LessonHandler.addLesson();

      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();
        
      } else if (command.contentEquals("/member/add")) {
        MemberHandler.addMember();
        
      } else if (command.equals("/member/list")) {
        MemberHandler.listMember();
      } else if (command.contentEquals("/board/add")) {
        BoardHandler.addBoard();
        
      } else if (command.equals("/board/list")) {
        BoardHandler.listBoard();
        
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }
    keyboard.close();
  }
  static String order() {
    System.out.print("명령");
    return keyboard.nextLine();
  }
}