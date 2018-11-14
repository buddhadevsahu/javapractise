package bernard.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

public class DQueueProducerConsumer {

    public static void main(String[] args) {

        Queue<String> dqueue = new ArrayDeque<>();
        MyProducer p1=new MyProducer(dqueue,"Producer");
        MyProducer p2=new MyProducer(dqueue,"Producer");
        System.out.println(p1.equals(p2));//content --> memoryaddress
        System.out.println(p1.toString()+"  "+p2.toString());//content --> memoryaddress
        new MyConsumer(dqueue,"Consumer");
/*        Thread producer= new Thread(
                new MyProducer(dqueue,"Producer"));*/


    }

    private static class MyProducer implements Runnable{
        Queue<String> queue;
        String name;
        public MyProducer(Queue<String> dqueue, String name) {

            this.queue=dqueue;
            this.name=name;
            new Thread(this).start();
        }

        @Override
        public void run() {

            for(int i =0 ; i< 100 ; i++){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //queue.add("value"+i); //throws exception if not possible
                queue.offer("value"+i); // don't throws exception
                System.out.println(name+" : "+"value"+i);
            }

        }
    }

    private static class MyConsumer implements Runnable{
        Queue<String> queue;
        String name;
        public MyConsumer(Queue<String> dqueue, String name) {
            this.queue=dqueue;
            this.name=name;
            new Thread(this).start();
        }

        @Override
        public void run() {

            for(int i =0 ; i< 100 ; i++){
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String str = queue.poll(); // return null if empty

                System.out.println(name+"  : "+str);
                //String str1 = queue.remove(); // NoSuchElementException if this queue is emptys
            }

        }
    }
}
