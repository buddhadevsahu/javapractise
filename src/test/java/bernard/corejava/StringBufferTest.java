package bernard.corejava;

import org.junit.Test;

import java.util.HashSet;

public class

StringBufferTest {

/*
    What are the differences between StringBuffer and StringBuilder?
    StringBuffer:   StringBuffer is to used when multiple threads are working on
                    the same String. thread safe

    StringBuilder:	StringBuilder is used in a single-threaded environment.
*/
    @Test
    public void testStringBuffer(){
        StringBuffer sb = new StringBuffer();
        sb.append("Hello")
                .append(" ")
                .append("world")
                .append(1).insert(5,2);

        StringBuilder sb1= new StringBuilder().append("Hello").append(" ").append("world");
String str= null;
str.trim().equals("");


        HashSet<Character> set = new HashSet<>();
       // set.contains();
        char ch = 'f';
        new String();
        String str2=ch+"";
        new Character(ch).toString();

        new Character(str.charAt(1));

method(1,0);
    }

    public static long method(int i,long l){
        return 0L;
    }
}
