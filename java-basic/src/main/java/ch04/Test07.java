package ch04;

public class Test07 {
    public static void main(String[] args) {
      
      float f1 = 0.1f;
      float f2 = 0.1f;
      System.out.println(f1 * f2 == 0.01f);
      
      float r = f1 * f2 - 0.01f;
      System.out.println(Math.abs(r) <= Float.POSITIVE_INFINITY);
      
      int[] a ;
      a = new int[10] ;
       
      
    }
}