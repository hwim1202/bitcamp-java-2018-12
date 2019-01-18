package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Member;

public class MemberHandler {

  Scanner keyboard;
  ArrayList<Member> list;
  
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new ArrayList<>();
  }
  
  public void listMember() {
  Member[] members = list.toArray(new Member[10]);
  for (Member member : members) {
      System.out.printf("번호: %d, 이름: %s, 이메일: %s, 전화: %s, 가입일: %s\n", 
          member.getNumber(), member.getName(), member.getMail(), member.getPhone(), member.getRegisteredDate());
    }
  }

  public void addMember() {
    Member mem = new Member();

    System.out.print("번호? ");      
    mem.setNumber(Integer.parseInt(keyboard.nextLine()));

    System.out.print("이름? ");
    mem.setName(keyboard.nextLine());

    System.out.print("이메일? ");
    mem.setMail(keyboard.nextLine());

    System.out.print("암호?");
    mem.setPassword(keyboard.nextLine());

    System.out.print("사진? ");
    mem.setPhoto(keyboard.nextLine());

    System.out.print("전화? ");
    mem.setPhone(keyboard.nextLine());

    mem.setRegisteredDate(new Date(System.currentTimeMillis()));
    
    list.add(mem);

    System.out.println("저장하였습니다.");
  }
}
