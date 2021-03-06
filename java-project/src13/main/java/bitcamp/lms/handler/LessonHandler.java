package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Lesson;

public class LessonHandler {

  Lesson[] Lessons = new Lesson[10];
  public Scanner keyboard;
  int i = 0;

  public void addLesson() {

    Lesson les = new Lesson();

    Lessons[i] = les;      

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

    i++;
  }
  public void listLesson() {
    int j = 0;
    for (j=0; j < i; j++) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          Lessons[j].number, Lessons[j].title, Lessons[j].startDate, Lessons[j].endDate, Lessons[j].totalHours);
      j++;
    }
  }

}
