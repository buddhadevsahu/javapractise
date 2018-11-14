package bernard.java8.practices;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void testStringAppend(){

        StringBuilder sb = new StringBuilder("RAM");
        StringBuilder sb2 = sb.append("hari");
        // one object or two object
        assertTrue(sb==sb2);//false  //reference memory
        assertTrue(sb.equals(sb2));//false   // content

        String str ="ram";
        String str2=str.concat("hari").concat("sachin");
        assertFalse(str==str2);//false  //reference memory
        assertFalse(str.equals(str2));//false   // content

    }
}
