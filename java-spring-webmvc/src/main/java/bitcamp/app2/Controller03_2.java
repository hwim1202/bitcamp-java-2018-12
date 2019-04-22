// 세션 다루기 - @SessionAttributes
package bitcamp.app2;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/c03_2")

// 뷰 컴포넌트(jsp)에 전달하는 값 중 세션에 보관할 값의 이름을 지정하면 프론트 컨트롤러는
// 그 값을 HttpSession 객체에도 보관한다
@SessionAttributes({/*"name","age",*/"name2", "age2"})
public class Controller03_2 {

  // http://localhost:8080/java-spring-webmvc/app2/c03_2/h1
  @GetMapping(value="h1", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler1(Model model) {

    // 세션에 값을 담고 싶으면 Model 객체에 담는다
    // 단 @SessionAttributes 에서 지정한 이름의 값만 세션에 자동 보관된다
    model.addAttribute("name2", "임꺽정");
    model.addAttribute("age2", "20");

    // @SessionAttributes에 등록되지 않은 이름의 값은 세션에 보관되지 않는다
    model.addAttribute("tel2", "111-1111");

    return "세션에 값 보관했음";

  }

  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2(HttpSession session) {

    return String.format("name2=%s, age2=%s, tel2=%s",
        session.getAttribute("name2"),
        session.getAttribute("age2"),
        session.getAttribute("tel2")
        ); }

  @GetMapping(value="h3", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler3(
      // @ModelAttribute에 지정된 이름이 @SessionAttributes에 있는 경우
      // --> 세션에 해당값이 있으면 아규먼트에 넣어준다    
      @ModelAttribute("name2") String name2,
      @ModelAttribute("age2") String age2,

      // @ModelAttribute에 지정된 이름이 @SessionAttributes에 없는 경우
      // --> 세션에 값이 있던 없던 아규먼트에 빈 문자열을 넣어준다
      // --> 요청 파라미터(URL)에 tel2값이 들어오면 그 값을 넣어준다
      @ModelAttribute("tel2") String tel2) {

    return String.format("name2=%s, age2=%s, tel2=%s",name2, age2, tel2);
  }
  
  @GetMapping(value="h4", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler4(
      // c03_1/h1에서 세션에 저장한 값 꺼내기 --> 현재 페이지의 @SessionAttributes에서 지정해줘야 꺼낼 수 있다
      @ModelAttribute("name") String name,
      @ModelAttribute("age") String age,
      
      // 현재 컨트롤러에서 세션에 저장한 값 꺼내기
      @ModelAttribute("name2") String name2,
      @ModelAttribute("age2") String age2) {

    return String.format("name=%s, age=%s, name2=%s, age2=%s",name, age, name2, age2);
  }

}