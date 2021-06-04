package bernard.java8.practices;

import org.junit.Test;

public class StreamTest {



    @Test
    public void optionalTest(){
        Lambda lambda = (n) -> { return n *n;};
        System.out.println(lambda.operation(2));
    }





    interface Lambda {
        int operation(int number);
    }
}

