package ch21.d;

public class Test06 {
  public static void main(String[] args) {
    m3();
    System.out.println("종료!");
  }
  
  static void m3() {
    m2();
  }

  static void m2() {
    m1();
  }

  static void m1() {
    throw new RuntimeException("m1()에서 발생한 예외");
  }

}