package ch21.d;

public class Test08 {
  public static void main(String[] args) {
    try {
    m3();
    } catch (RuntimeException e) {
      
    }
    System.out.println("종료!");
  }
  
  static void m3() {
    m2();
  }

  static void m2() {
    m1();
  }

  static void m1() throws RuntimeException {
    throw new RuntimeException("m1()에서 발생한 예외");
  }

}