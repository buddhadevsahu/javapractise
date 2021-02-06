package bernard.corejava;

import org.junit.Test;

public class OverRidingTest {
/*
* Note: while overloading
* 1)child overriding method should not have more restricted acess specifier.
* 2)child overriding method should not have more broder exception in throw
* 3) that means it should have no exception in throw or same or child classes exception of
*   overridden method.
* 4)In method overridding co-class ( subclass of parent class) is allowed in the return type.
 *      e.g    B is child class of A. C  is unrelated class
 *      public A method1(String str)
 *
 *      Public B method1(String str) // correct and allowed.
 *      Public C method1(String str) // not allowed as incompatible class
*
*
* */
    public static void main(String[] args){

     /*   A a = new A();
        A a2 = new A();
        B b = null;
        B b1= new B();

        b=(B) a;
        a2=b1;*/

/*     for(int i=0;i < 5; i++){
         System.out.println(" i "+i);
         if(i==3){
             break;
         }
     }*/



    }

    @Test
    void testOverloading(){


        B b= new B();
        b.method(new String("bunu"));
        b.method(b);
    }



    static class A{
        String x="abc";
        public void method(String name){
            System.out.println("parent String");
        }

        public void method(Object obj) throws RuntimeException
        {
            System.out.println("parent object");
        }

        public Object method2(){
            return "Object";
        }

        public Long method3(){
            return 0l;
        }
    }


    static class B extends A{
        String x="abc";
        /*protected*/ public void method(String str) /*throws Exception*/{
            System.out.println("child String");
        }

        public String method2(){
            return "Object";
        }
/*        public Integer method3(){  // compilation error of return type incompatible
            return 1;
        }*/
    }


}
