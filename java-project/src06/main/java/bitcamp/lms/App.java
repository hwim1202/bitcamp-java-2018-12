
package bitcamp.lms;

import java.sql.Date;

public class App {
  public static void main(String[] args) {

    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    int[] number = new int[10];
    String[] title = new String[10];
    String[] contents = new String[10];
    Date[] startDate = new Date[10];
    Date[] endDate = new Date[10];
    int[] totalHours= new int[10];
    int[] dayHours = new int[10];

    int i = 0;

    while (i < 10) {

      System.out.print("번호? ");      
      number[i] = Integer.parseInt(keyboard.nextLine());

      System.out.print("수업명? ");
      title[i] = keyboard.nextLine();

      System.out.print("수업내용? ");
      contents[i] = keyboard.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboard.nextLine());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboard.nextLine());

      System.out.print("총수업시간? ");
      totalHours[i] = Integer.parseInt(keyboard.nextLine());

      System.out.print("일수업시간? ");
      dayHours[i] = Integer.parseInt(keyboard.nextLine());

      i++;

      System.out.print("\n계속 하시겠습니까? (Y/n) ");
      String response = keyboard.nextLine();

      if (response.equalsIgnoreCase("y") || response.equals(""))
        continue;

      if (!response.equalsIgnoreCase("y") && !response.equals(""))
        break;
    }

    keyboard.close();

    int j = 0;
    
    while (j < i) {        
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          number[j], title[j], startDate[j], endDate[j], totalHours[j]);
      j++;
    }

  }
}