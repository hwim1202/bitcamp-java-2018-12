// JSON 컨텐트 출력하기 - @RestController
package bitcamp.app2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 페이지 컨트롤러를 @RestController로 선언하면
// 리턴 값이 HttpMessageConverter에 의해 자동으로 변환된다
// @ResponseBody를 붙일 필요가 없다
@RequestMapping("/c05_2")
public class Controller05_2 {

  ArrayList<Board> list = new ArrayList<>();

  public Controller05_2() {

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

  // http://localhost:8080/java-spring-webmvc/app2/c05_2/h1
  @GetMapping(value="h1")
  public Object handler1() {
    return this.list; //JSON 형식의 문자열은 자동으로 UTF-8로 인코딩 된다
  }

  @GetMapping(value="h2", produces="text/plain;charset=UTF-8")
  public String handler2() {
    return "안녕하세요";
  }
  
  @GetMapping(value="h3")
  public int handler3() {
    return 100;
  }
  
  @GetMapping(value="h4")
  public Object handler4() {
    HashMap<String,Object> content = new HashMap<>();
    content.put("v1", 100);
    content.put("v2", "Hello");
    
    return content;
  }
}