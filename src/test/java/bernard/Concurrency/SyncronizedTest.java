package bernard.Concurrency;

import org.junit.Test;

import java.util.Date;

public class SyncronizedTest {

    @Test
    public void  testSyncronized() throws InterruptedException {
        /**
         * Note : if there are multiple non-static syncronized and static syncronized method in a class.
         *
         * static syncronized lock / class lock don't interfere with instance lock/ non-static syncronized
         * means : both can work independently and work parallel
         *
         *
         */
        A a = new A();
/*        Thread t1=new Thread(new MyThread(a,"m1",1000));
        Thread t2=new Thread(new MyThread(a,"m2",2000));*/
        Thread t3=new Thread(new MyThread(a,"m3",5000));
        Thread t4=new Thread(new MyThread(a,"m4",5000));
        Thread t5=new Thread(new MyThread(a,"m5",3000));
        Thread t6=new Thread(new MyThread(a,"m6",3000));
/*        Thread t7=new Thread(new MyThread(a,"m7",7000));
        Thread t8=new Thread(new MyThread(a,"m8",8000));*/

        System.out.println("current time "+new Date().toString());

/*        t1.start();
        t2.start();*/
        t3.start();
        t4.start();
        t5.start();
        t6.start();
/*        t7.start();
        t8.start();*/

/*        t1.join();
        t2.join();*/
        t3.join();
        t4.join();
        t5.join();
        t6.join();
/*        t7.join();
        t8.join();*/
    }

    static class MyThread implements Runnable{

        private A a;
        private String method;
        private long sleepTime;
        public MyThread(A a,String m,long sleepTime){
            this.a=a;
            this.method=m;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            try {
                    switch (method) {
                        case "m1":
                            a.m1(sleepTime);
                            break;
                        case "m2":
                            a.m2(sleepTime);
                            break;
                        case "m3":
                            a.m3(sleepTime);
                            break;
                        case "m4":
                            a.m4(sleepTime);
                            break;
                        case "m5":
                            a.m5(sleepTime);
                            break;
                        case "m6":
                            a.m6(sleepTime);
                            break;
                        case "m7":
                            a.m7(sleepTime);
                            break;
                        case "m8":
                            a.m8(sleepTime);
                            break;
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class A{

        public  void m1(long l) throws InterruptedException {
            Thread.sleep(l);
            System.out.println(l+" mili sec void m1= "+new Date().toString());
        }
        public static void m2(long l) throws InterruptedException {
            Thread.sleep(l);
            System.out.println(l+" mili sec static void m2 = "+new Date().toString());
        }
        public static synchronized void m3(long l) throws InterruptedException {
            Thread.sleep(l);
            System.out.println(l+" mili sec static synchronized void m3 = "+new Date().toString());
        }
        public static synchronized void m4(long l) throws InterruptedException {
            Thread.sleep(l);
            System.out.println(l+" mili sec static synchronized void m4 = "+new Date().toString());
        }
        public synchronized void m5(long l) throws InterruptedException {
            Thread.sleep(l);
            System.out.println(l+" mili sec synchronized void m5 = "+new Date().toString());
        }
        public synchronized void m6(long l) throws InterruptedException {
            Thread.sleep(l);
            System.out.println(l+" mili sec synchronized void m6 = "+new Date().toString());
        }
        public void m7(long l) throws InterruptedException {
            synchronized (this) {
                Thread.sleep(l);
                System.out.println(l+" mili sec void m7 synchronized block = "+new Date().toString());
            }
        }
        public void m8(long l) throws InterruptedException {
            synchronized (this) {
                Thread.sleep(l);
                System.out.println(l+" mili sec void m8 synchronized block  = "+new Date().toString());
            }
        }
    }

}

