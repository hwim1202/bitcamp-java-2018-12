package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Lesson;
import bitcamp.lms.util.ArrayList;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>();
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

  public void detailLesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
    Lesson lesson = list.get(index);
    
    if (lesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return;
    }

    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("설명: %s\n", lesson.getContents());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
  }

  public void updateLesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
    Lesson lesson = list.get(index);
    
      Lesson temp = new Lesson();

      temp.setNumber(lesson.getNumber());

      System.out.printf("수업명(%s)? ", lesson.getTitle());
      String input = keyboard.nextLine();
      temp.setTitle(input.length() > 0 ? input : lesson.getTitle());

      System.out.printf("설명(%s)? ", lesson.getContents());
      input = keyboard.nextLine();
      temp.setContents(input.length() > 0 ? input : lesson.getContents());

      System.out.printf("시작일(%s)? ", lesson.getStartDate());
      input = keyboard.nextLine();
      temp.setStartDate(input.length() > 0 ? Date.valueOf(input) : lesson.getStartDate());
      
      System.out.printf("종료일(%s)? ", lesson.getEndDate());
      input = keyboard.nextLine();
      temp.setEndDate(input.length() > 0 ? Date.valueOf(input) : lesson.getEndDate());

      System.out.printf("총수업시간(%d)? ", lesson.getTotalHours());
      input = keyboard.nextLine();
      temp.setTotalHours(input.length() > 0 ? 
          Integer.parseInt(input) : lesson.getTotalHours());

      System.out.printf("일수업시간(%d)? ", lesson.getDayHours());
      input = keyboard.nextLine();
      temp.setDayHours(input.length() > 0 ? 
          Integer.parseInt(input) : lesson.getDayHours());

      list.set(index, temp);
  }
  public void deleteLesson() {
    int no = promptLessonNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
    list.remove(index);
    System.out.println("수업을 삭제했습니다.");
  }


  private boolean validate(int index) {
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return false;
    }
    return true;
  }


  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      Lesson l = list.get(i);
      if (l.getNumber() == no) {
        return i;
      }
    }
    
    return -1;
  }


  private int promptLessonNo() {
    System.out.print("번호? ");
  return Integer.parseInt(keyboard.nextLine());
  }
}
