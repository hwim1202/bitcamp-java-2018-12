
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
        addLesson();

      } else if (command.equals("/lesson/list")) {
        listLesson();
      }
      else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.contentEquals("/member/add")) {
        addMember();

      }
      else if (command.equals("/member/list")) {
        listMember();
      }
      else if (command.contentEquals("/board/add")) {
        addBoard();
      }
      else if (command.equals("/board/list")) {
        listBoard();
      }
      else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }
  }

  static void addLesson() {

    Lesson les = new Lesson();

    Lessons[i] = les;

    i++;

    System.out.print("번호? ");      
    les.number = Integer.parseInt(keyboard.nextLine());

    System.out.print("수업명? ");
    les.title = keyboard.nextLine();

    System.out.print("수업내용? ");
    les.contents = keyboard.nextLine();

    System.out.print("시작일? ");
    les.startDate = Date.valueOf(keyboard.nextLine());

    System.out.print("종료일? ");
    les.endDate = Date.valueOf(keyboard.nextLine());

    System.out.print("총수업시간? ");
    les.totalHours = Integer.parseInt(keyboard.nextLine());

    System.out.print("일수업시간? ");
    les.dayHours = Integer.parseInt(keyboard.nextLine());

    System.out.println("저장하였습니다.");

  }
  static void listLesson() {
    for (j=0 ; j < i; j++){
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          Lessons[j].number, Lessons[j].title, Lessons[j].startDate, Lessons[j].endDate, Lessons[j].totalHours);
      j++;
    }
  }
  static void addMember() {

    Member mem = new Member();
    Members[i] = mem;
    i++;

    System.out.print("번호? ");      
    mem.number = Integer.parseInt(keyboard.nextLine());

    System.out.print("이름? ");
    mem.name = keyboard.nextLine();

    System.out.print("이메일? ");
    mem.mail = keyboard.nextLine();

    System.out.print("암호?");
    mem.password = keyboard.nextLine();

    System.out.print("사진? ");
    mem.photo = keyboard.nextLine();

    System.out.print("전화? ");
    mem.phone = keyboard.nextLine();

    mem.registeredDate = new Date(System.currentTimeMillis());

    System.out.println("저장하였습니다.");
  }
  static void listMember() {
    for (int j = 0; j < i; j++) {        
      System.out.printf("%d, %s, %s, %s, %s\n", 
          Members[j].number, Members[j].name, Members[j].mail, Members[j].phone, Members[j].registeredDate);
    }
  }
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