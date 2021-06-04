package bernard.problem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HourGlassSum {

    @Test
    public void testHourGlassSum(){
        int arr[][] = new int[][]{
                {1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0}};

        assertEquals(19,findMaxHourGlassSum(arr));



    }

    public int findMaxHourGlassSum(int[][] arr){

        int yl=arr.length;
        int xl = arr[0].length;
        int max= -64;

        for(int i=0;i< yl-2; i++){
            for(int j=0;j < xl-2; j++){
                int value=calculateHourGlassSum(arr,i,j,xl,yl);
                if(value > max)
                    max=value;
            }
        }
        return max;
    }

    private int calculateHourGlassSum(int[][] arr, int i, int j, int xl, int yl) {
        int sum=0;
        sum=sum+arr[i][j];
        sum=sum+arr[i][j+1];
        sum=sum+arr[i][j+2];
        sum=sum+arr[i+1][j+1];
        sum=sum+arr[i+2][j];
        sum=sum+arr[i+2][j+1];
        sum=sum+arr[i+2][j+2];
        return sum;
    }
}
