package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  public static void main(String[] args) {
    
    try(ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작");
      
      while(true) {
        
        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
          
          System.out.println("클라이언트와 연결되었음");
          
          Object request = in.readObject();
          
          System.out.println(request);
          
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와의 연결을 끊었음");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}
