package bernard.java8.practices;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MyStreamTest {

    @Test
    public void testStreamIfAny(){

        List<String> list = Arrays.asList(new String[]{"jems","nick","aldrin","rocky","daniel"});
        boolean result = list.stream().findAny().equals("ram");
       // boolean result = list.stream().findAny();
        System.out.println("result : "+result);

    }

}
