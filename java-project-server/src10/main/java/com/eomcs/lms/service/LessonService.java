package com.eomcs.lms.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonService {

  List<Lesson> lessons;

   ObjectInputStream in;
   ObjectOutputStream out;
   String filepath;
   
   public void init(ObjectInputStream in, ObjectOutputStream out) {
     this.in = in;
     this.out = out;
   }
   
   @SuppressWarnings("unchecked")
   public void loadData(String filepath) {
     this.filepath = filepath;
     
     try (ObjectInputStream in = new ObjectInputStream(
         new BufferedInputStream(
             new FileInputStream("this.filepath")))) {
       
       lessons = (List<Lesson>) in.readObject();
       
     } catch (Exception e) {
       lessons = new ArrayList<Lesson>();
       throw new RuntimeException ("수업 정보 로딩 오류", e);
     }
   }
   public void saveData() throws Exception {
     try (ObjectInputStream in = new ObjectInputStream(
         new BufferedInputStream(
             new FileInputStream(this.filepath)))) {
       
       out.writeObject(lessons);
       
     } catch (Exception e) {
       throw new Exception("수업 정보 저장 오류", e);
     }
   }
   
  public  void execute(String request) throws Exception {

    switch (request) {
      case "/lesson/add":
        add();
        break;
      case "/lesson/list":
        list();
        break;
      case "/lesson/detail":
        detail();
        break;
      case "/lesson/update":
        update();
        break;
      case "/lesson/delete":
        delete();
        break;  
      default:
        out.writeUTF("FAIL");
    }
    out.flush();
  }

  private void add() throws Exception {
    out.writeUTF("OK");
    out.flush();
    lessons.add((Lesson)in.readObject());
    out.writeUTF("OK");
  }

  private void list() throws Exception {
    out.writeUTF("OK");
    out.flush();
    out.writeUTF("OK");
    out.writeObject(lessons);
  }

  private void detail() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    for (Lesson l : lessons) {
      if (l.getNo() == no) {
        out.writeUTF("OK");
        out.writeObject(l);
        return;
      }
    }

    out.writeUTF("FAIL");
  }

  private void update() throws Exception {
    out.writeUTF("OK");
    out.flush();
    Lesson lesson = (Lesson) in.readObject();

    int index = 0;
    for (Lesson l : lessons) {
      if (l.getNo() == lesson.getNo()) {
        lessons.set(index, lesson);
        out.writeUTF("OK");
        return;
      }
      index++;
    }

    out.writeUTF("FAIL");
  }

  private void delete() throws Exception {
    out.writeUTF("OK");
    out.flush();
    int no = in.readInt();

    int index = 0;
    for (Lesson l : lessons) {
      if (l.getNo() == no) {
        lessons.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    }

    out.writeUTF("FAIL");    
  }

}







