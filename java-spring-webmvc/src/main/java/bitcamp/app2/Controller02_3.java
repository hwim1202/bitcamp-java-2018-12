package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c02_3")
public class Controller02_3 {

  // http://localhost:8080/java-spring-webmvc/app2/c02_3/h1/hongkildong/010-1111-2222/man
  @GetMapping(value="h1/{name}/{tel}/{gender}", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler1(
      @PathVariable String name,
      @PathVariable String tel,
      @PathVariable String gender) {
    
    return String.format("name: %s\n tel: %s\n gender: %s", name, tel, gender);
  }
  
  @GetMapping(value="h2/{name:[a-zA-Z0-9]+}/{tel:[0-9]+-[0-9]+-[0-9]+}/{gender:man|woman}",
      produces="text/plain;charset=UTF-8")
  // 패스 변수를 정규표현식으로 정의
  @ResponseBody
  public String handler2(
      @PathVariable String name,
      @PathVariable String tel,
      @PathVariable String gender) {
    
    return String.format("name: %s\n tel: %s\n gender: %s", name, tel, gender);
  }
}