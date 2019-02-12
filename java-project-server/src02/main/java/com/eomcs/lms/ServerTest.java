package com.eomcs.lms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {

  public static void main(String[] args) {
    
    try(Socket socket = new Socket("localhost", 8888)) {
      
      System.out.println("서버와 연결되었음");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음");
  }

}
