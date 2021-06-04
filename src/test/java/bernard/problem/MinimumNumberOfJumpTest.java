package bernard.problem;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MinimumNumberOfJumpTest {

    @Test
    public void test1(){

        //int[] array = new int[]{1,3,5,8,9,2,6,7,6,8,9};
        //int[] array = new int[]{3,5,8};//1
        int[] array = new int[]{2,5,8,4};//2
        assertEquals(3,getMinimumNoStepToReachLast(array));
    }

    private int getMinimumNoStepToReachLast(int[] input) {
        assertNotNull(input);
        assertTrue(input.length>0);
        return findMinStep(0,input,1);
    }

    private int findMinStep(int start,int[] input,int step){


        if(start > input.length-1)
            return step;

        //check in the starting step it is surpassed
        if(start>input.length){
            System.out.println("index:"+start+" value:"+input[start]);
            return step;
        }
        for (int i = start+1; (i< input.length) && (i <= start+input[start]) ; i++) {
            int result=start+input[i];
            if(result > input.length) {
                System.out.println("index:"+i+" value:"+input[i]);
                return step+1;
            }
            findMinStep(result,input,step+1) ;
        }
        return step;
    }


}
