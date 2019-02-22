package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {
  
  Scanner keyboard;
  LessonDao lessonDao;
  
  public LessonListCommand(Scanner keyboard, LessonDao lessonAgent) {
    this.keyboard = keyboard;
    this.lessonDao = lessonAgent;
  }
  
  
  @Override
  public void execute() {
    try {
      List<Lesson> lessons = lessonDao.findAll();
      for (Lesson lesson : lessons) {
        System.out.printf("%d, %s, %s, %s ~ %s, %d, %d\n", 
            lesson.getNo(), lesson.getTitle(), lesson.getContents(), lesson.getStartDate(),
            lesson.getEndDate(), lesson.getTotalHours(), lesson.getDayHours());
      }
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
