package bernard.collections;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrenceHashMapTest {

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>(100,0.75f,2);

        new Thread(new MyThreadWriter(map,"TH-1")).start();
        new Thread(new MyThreadWriter(map,"TH-2")).start();
        new Thread(new MyThreadReader(map,"TH-3")).start();


    }


    static class MyThreadWriter implements Runnable{

        private String threadName;
        private Map<String,String> map;
        MyThreadWriter(Map<String,String> map, String threadName){
            this.map=map;
            this.threadName = threadName;

        }

        @Override
        public void run() {

            for(int i = 0; i < 30;i++){
                //int ran = new Random().nextInt(1000);
                int ran =i;
                map.put("key"+ran,threadName+"_value_"+ran);
                System.out.println(threadName+" : add : "+"key : "+ran+" value :"+threadName+"_value_"+ran);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadReader implements Runnable{

        private String threadName;
        private Map<String,String> map;
        MyThreadReader(Map<String,String> map, String threadName){
            this.map=map;
            this.threadName = threadName;

        }

        @Override
        public void run() {
            for(int i = 0; i < 20;i++){
                int ran = new Random().nextInt(100);
                String value = map.get("key"+ran);
                System.out.println(threadName+" : get(key"+ran+") : "+value);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
