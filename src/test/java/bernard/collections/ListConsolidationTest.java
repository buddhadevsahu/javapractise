package bernard.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListConsolidationTest {

    List<String> validate(List<String> l1,List<String> l2){
        ListIterator<String> itr = l1.listIterator();

        while(itr.hasNext()){
            String val = itr.next();
            if(l2.contains(val)){
                //l2.remove(val);
                itr.remove();
            }

        }
        List<String> result = new ArrayList<String>();
        result.addAll(l2);
        result.addAll(l1);
        return result;
    }

    @Test
    public void testListValidation(){
        List<String> list1 = Arrays.asList("1","2","5","6");
        List<String> list2 = Arrays.asList("10","12","5","6");
        List<String> expected = Arrays.asList("1","2","10","12");
        List<String> list3 = validate(list1, list2);
        Assertions.assertArrayEquals(expected.toArray(),list3.toArray());
    }

}
