// Wrapper 클래스
package ch11;

public class Test09 {
  public static void main(String[] args) {
    Integer i1 = new Integer(100); //가능한 사용하지 말자
    Integer i2 = Integer.valueOf(100);
    
    char c1 = new Character('가');
    char c2 = Character.valueOf('가');
    
    byte b = i1.byteValue();
    String s = i1.toString();
    String str = Integer.toHexString(i1);
    
  }
}