package bernard.Concurrency;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args){
       ArrayBlockingQueue<String> queue =  new ArrayBlockingQueue<>(10);
       //BlockingQueue<String> queue =  new BlockingQueue<>(10);

        produceName(queue);
        consume(queue,"thread1");
        consume(queue,"thread2");
    }

    static void consume(ArrayBlockingQueue<String> queue, String name) {
        new Thread(()-> {
            while (true){
                //if(queue.size()>0) {
                    try {
                        System.out.println(name+" : "+queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            //}
        }).start();
//
    }

    static void produceName(ArrayBlockingQueue<String> queue) {

        new Thread(()-> {
            for (int i =0 ; i < 10 ; i ++){
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    queue.put("Value "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
