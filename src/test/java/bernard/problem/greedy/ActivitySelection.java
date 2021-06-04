package bernard.problem.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Logger;

public class ActivitySelection {

    @Test
    public void testSortingOfInput(){
        int[][] arr = getInputTimeSlots();
        sort(arr,1);
        printTwoDimentionalArray(arr);
    }

    @Test
    public void testActivitySelection(){
   /*     1) Sort the activities according to their finishing time
        2) Select the first activity from the sorted array and print it.
        3) Do following for remaining activities in the sorted array.
            a) If the start time of this activity is greater than or equal to the finish time of previously selected activity then select this activity and print it.
        */
        int[][] arr = getInputTimeSlots();
        printTwoDimentionalArray(arr);
        sort(arr,1);
        printTwoDimentionalArray(arr);
        activitySelection(arr);
    }

    private void activitySelection(int[][] arr) {
        System.out.println("\nprinting activity selections\n");
        printArray(arr[0]);
        int finish_time= arr[0][1];
        for(int i = 1; i < arr.length ; i++){
            //If the start time of this activity is greater than or equal to
            // the finish time of previously selected activity then select this activity and print it.
            int start_time = arr[i][0];
            if(start_time >= finish_time){
                System.out.println();
                printArray(arr[i]);
                finish_time=arr[i][1];
            }
        }

    }

    private void printArray(int[] current) {
        Arrays.stream(current).forEach(y -> System.out.print(" " + y));
    }
    private void printTwoDimentionalArray(int[][] arr) {
        System.out.println("===== printing 2 dimensional array\n");
        Arrays.stream(arr).forEach(x->{
            System.out.println();
            printArray(x);
        });
    }

    private int[][] getInputTimeSlots() {
        return new int[][]{
                    //{start time , end time}
                    {0,6},
                    {3,4},
                    {8,9},
                    {5,9},
                    {1,2},
                    {5,7}
            };
    }



    //Bubble sort
    public void sort(int[][] arr,int sort_index){
        System.out.println("Sorting array");
        int y_length = arr.length;
        System.out.println("y length "+y_length);

        for(int i=0 ; i < y_length; i++){
/*            int[] record = arr[i];
            int x_length = record.length;
            System.out.println("x length "+x_length);*/


            for(int j=0 ; j < y_length-i -1; j++){
                int current = arr[j][1];
                int matching = arr[j+1][1];
                if(arr[j][sort_index] > arr[j+1][sort_index]){
                    //swap end time of both records
                    int temp = arr[j+1][1];
                    arr[j+1][1]=arr[j][1];
                    arr[j][1]=temp;

                    //swap start time of both records
                    temp = arr[j+1][0];
                    arr[j+1][0]=arr[j][0];
                    arr[j][0]=temp;
                }

            }

        }
    }












}
