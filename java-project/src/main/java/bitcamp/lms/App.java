
package bitcamp.lms;

public class App {
    public static void main(String[] args) {
            
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      
      int[] number = new int[10];
      String[] title = new String[10];
      String[] contents = new String[10];
      String[] startDate = new String[10];
      String[] endDate = new String[10];
      int[] totalHours= new int[10];
      int[] dayHours = new int[10];
      
      int i = 0;
      
      
      while (true) {
      
      System.out.print("번호? ");      
      number[i] = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("수업명? ");
      title[i] = keyboard.nextLine();
      
      System.out.print("수업내용? ");
      contents[i] = keyboard.nextLine();
      
      System.out.print("시작일? ");
      startDate[i] = keyboard.nextLine();
      
      System.out.print("종료일? ");
      endDate[i] = keyboard.nextLine();
      
      System.out.print("총수업시간? ");
      totalHours[i] = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("일수업시간? ");
      dayHours[i] = Integer.parseInt(keyboard.nextLine());
      
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
        System.out.printf("%d, %s, %s ~ %s, %d", 
            number[j], title[j], startDate[j], endDate[j], totalHours[j]);
      }
    
    
    }
}