package bernard.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayList {




    @Test
    public void testArrayList(){

        // Constructs an empty list
        java.util.ArrayList<String> list = new java.util.ArrayList<>();

        //increase capacity to 10 and added 1st element , size =1
        list.add("one");

        //when ( elementdata.length == size )
        // newcapacity = oldcapacity + (oldcapacity/2)
        //      oc=0     0+(0/2) ==0 ==> default = 10
        //      oc=10     10+(10/2) = 15
        //      oc=15     15+(15/2) = 22


        list.add("two");
        list.add("three");

        list.forEach(System.out::println);

        //List<java.util.ArrayList<String>> arr = Arrays.asList(list);
    }

    @Test
    public void testUsages(){
        Object[] arr = new Object[]{};
        System.out.println("length : "+arr.length);
        System.out.println("0>>1 : "+(20>>1));
        System.out.println("10>>1 : "+(4>>1));
        System.out.println("max length : "+(Integer.MAX_VALUE - 8));  //(2^31-1) - 8
    }




}
