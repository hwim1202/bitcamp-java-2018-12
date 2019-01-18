
package bitcamp.lms;

import java.sql.Date;

public class App3 {
    public static void main(String[] args) {
            
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      int[] number = new int[10];
      String[] contents = new String[10];
      Date[] createdDate = new Date[10];
      int[] viewCount = new int[10];
      
      int i = 0;
      
      
      while (true) {
      
      System.out.print("번호? ");      
      number[i] = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("내용? ");
      contents[i] = keyboard.nextLine();
      
      createdDate[i] = new Date(System.currentTimeMillis());
      
      viewCount[i] = 0;
      
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
        System.out.printf("%d, %s, 작성일: %s, 조회수: %s", 
            number[j], contents[j], createdDate[j], viewCount[j]);
      }
    
    
    }
}