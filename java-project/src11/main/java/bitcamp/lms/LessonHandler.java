package bitcamp.lms;

import java.sql.Date;

import bitcamp.lms.domain.Lesson;

public class LessonHandler {

  static java.util.Scanner keyboard = new java.util.Scanner(System.in);

  final static int LENGTH = 10;

  static Lesson[] Lessons = new Lesson[LENGTH];

  static int i = 0;
  static int j = 0;



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

}
