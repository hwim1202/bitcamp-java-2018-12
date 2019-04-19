// 요청 핸들러의 아규먼트 - @multipart/form-data 형식의 파라미터 값 받기
package bitcamp.app1;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/c04_8")
public class Controller04_8 {

  @Autowired
  ServletContext sc; // 서블릿 컨텍스트는 메서드의 아규먼트로 받을 수 없다. 의존객체로 주입 받아야 한다

  // 클라이언트가 멀티파트 형식으로 전송한 데이터 꺼내기

  //    http://...html/app1/c04_8.html
  @PostMapping(value="h1", produces="text/html;charset=UTF-8") 
  @ResponseBody
  public String handler1(
      String name,
      int age,
      MultipartFile photo
      ) throws Exception {

    String filename = null;
    if (!photo.isEmpty()) {
      filename = UUID.randomUUID().toString();
      String path = sc.getRealPath("/html/app1/" + filename);
      photo.transferTo(new File(path));
    }

    return "<html><head><title>c04_8/h1</title></head>"
    + "<body><h1>업로드 결과</h1>"
    + "<p>이름: " + name + "<p>"
    + "<p>나이: " + age + "</p>"
    +  (filename != null ? "<p><img src='../../html/app1/" + filename + "'></p>" : "")
    + "</body></html>";

  }

  @PostMapping(value="h2", produces="text/html;charset=UTF-8") 
  @ResponseBody
  public String handler2(
      String name,
      int age,
      MultipartFile[] photo //같은 이름으로 전송된 파일을 배열로 받기
      ) throws Exception {

    StringWriter out0 = new StringWriter();
    PrintWriter out = new PrintWriter(out0);
    out.println("<html><head><title>c04_8/h1</title></head>");
    out.println("<body><h1>업로드 결과</h1>");
    out.printf("<p>이름: %s</p>\n", name);
    out.printf("<p>나이: %d</p>\n", age);

    for (MultipartFile f : photo) {
      if (!f.isEmpty()) {
        String filename = UUID.randomUUID().toString();
        String path = sc.getRealPath("/html/app1/" + filename);
        f.transferTo(new File(path));
        out.printf("<p><img src='../../html/app1/%s'></p>\n", filename);
      }
    }

    out.println("</body></html>");
    return out0.toString();
  }
}

