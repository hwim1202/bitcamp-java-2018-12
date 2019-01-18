
package bitcamp.lms;

import java.sql.Date;

public class App {
  public static void main(String[] args) {

    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    Lesson[] Lessons = new Lesson[10];
    Member[] Members = new Member[10];
    Board[] Boards = new Board[10];

    int i = 0;

    while (i < 10) {

      Lesson les = new Lesson();
      Lessons[i] = les;
      i++;

      System.out.println("명령?");
      String command = keyboard.nextLine();

      if(command.equals("/lesson/add")) {

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
      else if (command.equals("/lesson/list")) {
          for(int j = 0 ; j < i ; j++) {
          System.out.printf("%d, %s, %s ~ %s, %d\n", 
              Lessons[j].number, Lessons[j].title, Lessons[j].startDate, Lessons[j].endDate, Lessons[j].totalHours);
        }
      }
      else if (command.equals("/member/add")) {
        
        Member mem = new Member();
        Members[i] = mem;
        i++;
        
        System.out.print("번호? ");      
        mem.number = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("이름? ");
        mem.name = keyboard.nextLine();
        
        System.out.print("이메일? ");
        mem.mail = keyboard.nextLine();
        
        System.out.print("암호? ");
        mem.mail = keyboard.nextLine();
        
        System.out.print("사진? ");
        mem.mail = keyboard.nextLine();
        
        System.out.print("전화? ");
        mem.phone = keyboard.nextLine();
        
        mem.registeredDate = new Date(System.currentTimeMillis());
        
        System.out.println("저장하였습니다.");
      }
      else if (command.equals("/member/list")) {
        for (int j = 0; j < i; j++) {        
          System.out.printf("%d, %s, %s, %s, %s\n", 
              Members[j].number, Members[j].name, Members[j].mail, Members[j].phone, Members[j].registeredDate);
        }
      }
    }
  }
}