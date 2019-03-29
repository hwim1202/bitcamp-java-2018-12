package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

// 멀티파트 형식의 데이터를 처리할 서블릿으로 선언
//@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
//@WebServlet("/ex04/s5")
public class Servlet05 extends GenericServlet {

  private static final long serialVersionUID = 1L;
  private String uploadDir;

  @Override
  public void init() throws ServletException {
    // init(ServletConfig)가 호출될 때 이 메서드를 호출한다.
    // 1) 파일을 저장할 디렉토리 경로를 준비한다.
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    
    req.setCharacterEncoding("UTF-8");

    // 파라미터로 받은 ServletRequest를 원래의 타입으로 변환
    HttpServletRequest httpReq = (HttpServletRequest) req;

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("<html>");
    out.println("<head><title>servlet04</title><head>");
    out.println("<body><h1>파일 업로드 결과</h1>");

    // 일반 폼 데이터를 원래 하던 방식대로 값을 꺼낸다.
    out.printf("이름=%s\n", httpReq.getParameter("name"));
    out.printf("나이=%s\n", httpReq.getParameter("age"));

    // 파일 데이터는 getPart()를 이용한다.
    Part photoPart = httpReq.getPart("photo");
    String filename = UUID.randomUUID().toString();
    if (photoPart.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      photoPart.write(this.uploadDir + "/" + filename);
    }
    out.printf("사진=%s\n", filename);
    out.printf("<img src='../upload/%s'>\n", filename);
    out.println("<body><html>");


  }
}
