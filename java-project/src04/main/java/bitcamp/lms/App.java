/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

public class App {
    public String getGreeting() {
        return "번호: 1\n" + 
            "수업명: 자바 프로젝트 실습\n" + 
            "설명: 자바 프로젝트를 통한 자바 언어 활용법 익히기\n" + 
            "시작일: 2019-01-02\n" + 
            "종료일: 2019-05-28\n" + 
            "총수업시간: 1000 시간\n" + 
            "일수업시간: 8 시간";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
