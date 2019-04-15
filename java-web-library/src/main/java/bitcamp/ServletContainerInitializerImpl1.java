package bitcamp;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

// 이 클래스의 전체 이름(패키지명 포함)을 다음 경로의 파일에 등록해야 한다
// ==> /META-INF/services/javax.servlet.ServletContainerInitializer
public class ServletContainerInitializerImpl1  implements ServletContainerInitializer {
  
  @Override
  public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
    // 이 메서드는 서블릿 컨테이너가 시작될 때 자동 호출된다
    System.out.println("ServletContainerInitializerImpl1.onStartup()... 호출됨!");
  }
  
}
