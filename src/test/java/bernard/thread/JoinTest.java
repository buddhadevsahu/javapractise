package bernard.thread;

import org.junit.Test;

public class JoinTest {

    @Test
    public void testMultipleJoinAndStart() throws InterruptedException {

        System.out.println("started ");
        //Thread t = new Thread(()-> System.out.println("thread is started"));
        Thread t = new Thread(new MyRunnable1());
        System.out.println("state "+t.getState());
        Thread.UncaughtExceptionHandler eh = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("there is an exception in the thread, please handle it");
                System.out.println("exception "+e.getMessage());
            }
        };
        t.setUncaughtExceptionHandler(eh);
        t.start();
        System.out.println("state "+t.getState());
        t.join();
        System.out.println("state "+t.getState());
        Thread.UncaughtExceptionHandler value = t.getUncaughtExceptionHandler();
        System.out.println("value  "+ value);
        //t.start();
        //t.join();
        System.out.println("ended ");

    }

    @Test
    public void testSequencialThreadExecution() throws InterruptedException {

        Thread t1 = new Thread(()->{
            System.out.println("thread 1 started");
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 2 started");
        });

        Thread t3 = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 3 started");
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }



    static class MyRunnable1 implements Runnable {
        @Override
        public void run() {
            System.out.println("thread started");
           int result=1/0;
            System.out.println("thread exception "+result);
        }
    }





}
