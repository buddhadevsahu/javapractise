package bernard.corejava;

import org.junit.Test;

import java.util.List;

public class OverloadingTest {

    /**
     * Note : While overloading
     * 1) overloading method must have different type or different number of argument.
     * 2)If the argement is typed reference of same class then it is not allowed. this is
     *      due to erasure consept
     *      e.g argement : List<String> and List<Integer>
     *
     * 3) Overloading princile don't depend upon return type. what ever it may be so.
     * it will on method parameter type and no of argements.
     *
     *  5) If the overloading methods  have different type argument of unrelated class
     *       Ambiguity error will be thrown by compiler.
     *         e.g   public void method(String str)
     *               Public void method(Integer ob)// compilation success
     *               but
     *               method(null); // compiler error in ambiguty error.
     *
     *  6)If Overloading methods have argument of inherelted class and null is passed as
     *  argement  than compiler will call the method withh most child class in the hierarchy
     *      e.g   public void method(String str)
     *            Public void method(Object ob)//
     *
     *            method(null) //method(string str) will be called.
     *
     *
     *
     *
     * */


/*    public void methods(List<String> list){// wil not compile erasure consept

    }*/

    public void methods(List<Integer> list){

    }

    public void m1(Object o){
        System.out.println("object");
    }

    public void m1(String o){
        System.out.println("String");
    }

/*    public Integer m1(String o){ // compilation error already exist
        System.out.println("integer return");
        return 1;
    }*/

/*    public void m1(Integer o){
       System.out.println("Integer");
    }*/


    public String m2(String str){
        return "";
    }

    public Integer m2(String str,String str2){
        return 1;
    }


    @Test
    public void test(){
        m1(null);
        m1("string value");
        m1((Object) "string value");
    }




}
