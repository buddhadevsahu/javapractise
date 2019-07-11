package bernard.corejava;

public class Inheritance {

    public static void main(String[] args){

     /*   A a = new A();
        A a2 = new A();
        B b = null;
        B b1= new B();

        b=(B) a;
        a2=b1;*/

     for(int i=0;i < 5; i++){
         System.out.println(" i "+i);
         if(i==3){
             break;
         }
     }

    }



    static class A{

    }   static class B extends A{

    }


}
