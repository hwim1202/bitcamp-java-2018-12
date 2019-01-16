// getter/setter를 적용해야 하는 이유
package ch12.b;

public class Test03 {
  public static void main(String[] args) {

    Score s1 = new Score();
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 80;
    s1.compute();
    System.out.printf("총점=%d, 평균=%.1f\n", s1.getSum(), s1.getAver());

    Score s2 = new Score();
    s2.name = "홍길동";
    s2.kor = 100;
    s2.eng = 90;
    s2.math = 80;
    s2.compute();
    //s2.aver = 95.5f;
    System.out.printf("총점=%d, 평균=%.1f\n", s2.getSum(), s2.getAver());
    
    s1.kor = 70;
    System.out.printf("총점=%d, 평균=%.1f\n", s1.getSum(), s1.getAver());
    
    s1.eng = -200;
    s1.compute();
    System.out.printf("총점=%d, 평균=%.1f\n", s1.getSum(), s1.getAver());
  }
}