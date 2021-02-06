package bernard.java8.practices;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8ArrayTest {
    public List<Integer> add(int[] ar){
        int result = Arrays.stream(ar).reduce((x, y) -> x + y).orElse(0);
        List<Integer> list=Arrays.asList(1,2);
        list.clear();
        return Arrays.asList(1,2);

    }

    @Test
    public void testSort(){
        int A=1;
        int B=2;
        int C=3;
        int D=1;

        List<Integer> sorted=Arrays.asList(A,B,C,D)
                .stream()
                .sorted().collect(Collectors.toList());

        sorted.forEach(System.out::println);

        A=sorted.get(0);
        B=sorted.get(1);
        C=sorted.get(3);
        D=sorted.get(2);
        int result= (int)(Math.pow((D-A),2)+Math.pow((C-B),2));

        System.out.println("result : " +result);

    }


    @Test
    public void testsolutions(){
        Assert.assertFalse(solution(new int[]{1,3,3},2));
        Assert.assertTrue(solution(new int[]{1,1,2,3,3},3));
    }

    public boolean solution(int[] A, int K) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (!(A[i] <= A[i + 1] && A[i] <= K && A[i+1]<=K))
                return false;
        }
        if (A[0] != 1 && A[n - 1] != K)
            return false;
        else
            return true;
    }
}
