package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Lesson;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;
  
  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new ArrayList<>();
  }

  public void listLesson() {
    Lesson[] lessons = list.toArray(new Lesson[10]);
    
    for (Lesson lesson : lessons) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          lesson.getNumber(), lesson.getTitle(), lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }

  public void addLesson() {

    Lesson les = new Lesson();

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
    
    list.add(les);

    System.out.println("저장하였습니다.");
    
  }

}
