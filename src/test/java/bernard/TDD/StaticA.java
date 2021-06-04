package bernard.TDD;

public class StaticA {

    protected  static  void process() throws Exception {  //worng
        m1();
        m2();
        m3();
    }


    protected static void m1(){
        System.out.println(" M1 ");
    }
    protected static void m2(){
        System.out.println(" M2 ");
    }
    protected static void m3() throws Exception {
        System.out.println(" M3 start ");
        throw new Exception("DB Exception");

    }

}
