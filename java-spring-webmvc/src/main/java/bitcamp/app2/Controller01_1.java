// View Resolver 교체하기
package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c01_1")
public class Controller01_1 {

  // http://localhost:8080/java-spring-webmvc/app2/c01_1/h1
  @GetMapping("h1")
  public String handler1() {
    // InternalResourceViewResolver를 사용하여 JSP URL의 접두어와 접미사를 미리 설정해 둘 수 있다
    // JSP 전체 URL을 request handler에서 지정할 필요가 없어 편리하다
    // app2-servlet.xml을 참고하라
    // view resolver를 교체한 태그가 있을 것이다

    // 프론트 컨트롤러는 request handler가 리턴한 URL을 view resoler에게 전달한다
    // view resolver는 자신의 정책에 맞춰 해당 URL을 처리한다
    // --> InternalResourceViewResolver의 경우
    // request handler가 리턴한 URL 앞, 뒤에 접두사와 접미사를 붙여 JSP를 찾는다
    // 예를 들어 다음 URL을 리턴하면 최종 JSP URL은
    // "/WEB-INF/jsp2/c01_1/h1.jsp"가 된다
    return "c01_1/h1";
  }

  @GetMapping("h2")
  public void handler2() {
    // InternalResourceViewResolver를 사용하는 경우
    // request handler가 값을 리턴하지 않으면 request handler의 URL을 리턴 값으로 사용한다
    // 이 핸들러의 URL은 "/c01_1/h2"이므로
    // 최종 JSP URL은 "/WEB-INF/jsp2/" + "/c01_1/h2" + ".jsp" 이다
    // --> "/WEB-INF/jsp2/c01_1/h2.jsp"
  }
}