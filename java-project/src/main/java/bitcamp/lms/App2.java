/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

public class App2 {
    public String getGreeting() {
        return "번호: 1\n" + 
            "이름: 홍길동\n" + 
            "이메일: hong@test.com\n" + 
            "암호: 1111\n" + 
            "사진: hong.png\n" + 
            "전화: 1111-2222\n" + 
            "가입일: 2019-01-01\n";
        
    }

    public static void main(String[] args) {
        System.out.println(new App2().getGreeting());
    }
}
