package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Member;

public class MemberHandler {

  Scanner keyboard;
  Member[] Members = new Member[10];
  int i = 0;
  
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void addMember() {
    Member mem = new Member();
    
    Members[i] = mem;

    System.out.print("번호? ");      
    mem.number = Integer.parseInt(keyboard.nextLine());

    System.out.print("이름? ");
    mem.name = keyboard.nextLine();

    System.out.print("이메일? ");
    mem.mail = keyboard.nextLine();

    System.out.print("암호?");
    mem.password = keyboard.nextLine();

    System.out.print("사진? ");
    mem.photo = keyboard.nextLine();

    System.out.print("전화? ");
    mem.phone = keyboard.nextLine();

    mem.registeredDate = new Date(System.currentTimeMillis());

    System.out.println("저장하였습니다.");
    
    i++;
  }
  public void listMember() {
    for (int j = 0; j < i; j++) {        
      System.out.printf("%d, %s, %s, %s, %s\n", 
          Members[j].number, Members[j].name, Members[j].mail, Members[j].phone, Members[j].registeredDate);
    }
  }


}
