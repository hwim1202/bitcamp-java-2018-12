
package bitcamp.lms;

import java.sql.Date;

public class App2 {
    public static void main(String[] args) {
            
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      int[] number = new int[10];
      String[] name = new String[10];
      String[] mail = new String[10];
      String[] phone = new String[10];
      Date[] registeredDate= new Date[10];
      
      int i = 0;
      
      
      while (true) {
      
      System.out.print("번호? ");      
      number[i] = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("이름? ");
      name[i] = keyboard.nextLine();
      
      System.out.print("이메일? ");
      mail[i] = keyboard.nextLine();
      
      System.out.print("전화? ");
      phone[i] = keyboard.nextLine();
      
      System.out.print("가입일? ");
      registeredDate[i] = Date.valueOf(keyboard.nextLine());
      
      i++;
      
      System.out.print("계속 하시겠습니까? (y/n)");
      String response = keyboard.nextLine();
      
      if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase(""))
        continue;
      
      if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase(""))
        break;
      
      keyboard.close();
       
         }
      for (int j = 0; j < i; j++) {        
        System.out.printf("%d, %s, %s, %s, %s", 
            number[j], name[j], mail[j], phone[j], registeredDate[j]);
      }
    
    
    }
}