package ch20.d;

import java.util.HashMap;
import java.util.Hashtable;

public class Test02 {

  public static void main(String[] args) {
    class Student {
      String name;
      int age;

      public Student(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
      }
    }

    HashMap<String, Student> map = new HashMap<>();
    Hashtable<String, Student> table = new Hashtable<>();

    map.put("aaa", new Student("홍길동", 20));
    table.put("aaa", new Student("홍길동", 20));

    System.out.println(map.get("aaa"));
    System.out.println(table.get("aaa"));

    System.out.println("------------------------------");

    map.put(null, new Student("임꺽정", 30));
    System.out.println(map.get(null));

    // Hashtable은 null을 key값으로 사용x
    //    table.put(null, new Student("임꺽정", 30));
    //    System.out.println(table.get(null));

    map.put("ccc", null);
    System.out.println(map.get("ccc"));

    // Hashtable은 null을 value값으로 사용x
    //    table.put("ccc", null);
  }

}
