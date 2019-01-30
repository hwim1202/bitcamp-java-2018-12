  package bitcamp.lms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import bitcamp.lms.domain.Board;
import bitcamp.lms.domain.Lesson;
import bitcamp.lms.domain.Member;
import bitcamp.lms.handler.BoardAddCommand;
import bitcamp.lms.handler.BoardDeleteCommand;
import bitcamp.lms.handler.BoardDetailCommand;
import bitcamp.lms.handler.BoardListCommand;
import bitcamp.lms.handler.BoardUpdateCommand;
import bitcamp.lms.handler.Command;
import bitcamp.lms.handler.LessonAddCommand;
import bitcamp.lms.handler.LessonDeleteCommand;
import bitcamp.lms.handler.LessonDetailCommand;
import bitcamp.lms.handler.LessonListCommand;
import bitcamp.lms.handler.LessonUpdateCommand;
import bitcamp.lms.handler.MemberAddCommand;
import bitcamp.lms.handler.MemberDeleteCommand;
import bitcamp.lms.handler.MemberDetailCommand;
import bitcamp.lms.handler.MemberListCommand;
import bitcamp.lms.handler.MemberUpdateCommand;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static java.util.Stack<String> commandHistory = new java.util.Stack<>();
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>();
  static ArrayList<Lesson> lessonList = new ArrayList<>();

  
  public static void main(String[] args) {
    
    loadLessonData();
    
    ArrayList<Member> memberList = new ArrayList<>();
    ArrayList<Board> boardList = new ArrayList<>();
    HashMap<String, Command>commandMap = new HashMap<>();
    
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    
    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    
    

    while (true) {
      String command = prompt();

      commandHistory.push(command);

      commandHistory2.offer(command);
      
      
      if (command.equals("quit")) {
        quit();
        break;

      } else if (command.equals("history")) {
        printCommandHistory();

      } else if (command.equals("history2")) {
        printCommandHistory2();

      } else {
        Command commandHandler = commandMap.get(command);
        if (commandHandler == null)
        System.out.println("실행할 수 없는 명령입니다.");
        else if (commandHandler != null) {
          try {
            commandHandler.execute();
          } catch (Exception e) {
            System.out.printf("작업 중 오류 발생: %s\n", e.toString());
          }
        }
      }

      System.out.println();
    }

    keyboard.close();
  }

  private static void printCommandHistory() {
    Iterator<String> iterator = commandHistory.iterator();
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if (++count %5 == 0) {
        System.out.println();
        String input = keyboard.nextLine();
        if (input.equalsIgnoreCase("q"))
          break;
      }
    }
  }

  private static void printCommandHistory2() {
    Iterator<String> iterator = commandHistory2.iterator();
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if (++count %5 == 0) {
        System.out.println();
        String input = keyboard.nextLine();
        if (input.equalsIgnoreCase("q"))
          break;
      }
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
  
  private static void quit() {
    saveLessonData();
    System.out.println("안녕!");
  }
  
  private static void loadLessonData() {
    try (FileReader in = new FileReader("lesson.csv");
        Scanner in2 = new Scanner(in);
        ) {
      while (true) {
        lessonList.add(Lesson.valueOf(in2.nextLine()));
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      
    } catch (IOException e) {
      e.printStackTrace();
    } catch (NoSuchElementException e) {
      System.out.println("수업 데이터 로딩 완료!");
    }
  }
  
  private static void saveLessonData() {
    try(FileWriter out = new FileWriter("lesson.csv");) {
      for(Lesson lesson : lessonList) {
        out.write(String.format("%s,%s,%s,%s,%s,%d,%d\n", lesson.getNo(), lesson.getTitle(),
            lesson.getContents(), lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours(), lesson.getDayHours()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
