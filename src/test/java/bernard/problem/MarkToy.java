package bernard.problem;

import org.junit.Test;

import java.util.Arrays;

public class MarkToy {

    @Test
    public void testMaximizeToyPurchase(){
        int[] arr={10,2,20,5,40,15,3};
        int amount=30;
        maximizeToyPurchase(arr,amount);
    }

    private void maximizeToyPurchase(int[] arr, int amount) {
        final int sum=0;
/*        Arrays.stream(arr).sorted().forEach(x->{
            if(sum < amount)
                sum=sum+amount;
        }); */
       // int count=0;
        int result = Arrays.stream(arr).sorted().reduce(
                (x, y) -> {

                    int r=x + y;
                    // count= count + 1;
                    return r;
                    }
                        ).orElse(0);
        System.out.println("result "+result);
    }
}
