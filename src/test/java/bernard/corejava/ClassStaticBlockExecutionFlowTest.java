package bernard.corejava;

import org.junit.Test;

public class ClassStaticBlockExecutionFlowTest {
    /*
     *
     *
     * 1nd : static block of all the class while loading
     * 2st : initialization block parent
     * 3rd: parent constructor
     * 4th : initialization block child
     * 5th : current class constructor
     *
     * below example:
     *  1st : A static block
        2nd : B static block
        3rd : A initialize block
        4th : A constructor
        5th : B initialize block
        6th : B constructor
     *
     * */
    @Test
    public void test() {

            B b = new B();

    }


    static class A {
        static {
            System.out.println(" A static block ");
        }

        {
            System.out.println(" A initialize block");
        }

        A() {
            System.out.println("A constructor ");
        }
    }
    static class B  extends A{
        static {
            System.out.println(" B static block ");
        }

        {
            System.out.println(" B initialize block");
        }

        B() {
            System.out.println("B constructor ");
        }
    }


}
