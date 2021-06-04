package bernard.problem;

import org.junit.Assert;
import org.junit.Test;

public class FloatComparison {

    @Test
    public void testFloat(){

        Float f1 = 8.23f;
        Float f2 = 8.233f;
        Float f3 = 8.2f;
        Assert.assertEquals(f1,f2,0.01);
        System.out.println(getAbsoluteValue(f1));
        System.out.println(getAbsoluteValue(f2));
        System.out.println(getAbsoluteValue(f3));


    }

    static int getAbsoluteValue(Float f){
        Float f2 =f*100;
        //Math.
        return f2.intValue();
    }

    @Test
    public void testLong(){
       Long L = Long.parseLong("2");
       long l = 2L;
        Assert.assertTrue(L.equals(l));
    }
}
