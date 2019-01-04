
package bitcamp.lms;

public class App3 {
    public static void main(String[] args) {
            
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      java.util.Date today = new java.util.Date();
      
      System.out.print("번호? ");      
      int 번호 = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.print("내용? ");
      String 내용= keyboard.nextLine();
      
      System.out.printf("번호: %d\n내용: %s\n", 번호, 내용);
      
      System.out.printf("작성일: %1$tY년%1$tB%1$td일", today);
      
      
    }
}