package ch03;

public class Test03 {
    public static void main(String[] args) {
      
      int a = 5;
      int b = 2;
      System.out.println(a / b); // int와 int의 계산 결과는 int이다.
      
      float f1 = 9876.543f;
      float f2 = 12.34567f;
      System.out.println(f1);
      System.out.println(f2);
      System.out.println(f1 + f2); // 4바이트  float의 크기 (7자리)를 넘어가면 반올림한다
      
      double d1 = 9876.543;
      double d2 = 12.34567;
      System.out.println(d1);
      System.out.println(d2);
      System.out.println(d1 + d2);
      // 자바에서 정수 기본형은 int(4바이트), 부동소수점 기본형은 double(8바이트)
      
    }
}