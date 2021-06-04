package bernard.collections;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    @Test
    public void testLinkedListGrowing(){

        List<String> list = new LinkedList<>();
        /*
        * E  e; value
        * Node<E> first;   //last pointer
        * Node<E> last;    //first pointer
        *
        *
        *
        *
        *
        * */

        list.add("one");
        list.add("two");
        list.add("three");

        list.add(null);
        list.add(null);
        list.add(null);

        list.add("four");

        System.out.println(" 1st remove :"+((LinkedList<String>) list).remove());
        System.out.println(" 2nd remove :"+((LinkedList<String>) list).remove());
        System.out.println(" 3rd remove :"+((LinkedList<String>) list).remove(null));
        System.out.println(list.toString());



    }

    @Test
    public void testQueueOperation(){

        /*
         *      add() :
         *      remove()  : remove from head / nosuchElement exception
         *      element() : getFirst()    get head element / nosuchelemntException if empty
         *
         *
         *      offer() : add element in the last
         *      `   offerFirst()
         *          offerLast()
         *      pop()   : = removeFirst()
         *      poll()  :   Retrieves and removes the head (first element) of this list. / null if empty
         *          pollFirst()
         *          pollLast()
         *
         *      peek: return top element on queue
         *          peekFirst() : return head
         *          peekLast()  : return tail
         *
         *
         *
         *
         *
         */

        LinkedList<String> queue = new LinkedList<>();

        queue.offer("Five");  //add element in last
        System.out.println(queue.toString());
        queue.offer("Six");  //add element in last
        System.out.println(queue.toString());
        queue.offer("seven");  //add element in last
        System.out.println(queue.toString());
        String value = queue.poll();
        System.out.println(" polled value : "+value);

    }
}
