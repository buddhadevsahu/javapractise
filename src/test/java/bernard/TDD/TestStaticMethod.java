package bernard.TDD;

import org.junit.Assert;
import org.junit.Test;

public class TestStaticMethod {

    @Test
    public void testProcess(){
        boolean isPassed=true;
        try{
            StaticA.process();
        }
        catch(Exception e){
            System.out.println(" exception :"+e.getMessage());
            isPassed=false;
        }

        Assert.assertTrue("should be passed",isPassed);
    }

    @Test
    public void testProcess2() throws Exception {
        StaticB.m3();
        StaticB.process();
    }

}
