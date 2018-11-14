package bernard.corejava;

public class TestException {


    public static void main(String[] args) {
        int i =10;
        Integer i2=i;//auto boxing

        i=i2; // auto unboxing

        Float f =11f;
        float f2=10.02f;
        //i=f;
    }



    static class A{

        public int add(Integer a1,Integer a2){
            return 0;
        }

        public void proces(String str,String str2){

        }




    }
    static class B extends A{

         public int add(Integer a1,Integer a2){
            return 0;
        }

        public void proces(String str,String str2){

        }
    }
}
