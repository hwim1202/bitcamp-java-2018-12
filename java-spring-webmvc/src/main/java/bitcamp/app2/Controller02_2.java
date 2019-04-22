package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c02_2")
public class Controller02_2 {

  // http://localhost:8080/java-spring-webmvc/app2/c02_2?name=kim&age=20
  @GetMapping
  @ResponseBody
  public String handler1(String name, int age) {
    return String.format("name=%s, age=%d,", name, age);
  }

  // http://localhost:8080/java-spring-webmvc/app2/c02_2/name=kim;age=20
  @GetMapping(value="{value}",produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2(
      @PathVariable String value,
      // value값 중에서 name 항목의 값을 받고 싶을 때 @MatrixVariable을 사용한다
      // 단 value의 형식은 '이름=값;이름=값;이름=값' 형식이어야 한다
      /*@MatrixVariable("name")String name,
      @MatrixVariable("age")int age*/
      @MatrixVariable String name, @MatrixVariable int age) {
    // @MatrixVariable 애노테이션을 사용하려면 IoC컨테이너에 등록해야한다
    // @Autowired를 사용하려면 해당 객체를 등록하는 것과 같다
    // --> <mvc:annotation-driven enable-matrix-variables="true"/>
    
    // 테스트1
    // http://.../app2/c02_2?user;name=kim;age=20
    
    return String.format("value:%s \n --> name:%s, age:%d,",value, name, age);
  }
  
  @GetMapping(value="{team}/{task}",produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler3(
      @MatrixVariable String name,
      @MatrixVariable int qty,
      @MatrixVariable String title,
      @MatrixVariable int state) {
    
    return String.format("team: %s(%d)\n task: %s, %d", name, qty, title, state);
  }
  
  @GetMapping(value="h4/{team}/{task}",produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler4(
      @MatrixVariable (name="name", pathVar="team") String name,
      @MatrixVariable (name="qty", pathVar="task") int qty,
      @MatrixVariable (name="title", pathVar="task") String title,
      @MatrixVariable (name="state", pathVar="task") int state) {
    
    return String.format("team: %s(%d)\n task: %s, %d", name, qty, title, state);
  }
}