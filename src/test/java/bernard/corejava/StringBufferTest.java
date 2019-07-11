package bernard.corejava;

import org.junit.jupiter.api.Test;

public class StringBufferTest {

    @Test
    public void testStringBuffer(){
        StringBuffer sb = new StringBuffer();
        sb.append("Hello")
                .append(" ")
                .append("world")
                .append(1).insert(5,2);

        StringBuilder sb1= new StringBuilder().append("Hello").append(" ").append("world");


    }
}
