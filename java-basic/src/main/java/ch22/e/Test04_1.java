// 인스턴스 출력하기 - ObjectOutputStream 데코레이터  사용 
package ch22.e;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test04_1 {

  public static void main(String[] args) {

    // 다음 세 학생의 성적 정보를 score.data 파일에 바이너리 형식으로 저장하라!
    // => java.io.BufferedOutputStream 클래스를 사용하라.
    // => java.io.DataOutputStream 클래스를 사용하라.
    //
    ArrayList<Score> students = new ArrayList<>();
    students.add(new Score("홍길동", 100, 100, 100));
    students.add(new Score("임꺽정", 90, 90, 90));
    students.add(new Score("유관순", 80, 80, 80));

    try ( ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("score.data")))) {

      out.writeInt(students.size());

      for (Score s : students) {
        out.writeObject(s);
      }

      out.flush();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료!");
  }

}






