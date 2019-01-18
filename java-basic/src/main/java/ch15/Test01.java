package ch15;

class My1 {
  
}

public class Test01 {
  public static void main(String[] args) {
    
    My1 obj = new My1();
    
    System.out.println(obj instanceof My1);
    System.out.println(obj instanceof Object);
    
    System.out.println(obj.toString());
    System.out.println(obj.hashCode());
    System.out.println(obj.equals("Hello"));
    
  }

}
