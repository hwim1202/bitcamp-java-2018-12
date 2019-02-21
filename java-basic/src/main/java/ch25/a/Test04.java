// DBMS에 연결하기 - java.sql.Driver 구현체 조회
package ch25.a;

import java.sql.DriverManager;

public class Test04 {

  public static void main(String[] args) {
    try {
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver);
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
