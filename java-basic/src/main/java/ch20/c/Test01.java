package ch20.c;

import java.util.HashSet;
import java.util.Iterator;

public class Test01 {

  public static void main(String[] args) {
    HashSet<String> set = new HashSet<>();
    set.add("aaa");
    set.add("bbb");
    set.add("ccc");
    //set은 집합의 특성상 값의 중복x
    set.add("aaa");
    set.add("bbb");
    //null을 넣을수 있지만 역시나 중복x
    set.add(null);
    set.add(null);


    Iterator<String> iterator = set.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());

    }

    //hashCode()를 이용해 저장하므로 순서대로 꺼낼수 없다.

    System.out.println("-------------------------");

    Object[] values = set.toArray();
    for (Object value : values) {
      System.out.println(value);
    }

    System.out.println("-------------------------");

    String[] temp = new String[0];
    String[] values2 = set.toArray(new String[0]);
    System.out.println(temp == values2);
    for (String value : values2) {
      System.out.println(value);
    }

    System.out.println("-------------------------");

    String[] values3 = new String[set.size()];
    String[] values4 = set.toArray(values3);
    System.out.println(values3 == values4);
    set.toArray(values3);
    for (String value : values3) {
      System.out.println(value);
    }
  }
}
