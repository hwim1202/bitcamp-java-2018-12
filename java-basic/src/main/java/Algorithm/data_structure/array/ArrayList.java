package Algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {

  static final int DEFAULT_SIZE = 5;

  Object[] arr;
  int size;

  public ArrayList() {

    this(0);
  }

  public Object[] toArray() {
    Object[] list = new Object[this.size];
    for ( int i = 0; i < this.size; i++) {
      list[i]= this.arr[i];
    }
    return list;
  }

  public ArrayList(int capacity) {
    if (capacity > DEFAULT_SIZE)
      arr = new Object[capacity];
    else
      arr = new Object[DEFAULT_SIZE];
  }

  public void add(Object value) {
    if( arr.length == size) {
      increase();
      }
    arr[size++] = value;
  }

  public void insert(int index, Object value) {
    if ( index < 0 || index >= size ) {
      return;
    }
    else if( arr.length <= size) {
      increase();
    }
    for (int i = size -1; i >= index ; i--) {
      arr[i] = arr[i + 1];
    }
    size++;
    
    arr[index] = value;
  }

  public Object get(int index) {
    if ( index < 0 || index >= size )
      return null;
    return arr[index];

  }

  public Object set(int index, Object value) {
    if ( index < 0 || index >= size )
      return null;

    Object old = arr[index];
    
    arr[index] = value;

    return old;
    
    
  }

  public Object remove(int index) {
    if ( index < 0 || index >= size )
      return null;

    Object old = arr[index];

    for (int i = index; i < size - 1; i++)
      arr[i] = arr[i + 1];

    size--;

    return old;
  }

  public int size() {

    return this.size;
  }
  private void increase() {
    int oldCapacity = arr.length;
    int newCapacity = oldCapacity + ( oldCapacity >> 1) ;
    arr = Arrays.copyOf(arr, newCapacity);
    
  }
}
