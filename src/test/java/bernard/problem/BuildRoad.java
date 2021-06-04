package bernard.problem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildRoad {

    @Test
    public void test(){
        long[] arr = {1,2,2,4,4,7,4};
       assertEquals(6,solve(arr,arr.length));
    }
    public static long solve(long[] arr, long N){
        // Write your code here
        int count=0;
        if(arr==null || arr.length==0)
            return 0;

        for(int i = 0; i < arr.length ;i++){
            long value1 = arr[i];
            for(int j = i+1; j < arr.length;j++){
                long value2 =arr[j];

                if(value1 < value2){
                    long power=value1*value1;
                    if(value2 == power){
                        count++;
                        //System.out.println(" ("+i+" , "+j+")");
                        if(power==1)
                            count++;
                    }
                }
                else{
                    long power=value1*value1;
                    if(value1 == (value2*value2)){
                        count++;
                        //System.out.println(" ("+i+" , "+j);
                        if(power==1)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
