package bernard.corejava;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class AssertTest {

    @Test
    public void testAssert(){
        /*
        * Note : finally block will be executed for assertion throw.
        * but no extra line will be execucted in the code.
        *
        * */

        System.out.println("start");
        //method1("buddha");
        try{
            method1(null);
        }
        finally {
            System.out.println("main finally");
        }

        System.out.println("end");
    }

    private void method1(String str) {
        try{

            System.out.println("try 1");
            //assertNotNull(str,"value should not be null");
            Assert.assertNotNull(str);
            System.out.println("try 2");
        }
        catch(Exception e){
            System.out.println("method catch");
        }
        finally {
            System.out.println("method finally");
        }

    }


}
