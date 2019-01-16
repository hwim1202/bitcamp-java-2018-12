// 캡슐화(encapsulation)의 필요성 - 사례1
package ch12.a;

public class Test01 {
  public static void main(String[] args) {
    
    Calculator c = new Calculator();
    c.plus(100);
    c.plus(15);
    c.minus(27);
    System.out.println(c.result);
    
    
    Calculator c2 = new Calculator();
    c2.plus(100);
    c2.plus(15);
    c2.result = 100;
    c2.minus(27);
    System.out.println(c2.result);
    
    
  }
}