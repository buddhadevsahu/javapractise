package bernard.java8.practices;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

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
