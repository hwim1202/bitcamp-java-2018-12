// 인스턴스 읽기 - ObjectInputStream 데코레이터 사용
package ch22.e;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import ch15.Student;

public class Test04_2 {

  public static void main(String[] args) {
    
    // score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라.
    // => java.io.BufferedInputStream 클래스를 사용하라.
    // => java.io.DataInputStream 클래스를 사용하라.
    //
    ArrayList<Score> students = new ArrayList<>();
    
    try (ObjectInputStream in = new ObjectInputStream(
          new BufferedInputStream(
          new FileInputStream("score.data")))) {
      
      int len = in.readInt();
      
      for (int i = 0; i < len; i++) {
        Score score = (Score) in.readObject();
        //score.compute();
        students.add(score);
      }
     
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라.
    // =>   홍길동, 100, 100, 100, 300, 100 
    // 
    
    for (Score s : students) {
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
        s.getName(), s.getKor(), s.getEng(), s.getMath(),
        s.getSum(), s.getAver());
    }
  }

}
