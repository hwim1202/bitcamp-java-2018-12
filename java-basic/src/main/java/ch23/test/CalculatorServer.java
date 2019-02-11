package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행중");

      while(true) {
        processRequest(serverSocket.accept());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  static void processRequest(Socket socket) {
    BufferedReader in = null;
    PrintStream out = null;

    try {
      in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      out = new PrintStream(socket.getOutputStream());

      while (true) {
        String request = in.readLine();
        if (request.equalsIgnoreCase("quit")) {
          out.println("안녕히가세요");
          out.flush();
          break;
        }

      }
    } catch (Exception e) {
      System.out.println("클라이언트와 통신 중 문제 발생");
      e.printStackTrace();

    }finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }

  static void sendGreeting(PrintStream out) {
    out.println("계산기 서버에 오신 걸 환영합니다!");
    out.println("계산식을 입력하세요!");
    out.println("예) 23 + 7");
    out.println();
  }

  static void calculate(String request, PrintStream out) {

    try {
      String[] input = request.split(" ");

      int a = Integer.parseInt(input[0]);
      String op = input[1];
      int b = Integer.parseInt(input[2]);
      int result = 0;

      switch (op) {
        case "+": result = a + b; break;
        case "-": result = a - b; break;
        case "*": result = a * b; break;
        case "/": result = a / b; break;
        case "%": result = a % b; break;
        default:
          out.printf("%s 연산자를 지원하지 않습니다.\n", op);
          out.flush();
          return;
      }

      out.printf("결과는 %d 입니다.\n", result);
      out.flush();
    } catch (Exception e) {
      try {
        out.println("식의 형식이 잘못되었습니다");
        out.flush();
      } catch (Exception e2) {}
    }
  }

  static boolean isQuit(String request, PrintStream out) {
    if (request.equalsIgnoreCase("quit")) {
      out.println("안녕히가세요");
      out.flush();
      return true;
    }
    return false;

  }
}
