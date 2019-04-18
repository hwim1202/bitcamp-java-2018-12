// 페이지 컨트롤러 만드는 방법
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //이 애노테이션을 붙인다
@RequestMapping("/c01_1") //컨트롤러에 URL을 연결한다
public class Controller01_1 {
  
  @RequestMapping //이 애노테이션을 붙여서 요청이 들어왔을 때 호출될 메서드임을 표시한다
  @ResponseBody //메서드의 리턴 값이 클라이언트에게 출력할 내용임을 표시한다
  public String handler() {
    return "c01_1";
  }
  
  // 같은 URL에 대해 다른 메서드를 정의하면 오류 발생
  /*
  @RequestMapping
  @ResponseBody
  public String handler2() {
    return "c01_1";
  }
  */
}
