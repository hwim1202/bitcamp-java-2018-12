// 프로퍼티 값 설정 - 배열 프로퍼티 값 설정하기
package ch29.f;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/f/application-context-01.xml");
    
    System.out.println("---------------------------------------");
    
    System.out.println(iocContainer.getBean("c1"));
    
    java.sql.Date obj = (java.sql.Date) iocContainer.getBean("d1");
    System.out.println(obj);
  }
}






