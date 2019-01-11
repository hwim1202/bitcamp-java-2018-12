package bitcamp.lms;

import java.sql.Date;

public class MemberHandler {

  static java.util.Scanner keyboard = new java.util.Scanner(System.in);

  final static int LENGTH = 10;

  static Member[] Members = new Member[LENGTH];

  static int i = 0;
  static int j = 0;

  static void addMember() {

    Member mem = new Member();
    Members[i] = mem;
    i++;

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
  }
  static void listMember() {
    for (int j = 0; j < i; j++) {        
      System.out.printf("%d, %s, %s, %s, %s\n", 
          Members[j].number, Members[j].name, Members[j].mail, Members[j].phone, Members[j].registeredDate);
    }
  }
}
