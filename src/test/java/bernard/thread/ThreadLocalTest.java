package bernard.thread;

public class ThreadLocalTest {


    public static void  main(String[] args){

        Thread th1 = new Thread(new MyRunnable(100,"TH1"));
        Thread th2 = new Thread(new MyRunnable(200,"TH2"));
        Thread th3 = new Thread(new MyRunnable(300,"TH3"));
        Thread th4 = new Thread(new MyRunnable(400,"TH4"));

        DBMSAccessHelper.setTenantId((long)1000);
        th1.start();
        th2.start();
        th3.start();
        th4.start();

        try {

            System.out.println("main thread local : "+DBMSAccessHelper.getTenantId());
            th1.join();
            th2.join();
            th3.join();
            th4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("program completed");
    }






    static class MyRunnable implements Runnable{

        private int offset;
        private String  name;

        public MyRunnable(int offset, String name) {
            this.offset = offset;
            this.name = name;
        }

        @Override
        public void run() {

            for (int i =offset; i < offset+10 ; i++){

                System.out.println(" name : "+name+" ("+i+","+DBMSAccessHelper.getTenantId());

                if(i == (offset+5)){
                    DBMSAccessHelper.setTenantId((long)offset+5);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }



    static class DBMSAccessHelper{

        private int id;
        private static ThreadLocal<Long> tenantId = new ThreadLocal<>();
        private String name;
        {
            System.out.println("DBMSAccessHelper initialized");
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static Long getTenantId() {
            return tenantId.get();
        }

        public static void setTenantId(Long id) {
            tenantId.set(id);
            System.out.println("local thread setting done  to "+id);

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
