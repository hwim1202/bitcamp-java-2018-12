// JSON 컨텐트 출력하기 - @RestController
package bitcamp.app2;

import java.beans.PropertyEditorSupport;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 페이지 컨트롤러를 @RestController로 선언하면
// 리턴 값이 HttpMessageConverter에 의해 자동으로 변환된다
// @ResponseBody를 붙일 필요가 없다
@RequestMapping("/c05_3")
public class Controller05_3 {
  
  // 1) JSON 형식의 요청 파라미터 값을 낱개로 입력 받기
  // http://localhost:8080/java-spring-webmvc/app2/c05_3/h1?no=1&title=ok&writer=kim&viewCount=100
  @RequestMapping(value="h1", produces="text/plain;charset=utf-8")
  public Object handler1(
      int no,
      String title,
      String writer,
      int viewCount) {
    
    return String.format("%d,%s,%s,%d", no, title, writer, viewCount);
  }
  
  // 2) JSON 형식의 요청 파라미터 값을 객체로 입력 받기
  @RequestMapping(value="h2", produces="text/plain;charset=utf-8")
  public Object handler2(Board board) {
    return board.toString();
  }
  
  // 3) JSON 형식의 요청 파라미터 값을 통째로 문자열로 받기
  //.../html/app2/c05_3_h3.html
  @RequestMapping(value="h3", produces="text/plain;charset=utf-8")
  public Object handler3(@RequestBody String content) throws Exception {
    System.out.println(content);
    System.out.println(URLDecoder.decode(content, "UTF-8"));
    return "OK";
  }
  
  // 4) JSON 형식의 요청 파라미터 값을 맵 객체로 받기
  // => HttpMessageConverter 구현체(예:MappingJackson2HttpMessageConverter)가
  //    클라이언트가 보낸 데이터를 Map 객체에 담아준다.
  // => 이 기능을 쓰고 싶다면 Gson 또는 Jackson 라이브러리를 반드시 포함해야 한다.
  //    그래야 스프링의 DispatcherServlet에서 찾는다.
  //.../html/app2/c05_3_h4.html
  @RequestMapping(value="h4", produces="text/plain;charset=utf-8")
  public Object handler4(@RequestBody Map<String,Object> content) throws Exception {
    System.out.println(content);
    return "OK";
  }
  
  // 5) JSON 형식의 요청 파라미터 값을 도메인 객체로 받기
  // => HttpMessageConverter 구현체(예: MappingJackson2HttpMessageConverter)가
  //    클라이언트가 보낸 데이터를 도메인 객체(예: Board, Member, Lesson 등)에 담아준다.
  // => Json 데이터의 프로퍼티 명과 도메인 객체의 프로퍼티 명이 일치해야 한다.
  //.../html/app2/c05_3_h4.html
  @RequestMapping(value="h5", produces="text/plain;charset=utf-8")
  public Object handler5(@RequestBody Board content) throws Exception {
    System.out.println(content);
    return "OK";
  }
  
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    //System.out.println("Controller04_4.initBinder()");
    // 프로퍼티 에디터를 등록하려면 그 일을 수행할 객체(WebDataBinder)가 필요하다.
    // request handler 처럼 아규먼트를 선언하여 
    // 프론트 컨트롤러에게 달라고 요청하라.

    // String ===> Date 프로퍼티 에디터 준비 
    DatePropertyEditor propEditor = new DatePropertyEditor();

    // WebDataBinder에 프로퍼티 에디터 등록하기
    binder.registerCustomEditor(
        java.util.Date.class, // String을 Date 타입으로 바꾸는 에디터임을 지정한다. 
        propEditor  // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
        );
  
  }
  
  class DatePropertyEditor extends  PropertyEditorSupport {

    // yyyy-MM-dd 형태의 문자열을 java.util.Date 객체로 만들어주는 클래스를 준비한다.
    SimpleDateFormat format;

    public DatePropertyEditor() {
      // 프로퍼티 에디터를 사용하는 측에서 어떤 형식의 문자열을 Date 객체로 만들 것인지 
      // 설정하지 않았다면 기본으로 yyyy-MM-dd 형식의 문자열을 Date 객체로 만들도록 준비한다.
      format = new SimpleDateFormat("yyyy-MM-dd");
    }

    public DatePropertyEditor(SimpleDateFormat format) {
      // 물론 프로퍼티 에디터를 사용하는 측에서 날짜에 대한 문자열 형식을 지정할 수도 있다.
      this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      System.out.println("DatePropertyEditor.setAsText()");
      // 프로퍼티 에디터를 사용하는 측(예: 프론트 컨트롤러)에서 
      // 문자열을 Date 객체로 바꾸기 위해 이 메서드를 호출할 것이다.
      // 그러면 이 메서드에서 문자열을 프로퍼티가 원하는 타입으로 변환한 후 저장하면 된다.
      try {
        Date date = format.parse(text); // String ===> java.util.Date 
        setValue(date); // 내부에 저장
      } catch (ParseException e) {
        throw new IllegalArgumentException(e);
      }
    }

  }
  

}