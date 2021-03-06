// 스프링 인터셉터 다루기
package bitcamp.app2;

import java.sql.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c05_1")
public class Controller05_1 {
  
  ArrayList<Board> list = new ArrayList<>();
  
  public Controller05_1() {
    
    list.add(new Board(1, "제목입니다1", "내용", "홍길동", 10, Date.valueOf("2019-5-1")));
    list.add(new Board(2, "제목입니다1", "내용", "홍길동2", 11, Date.valueOf("2019-5-2")));
    list.add(new Board(3, "제목입니다1", "내용", "홍길동3", 12, Date.valueOf("2019-5-3")));
    list.add(new Board(4, "제목입니다1", "내용", "홍길동4", 13, Date.valueOf("2019-5-4")));
    list.add(new Board(5, "제목입니다1", "내용", "홍길동5", 14, Date.valueOf("2019-5-5")));
    list.add(new Board(6, "제목입니다1", "내용", "홍길동6", 15, Date.valueOf("2019-5-6")));
    list.add(new Board(7, "제목입니다1", "내용", "홍길동7", 16, Date.valueOf("2019-5-7")));
    list.add(new Board(8, "제목입니다1", "내용", "홍길동8", 17, Date.valueOf("2019-5-8")));
    list.add(new Board(9, "제목입니다1", "내용", "홍길동9", 18, Date.valueOf("2019-5-9")));
    list.add(new Board(10, "제목입니다1", "내용", "홍길동10", 19, Date.valueOf("2019-5-10")));
    list.add(new Board(11, "제목입니다1", "내용", "홍길동11", 20, Date.valueOf("2019-5-11")));
    list.add(new Board(12, "제목입니다1", "내용", "홍길동12", 21, Date.valueOf("2019-5-12")));
    list.add(new Board(13, "제목입니다1", "내용", "홍길동13", 22, Date.valueOf("2019-5-13")));
  }
  
  // 1) JSP에서 JSON 형식의 콘텐트 출력하기
  // http://localhost:8080/java-spring-webmvc/app2/c05_1/h1
  @GetMapping(value="h1")
  public void handler1(Model model) {
    model.addAttribute("list", this.list);
  }
  
  // 2) Google Gson 라이브러리를 사용하여 JSON 형식의 콘텐트 출력하기
  //    mvnrepository.com에서 gson 라이브러리 가져오기
//  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
//  @ResponseBody
//  public String handler2() {
//    
//    return new Gson().toJson(this.list);
//  }
  
  // 2) Google Gson 라이브러리를 사용하여 JSON 형식의 콘텐트 출력하기 II
  //    => 페이지 컨트롤러의 리턴 값이 String이 아니면
  //    => 프론트 컨트롤러는 Google의 Gson 라이브러리나 Jackson 라이브러리를 사용하여
  //    => 자동으로 JSON 형식의 문자열로 만들어 클라이언트로 출력한다
  //    => 단, Gson 또는 Jackson 라이브러리가 있어야 한다
  @GetMapping(value="h3")
  @ResponseBody
  public Object handler3() {

    return this.list;
  }
}