package bitcamp;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class WebApplicationInitializerImpl3 extends AbstractDispatcherServletInitializer {

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app8/*"};
  }
  
  @Override
  protected String getServletName() {
    return "app8";
  }


  @Override
  protected WebApplicationContext createServletApplicationContext() {
    XmlWebApplicationContext iocContainer = new XmlWebApplicationContext();
    iocContainer.setConfigLocation("/WEB-INF/app8-servlet.xml");
    return iocContainer;
  }

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    // TODO Auto-generated method stub
    return null;
  }
}
