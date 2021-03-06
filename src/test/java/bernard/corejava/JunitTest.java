package bernard.corejava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JunitTest {

    static List<String> list1= new ArrayList();
    static List<String> list2= new ArrayList();
    {
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");

        list2.add("one");
        list2.add("two");
        list2.add("thre");
        list2.add("four");
    }

    @Test
    public void  testList(){
        //Assertions.assertEquals(list1,list2);
        assertEquals(list1,list2);

    }

    @Test
    public void testWelcomeWhenStringInputNull(){
        try {
            assertEquals(null, welcome(null));
        }catch (Exception e){
            System.out.println("vvvv"+e.getMessage());
        }
    }

    public static String welcome (String str) throws Exception {
        if(null==str){
            throw new Exception("Invalid Input");
        }
        if(str.equalsIgnoreCase("ram"))
            throw new Exception(" not allowed");

        return "Hi "+str;

    }



}
