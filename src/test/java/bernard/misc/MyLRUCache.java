package bernard.misc;

import java.util.*;

public class MyLRUCache<K,V> {

    private int capacity;
    private int size;
    //single link list LRU cache;
    //sorted in the order of (most recent used to least recent used )
    // cache size 3 : add (1,A),(2,B),(3,C),(2,D)  --> (2,D),(3,C),(1,A);
    private Node<K,V> head;

    public MyLRUCache(){
        this.capacity=5;
    }

    public MyLRUCache(int capacity){
        this();
        this.capacity=capacity;
    }

    public Node<K,V> put(K key,V value){

        if(head == null){
            Node<K,V>n=new Node<>(key,value);
            head=n;
            incrementSize();
            return n;
        }
        Node<K,V> temp = head;
        Node<K,V> prev = null;
        while( temp != null && !temp.key.equals(key)) {
            prev=temp;
            temp = temp.next;
        }



        if(temp == null && prev != null && isCacheFull()){
            Node<K,V> n=new Node<>(key,value);
            removeEldestElement();
            addElementOnlast(n);
        }
        //key not found , add new element at the end
        if(temp == null && prev != null) {
            Node<K,V>n=new Node<>(key,value);
            System.out.println("key not found adding to the head");

            prev.next=n;
/*           n.next = head; // add not to the begining
            head=n;*/
            incrementSize();
            return n;
        }
        //key matched
        if(temp != null) {
            System.out.println("key matched");
            temp.value=value;
        }
        return null;
    }

    private Node<K,V> removeEldestElement() {
        if(head == null)
            return null;
        Node<K,V> temp= head;
        head=head.next;
        decrementSize();
        return temp;
    }
    private Node<K,V> addElementOnlast(Node<K,V> node) {
        Node<K,V> temp = head;
        Node<K,V> prev = null;
        while( temp != null) {
            prev=temp;
            temp = temp.next;
        }
        prev.next=node;
        incrementSize();
        return temp;
    }

    public Set<V> getValuesSet(){
        Node<K,V> temp = head;
        Set<V> set = new HashSet<>();
        while( temp != null) {
            set.add(temp.value);
            temp = temp.next;
        }
        return set;
    }

    public Set<K> getKeySet(){
        Node<K,V> temp = head;
        Set<K> set = new HashSet<>();
        while( temp != null) {
            set.add(temp.key);
            temp = temp.next;
        }
        return set;
    }

    public List<Node<K,V>> getNodesSet(){
        Node<K,V> temp = head;
        List<Node<K,V>> list = new LinkedList<>();
        while( temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        return list;
    }

    private void incrementSize(){
        size++;
    }
    private void decrementSize(){
        size--;
    }
    private boolean isCacheFull(){
        return size>=capacity;
    }

    @Override
    public String toString() {
        return getNodesSet().toString();
    }

    public int size() {
        return size;
    }

    private static class Node<K,V>{

        private int hash;
        private K key;
        private V value;
        private Node<K,V> next;

        Node(K key,V value){
            this.hash=key.hashCode();
            this.key=key;
            this.value=value;
            this.next=null;
        }

        @Override
        public String toString() {
            return key.toString()+" "+value.toString();
        }

        @Override
        public int hashCode() {
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            return obj.hashCode()==this.hashCode();
        }
    }

}
