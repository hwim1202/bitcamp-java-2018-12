// Stateful 클라이언트
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient2 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    // 서버에 먼저 연결한다.
    // 연결을 끊을 때까지 요청/응답을 반복할 수 있다.
    // => 매번 요청할 때마다 서버와 연결할 필요가 없기 때문에 stateless 방식에 비해 
    //    요청처리 시간이 적게 걸린다.
    // => 대신 서버쪽에는 클라이언트 연결 정보를 계속 유지해야 하기 때문에 
    //    메모리를 일정부분 지속적으로 점유한다.
    // 
    try (Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()))) {
    
      System.out.println("서버와 연결됨!");

      while (true) {
        System.out.print("> ");
        String input = keyboard.nextLine();

        out.println(input);
        out.flush();
        
        System.out.println("서버에게 계산 작업을 요청함!");

        String response = in.readLine();
        System.out.println(response);

        if (input.equalsIgnoreCase("quit"))
          break;
      } // while
    
      System.out.println("서버와 연결 끊음!");

    } catch (Exception e) {
      e.printStackTrace();
    }
    
    keyboard.close();
  }
}











