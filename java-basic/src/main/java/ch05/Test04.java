package ch05;
public class Test04 {
  public static void main(String[] args) {
    
    byte b = 1;
    short s = 2;
    char c = 1;
    int i = 1;
    long l= 1L;
    float f = 1.0f;
    double d = 1.0;
    
    switch(s) {
      case 1:
        System.out.println("11");
        System.out.println("1111");
        break;
      case 2:
        System.out.println("22");
        System.out.println("2222");
        break;
        default:
          System.out.println("33");
          System.out.println("3333");
    }
  }
}