package ch20.d;

import java.util.HashMap;

public class Test01 {

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
    
    map.put("aaa", new Student("홍길동", 20));
    map.put("bbb", new Student("임꺽정", 30));
    map.put("ccc", new Student("유관순", 16));
    map.put("ccc", new Student("안중근", 25));
    
    System.out.println(map.get("bbb"));
    System.out.println(map.get("ccc"));
    
    
    String key1 = "bbb";
    String key2 = new String ("bbb");
    
    System.out.println(key1 == key2);
    System.out.println(key1.hashCode() == key2.hashCode());
    System.out.println(key1.equals(key2));
    
    System.out.println(map.get(key2));
  }

}
