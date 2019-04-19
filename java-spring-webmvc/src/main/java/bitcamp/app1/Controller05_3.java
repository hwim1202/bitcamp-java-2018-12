// 요청 핸들러에서 view 컴포넌트(JSP) 쪽에 데이터 전달하기
package bitcamp.app1;

import java.util.Map;
import javax.servlet.ServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/c05_3")
public class Controller05_3 {

  // http://localhost:8080/java-spring-webmvc/app1/c05_3/h1
  @GetMapping("h1")
  public String handler1(ServletRequest request) {

    request.setAttribute("name", "홍길동");
    request.setAttribute("age", 20);
    request.setAttribute("working", true);

    return "/WEB-INF/jsp/c05_3.jsp";
  }

  @GetMapping("h2")
  public String handler2(Map<String, Object> map) {
    // 맵 객체에 JSP에 전달할 값을 담아 놓으면 프론트컨트롤러가 JSP를 실행하기 전에
    // ServletRequest로 복사한다, 따라서 ServletRequest에 값을 담는 것과 같다

    map.put("name", "홍길동");
    map.put("age", 20);
    map.put("working", true);

    return "/WEB-INF/jsp/c05_3.jsp";
  }

  @GetMapping("h3")
  public String handler3(Model model) {

    model.addAttribute("name", "홍길동");
    model.addAttribute("age", 20);
    model.addAttribute("working", true);

    return "/WEB-INF/jsp/c05_3.jsp";
  }

  @GetMapping("h4")
  public ModelAndView handler4() {

    ModelAndView mv = new ModelAndView();
    mv.addObject("name", "홍길동");
    mv.addObject("age", 20);
    mv.addObject("working", true);

    // 값도 담고 실제 주소도 담는다
    mv.setViewName("/WEB-INF/jsp/c05_3.jsp");

    return mv;
  }
}