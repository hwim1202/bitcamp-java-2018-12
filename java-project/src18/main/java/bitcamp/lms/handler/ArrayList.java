package bitcamp.lms.handler;

import java.util.Arrays;

public class ArrayList<E> {
  static final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;
  
  
  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
  }
  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] sampleArr) {
    return (E[]) Arrays.copyOf(list,size, sampleArr.getClass());
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