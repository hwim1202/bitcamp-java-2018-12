package bitcamp.app2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 인터셉터
// --> 프론트 컨트롤러와 페이지 컨트롤러 사이에 코드를 상비하는 기술

// 인터셉터 배치하기
// --> 프론트 컨트롤러의 IoC 설정 파일에 배치 정보를 추가한다
public class Controller04_1_Interceptor3 implements HandlerInterceptor{

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // 페이지 컨트롤러의 핸들러를 호출하기 전에 이 메서드가 호출된
    System.out.println("Interceptor3.preHandle()");
    
    // 다음 인터셉터나 페이지 컨트롤러를 계속 실행하려면 true, 여기서 요청을 완료하고 싶다면 false
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    // 페이지 컨트롤러의 핸들러가 리턴한 후 이 메서드가 호출된다
    System.out.println("Interceptor3.postHandler()");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    // JSP를 실행한 후 이 메서드가 호출된다
    System.out.println("Interceptor3.afterCompletion()");

  }
}
