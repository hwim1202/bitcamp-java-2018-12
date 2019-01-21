package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Member;
import bitcamp.lms.util.ArrayList;

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
  public void detailMember() {
    int no = promptMemberNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
    Member member = list.get(index);
    
    if (member == null) {
      System.out.println("해당 멤버를 찾을 수 없습니다.");
      return;
    }
    System.out.printf("번호: %d\n", member.getNumber());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getMail());
    System.out.printf("전화: %s\n", member.getPhone());
    System.out.printf("가입일: %s\n", member.getRegisteredDate());
  }
  public void updateMember() {
    int no = promptMemberNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
    Member member = list.get(index);
    
      Member temp = new Member();

      temp.setNumber(member.getNumber());

      System.out.print("이름? ");
      temp.setName(keyboard.nextLine());

      System.out.print("이메일? ");
      temp.setMail(keyboard.nextLine());

      System.out.print("암호?");
      temp.setPassword(keyboard.nextLine());

      System.out.print("사진? ");
      temp.setPhoto(keyboard.nextLine());

      System.out.print("전화? ");
      temp.setPhone(keyboard.nextLine());

      temp.setRegisteredDate(new Date(System.currentTimeMillis()));
      
      list.set(index, temp);

      System.out.println("저장하였습니다.");
  }
  @SuppressWarnings("unused")
  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      Member m = list.get(i);
      if (m.getNumber() == no)
        return i;
    }
    return -1;
  }
  
  public void deleteMember() {
    int no = promptMemberNo();
    int index = indexOf(no);
    if (!validate(index))
      return;
    
    list.remove(index);
    System.out.println("멤버를 삭제했습니다.");
  }


  private boolean validate(int index) {
    if (index == -1) {
      System.out.println("해당 멤버를 찾을 수 없습니다.");
      return false;
    }
    return true;
    
}
  private int promptMemberNo() {
    System.out.print("번호? ");
  return Integer.parseInt(keyboard.nextLine());
  }
  
}
