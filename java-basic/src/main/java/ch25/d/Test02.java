package ch25.d;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02 {

  public static void main(String[] args) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      
      con.setAutoCommit(false);
      
      for (int i=0; i<3; i++) {
      try (PreparedStatement stmt = con.prepareStatement(
          "insert into x_board(title, contents) values(?,?)")) {
        
        stmt.setString(1, "aaa");
        stmt.setString(2, "bbb");
        stmt.executeUpdate();
        System.out.println("입력 성공!");
        }
      }
      
      con.setAutoCommit(true);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
