
package bitcamp.lms;

public class App2 {
    public static void main(String[] args) {
            
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      java.util.Date today = new java.util.Date();
      
      System.out.print("번호? ");      
      int 번호 = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.print("이름? ");
      String 이름= keyboard.nextLine();
      
      System.out.print("이메일? ");
      String 이메일 = keyboard.nextLine();
      
      System.out.print("암호? ");
      int 암호 = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.print("사진? ");
      String 사진 = keyboard.nextLine();
      
      System.out.print("전화? ");
      String 전화 = keyboard.nextLine();
      
      
      System.out.printf("번호: %d\n이름: %s\n이메일: %s\n암호: %d\n사진: %s\n전화: %s\n", 번호, 이름, 이메일, 암호, 사진, 전화);
      
      System.out.printf("가입일: %1$tY년%1$tB1%1$td일\n", today);
      
      System.out.printf("조회수: 0");
      
      
    }
}