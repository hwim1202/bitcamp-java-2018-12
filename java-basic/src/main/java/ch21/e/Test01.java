// 예외 던지기 - 예외를 보고하지 않는 경우
package ch21.e;

public class Test01 {
  
  static class MyException extends Exception {

    public MyException() {
      super();
    }

    public MyException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
    }

    public MyException(String message, Throwable cause) {
      super(message, cause);
    }

    public MyException(String message) {
      super(message);
    }

    public MyException(Throwable cause) {
      super(cause);
    }
    
  }
  
  public static void main(String[] args) throws Exception{
    
    m1();
    
  }
  
  static void m1() throws MyException {
    throw new MyException();
  }
 
}






