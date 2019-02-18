package ch24.b;

public class Test07 {

  public static void main(String[] args) {

    // 스레드의 우선 순위는 1 ~ 10까지 이다.
    // 기본 우선순위는 5이다.

    Thread mainThread = Thread.currentThread();
    System.out.println(mainThread.getPriority());
  }
}