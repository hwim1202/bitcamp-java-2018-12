package com.eomcs.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Scanner;
import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

// App 객체의 상태가 변경될 때마다 보고 받는 옵저버가 되려면
// ApplicationContextListener 규격에 따라 작성해야 한다.
public class ApplicationInitializer implements ApplicationContextListener {

  Connection con;

  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {

      // DAO가 사용할 커넥션 객체 준비
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");

      // DAO 객체 준비
      LessonDaoImpl lessonAgent = new LessonDaoImpl(con);
      MemberDaoImpl memberAgent = new MemberDaoImpl(con);
      BoardDaoImpl boardAgent = new BoardDaoImpl(con);

      // Command 객체 준비
      Scanner keyboard =  (Scanner) context.get("keyboard");

      context.put("/lesson/add", new LessonAddCommand(keyboard, lessonAgent));
      context.put("/lesson/list", new LessonListCommand(keyboard, lessonAgent));
      context.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonAgent));
      context.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonAgent));
      context.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonAgent));


      context.put("/member/add", new MemberAddCommand(keyboard, memberAgent));
      context.put("/member/list", new MemberListCommand(keyboard, memberAgent));
      context.put("/member/detail", new MemberDetailCommand(keyboard, memberAgent));
      context.put("/member/update", new MemberUpdateCommand(keyboard, memberAgent));
      context.put("/member/delete", new MemberDeleteCommand(keyboard, memberAgent));


      context.put("/board/add", new BoardAddCommand(keyboard, boardAgent));
      context.put("/board/list", new BoardListCommand(keyboard, boardAgent));
      context.put("/board/detail", new BoardDetailCommand(keyboard, boardAgent));
      context.put("/board/update", new BoardUpdateCommand(keyboard, boardAgent));
      context.put("/board/delete", new BoardDeleteCommand(keyboard, boardAgent));
    } catch (Exception e) {
      throw new ApplicationContextException(e);
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    try {
      con.close();
    } catch (Exception e) {
      throw new ApplicationContextException(e);
    }

  }

}
