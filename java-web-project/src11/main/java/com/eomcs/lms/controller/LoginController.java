package com.eomcs.lms.controller;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
public class LoginController {

  static final String REFERER_URL = "refererUrl";
  @Autowired MemberService memberService;

  @RequestMapping("/auth/login")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals("GET")) {
      HttpSession session = request.getSession();
      session.setAttribute(REFERER_URL, request.getHeader("Referer"));
      return "/auth/form.jsp";
    }

    ServletContext sc = request.getServletContext();

    // 이메일 저장을 처리한다. 
    Cookie cookie;
    if (request.getParameter("saveEmail") != null) {
      cookie = new Cookie("email", request.getParameter("email"));
      cookie.setMaxAge(60 * 60 * 24 * 15); // 15일간 쿠키를 보관한다.
    } else { 
      cookie = new Cookie ("email", "");
      cookie.setMaxAge(0); // 기존의 쿠키를 제거한다.
    }

    response.addCookie(cookie);

    // 쿠키를 응답 헤더에 추가하는 것은 프론트 컨트롤러에게 맡긴다.
    ArrayList<Cookie> cookies = new ArrayList<>();
    cookies.add(cookie);

    Member member = memberService.get(
        request.getParameter("email"),
        request.getParameter("password"));

    if (member == null) {
      return "/auth/fail.jsp";
    }

    HttpSession session = request.getSession();
    session.setAttribute("loginUser", member);

    String refererUrl = (String) session.getAttribute(REFERER_URL);
    if (refererUrl == null) {
      return "redirect:" + sc.getContextPath();
    } else {
      return "redirect:" + refererUrl;
    }
  }
}










