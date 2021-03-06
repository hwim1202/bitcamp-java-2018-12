package bitcamp.lms.handler;

import java.util.Arrays;

public class ArrayList<E>{
  
  static final int DEFAULT_CAPACITY = 10;
  E[] list;
  int size = 0;
  
  public ArrayList(E[] arr) {
    list = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(E[] arr, int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[DEFAULT_CAPACITY];
    else
      list = new Object[DEFAULT_CAPACITY];
  }
  
  public E[] toArray() {
    return Arrays.copyOf(list,size);
  }
  
  public void add(E obj) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
    
    list[size++] = obj;
    
  }
}