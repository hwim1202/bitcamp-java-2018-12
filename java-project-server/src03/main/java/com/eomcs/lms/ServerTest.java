package com.eomcs.lms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class ServerTest {

  public static void main(String[] args) {
    
    try(Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {
      
      System.out.println("서버와 연결되었음");
      
      Member member = new Member();
      member.setNo(1);
      member.setName("홍길동");
      member.setEmail("hong@test.com");
      member.setPassword("1111");
      member.setPhoto("hong.gif");
      member.setTel("1111-1111");
      
      out.println("Hello");
      out.flush();
      
      System.out.println(in.nextLine());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음");
  }

}
