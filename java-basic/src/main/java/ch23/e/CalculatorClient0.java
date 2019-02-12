// Stateless 클라이언트 만들기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient0 {
  public static void main(String[] args) {
    
    int id = Integer.parseInt(args[0]);
    
    Scanner keyboard = new Scanner(System.in);
    
    while (true) {
      System.out.print("> ");
      String input = keyboard.nextLine();

      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()))) {
        
        out.println(id);
        out.flush();
        
        System.out.println("서버와 연결됨! 서버에게 계산 작업을 요청함!");
        
        out.println(input);
        out.flush();
        
        if (input.equalsIgnoreCase("quit"))
          break;

        String response = in.readLine();
        System.out.println(response);

      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("서버와 연결 끊음!");
      
    } // while
    
    keyboard.close();
  }
}











