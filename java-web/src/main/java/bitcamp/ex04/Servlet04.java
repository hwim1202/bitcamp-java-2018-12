package bitcamp.ex04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ex04/s4")
public class Servlet04 extends GenericServlet {

  private static final long serialVersionUID = 1L;
  private String uploadDir;

  @Override
  public void init() throws ServletException {
    // init(ServletConfig)가 호출될 때 이 메서드를 호출한다.
    // 1) 파일을 저장할 디렉토리 경로를 준비한다.
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    // 멀티파트 데이터를 분석하여 FileItem 객체에 담아 줄 공장을 준비
    DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

    // 공장 객체를 사용하여 클라이언트가 보낸 데이터를 처리할 객체를 준비
    ServletFileUpload multipartDataHandler = new ServletFileUpload(fileItemFactory);

    // 분석한 데이터를 보관할 맵 객체를 준비
    HashMap<String,String> paramMap = new HashMap<>();

    try {
      // 멀티파트 데이터 처리기를 이용하여 클라이언트 요청을 분석
      List<FileItem> parts = multipartDataHandler.parseRequest((HttpServletRequest)req);

      for (FileItem part : parts) {
        if (part.isFormField()) {
          // 파트의 데이터가 텍스트라면
          System.out.printf("%s=%s\n",
              part.getFieldName(), // 클라이언트가 보낸 파라미터 이름
              part.getString("UTF-8")); // 파라미터의 값
          paramMap.put(part.getFieldName(), part.getString("UTF-8"));

        } else {
          // 파트의 데이터가 파일이라면
          // upload/ 디렉토리에 파일을 저장한다.

          // 같은 이름의 파일을 업로드하면 기존의 파일을 덮어쓸수 있기 때문에 임의의 이름으로 저장
          String filename = UUID.randomUUID().toString();

          // 2) 전체 파일 경로를 준비한다.
          File file = new File(this.uploadDir + "/" + filename);

          // 3) 파일 경로에 업로드 파일을 저장한다.
          part.write(file);

          paramMap.put(part.getFieldName(), filename);

        }
      }
      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();

      out.println("<html>");
      out.println("<head><title>servlet04</title><head>");
      out.println("<body><h1>파일 업로드 결과</h1>");
      out.printf("이름=%s\n", paramMap.get("name"));
      out.printf("나이=%s\n", paramMap.get("age"));
      out.printf("사진=%s\n", paramMap.get("photo"));
      out.printf("<img src='../upload/%s'>\n", paramMap.get("photo"));
      out.println("<body><html>");


    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
