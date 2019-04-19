// 요청 핸들러의 리턴 값 - content를 직접 리턴하기
package bitcamp.app1;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c05_1")
public class Controller05_1 {

  // http://localhost:8080/java-spring-webmvc/app1/c05_1/h1
  @GetMapping("h1")
  @ResponseBody
  public String handler1() {

    // 리턴 값이 클라이언트에게 보내는 content라면 메서드 선언부에 @ResponseBody를 붙인다
    return "<html><body><h1>abc가각간</h1></body></html>";
  }

  // http://localhost:8080/java-spring-webmvc/app1/c05_1/h2
  @GetMapping(value="h2", produces="text/html;charset=UTF-8")
  @ResponseBody
  public String handler2() {

    return "<html><body><h1>abc가각간</h1></body></html>";
  }

  @GetMapping("h3")
  @ResponseBody
  public String handler3(HttpServletResponse response) {

    // HttpServletResponse에 대해 다음과 같이 설정해봐야 소용없다
    response.setContentType("text/html;charset=UTF-8");

    return "<html><body><h1>abc가각간</h1></body></html>";
  }

  @GetMapping("h4")
  public HttpEntity<String> handler4(HttpServletResponse response) {
    //HttpEntity 객체에 content를 담아 리턴할 수 있다
    // 이 경우에는 리턴 타입으로 content임을 알 수 있기 때문에 @ResponseBody 애노테이션을 붙이지 않아도 된다
    HttpEntity<String> entity = new HttpEntity<>("<html><body><h1>abc가각간</h1></body></html>");

    return entity;
  }

  @GetMapping(value="h5", produces="text/html;charset=UTF-8")
  public HttpEntity<String> handler5(HttpServletResponse response) {
    HttpEntity<String> entity = new HttpEntity<>("<html><body><h1>abc가각간</h1></body></html>");

    return entity;
  }

  @GetMapping(value="h6")
  public HttpEntity<String> handler6(HttpServletResponse response) {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/html;charset=UTF-8");

    HttpEntity<String> entity = new HttpEntity<>("<html><body><h1>abc가각간</h1></body></html>", headers);

    return entity;
  }

  @GetMapping(value="h7")
  public ResponseEntity<String> handler7(HttpServletResponse response) {
    //HttpEntity 하위 ResponseEntity 객체로 리턴 할 수 있다

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/html;charset=UTF-8");
    
    // 응답 헤더를 따로 설정하는 이유는 임의의 응답 헤더를 추가하는 경우가 있기 때문이다

    ResponseEntity<String> entity = new ResponseEntity<>(
        "<html><body><h1>abc가각간</h1></body></html>", headers, HttpStatus.OK);

    return entity;
  }
}