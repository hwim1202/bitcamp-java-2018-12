
package bitcamp.lms;

public class App {
    public static void main(String[] args) {
            
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      java.util.Date today = new java.util.Date();
      
      System.out.print("번호? ");      
      int 번호 = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.print("수업명? ");
      String 수업명 = keyboard.nextLine();
      
      System.out.print("수업내용? ");
      String 수업내용 = keyboard.nextLine();
      
      System.out.print("시작일? ");
      String 시작일 = keyboard.nextLine();
      
      System.out.print("종료일? ");
      String 종료일 = keyboard.nextLine();
      
      System.out.print("총수업시간? ");
      int 총수업시간 = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.print("일수업시간? ");
      int 일수업시간 = keyboard.nextInt();
      
      keyboard.nextLine();
      
      System.out.printf("번호: %d\n수업명: %s\n수업내용: %s\n기간:%s ~ %s\n총수업시간: %d시간\n일수업시간: %d시간\n", 번호, 수업명, 수업내용, 시작일, 종료일, 총수업시간, 일수업시간);
      
      System.out.printf("가입일: %1$tY년%1$tB%1$td일", today);
    }
}