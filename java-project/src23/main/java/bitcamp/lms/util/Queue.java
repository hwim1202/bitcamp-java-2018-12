// 제네릭 적용
package bitcamp.lms.util;

// Queue가 보관하는 데이터 타입을 E 라고 가정하자.
// => E라고 가정한 상태에서 코드를 작성한다.
// 
public class Queue<E> extends LinkedList<E> implements Cloneable{

  public void offer(E value) {
    this.add(value);
  }

  public E poll() {
    return this.remove(0);
  }

  public boolean empty() {
    return this.size == 0;
  }
  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    //return (Queue<E>) super.clone();
    Queue<E> temp = new Queue<>();
    for ( int i=0; i<this.size(); i++) {
      temp.add(this.get(i));
    }
    return temp;
  }
}

