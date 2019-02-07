// String 읽기 - BufferedReader 붙이기
package ch22.d;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test03_2 {

  public static void main(String[] args) {
    
    // FileReader
    // => 문자 단위로 데이터를 읽는 일을 한다.
    //
    try (FileReader in = new FileReader("data.txt");
        BufferedReader in2 = new BufferedReader(in)) {

      System.out.println(in2.readLine());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("출력 완료!");
  }

}
