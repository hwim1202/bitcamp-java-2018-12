package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Lesson;

public class LessonHandler {

  Lesson[] Lessons = new Lesson[10];
  Scanner keyboard;
  int i = 0;
  
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void addLesson() {

    Lesson les = new Lesson();

    Lessons[i] = les;      

    System.out.print("번호? ");
    les.setNumber(Integer.parseInt(keyboard.nextLine()));

    System.out.print("수업명? ");
    les.setTitle(keyboard.nextLine());

    System.out.print("수업내용? ");
    les.setContents(keyboard.nextLine());

    System.out.print("시작일? ");
    les.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    les.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    les.setTotalHours(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간? ");
    les.setDayHours(Integer.parseInt(keyboard.nextLine()));

    System.out.println("저장하였습니다.");

    i++;
  }
  public void listLesson() {
    for (int j=0; j < i; j++) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          Lessons[j].getNumber(), Lessons[j].getTitle(), Lessons[j].getStartDate(), Lessons[j].getEndDate(), Lessons[j].getTotalHours());
    }
  }

}
