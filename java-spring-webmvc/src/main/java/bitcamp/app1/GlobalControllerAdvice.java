package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
// 페이지 컨트롤러를 실행할 때 충고하는 역할
// 즉, 프론트 컨트롤러가 페이지 컨트롤러의 request handler를 호출하기 전에
// 이 애노테이션이 붙은 클래스의 메서드를 호출한다
public class GlobalControllerAdvice {
  
  
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

    // WebDataBinder에 프로퍼티 에디터 등록하기
    binder.registerCustomEditor(
        Car.class, // String을 Car 타입으로 바꾸는 에디터임을 지정한다. 
        new CarPropertyEditor()  // 바꿔주는 일을 하는 프로퍼티 에디터를 등록한다.
        );
    
    binder.registerCustomEditor(
        Engine.class,
        new EnginePropertyEditor());
  }

  // PropertyEditor 만들기
  // => 문자열을 특정 타입의 프로퍼터의 값으로 변환시킬 때 사용하는 에디터이다.
  // => java.beans.PropertyEditor 인터페이스를 구현해야 한다.
  // => PropertyEditor를 직접 구현하면 너무 많은 메서드를 오버라이딩 해야 하기 때문에 
  //    자바에서는 도우미 클래스인 PropertyEditorSupport 클래스를 제공한다.
  //    이 클래스는 PropertyEditor를 미리 구현하였다. 
  //    따라서 이 클래스를 상속 받은 것 더 낫다.
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

  class CarPropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      String[] values = text.split(",");

      Car car = new Car();
      car.setModel(values[0]);
      car.setCapacity(Integer.parseInt(values[1]));
      car.setAuto(Boolean.parseBoolean(values[2]));
      car.setCreatedDate(java.sql.Date.valueOf(values[3]));

      setValue(car);
    }
  }

  class EnginePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      String[] values = text.split(",");

      Engine engine = new Engine();

      engine.setModel(values[0]);
      engine.setCc(Integer.parseInt(values[1]));
      engine.setValve(Integer.parseInt(values[2]));

      setValue(engine);

    }
  }

}
