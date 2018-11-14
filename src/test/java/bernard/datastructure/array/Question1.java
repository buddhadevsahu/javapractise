package bernard.datastructure.array;

import java.util.HashMap;
import java.util.HashSet;

public class Question1 {

    public static void main(String[] args) {

        int[] array={3,6,4,5,6,7,3,9};

        int result = solution(array);

        System.out.println("result : "+result);


    }

    private static int solution(int[] array) {
        int result=-1;
        boolean isExist=false;

        HashSet<Integer> set= new HashSet<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0 ;i < array.length;i++){
            int val=array[i];
            System.out.println(" iteration i "+i+"   value : "+val);
            boolean isThere=set.add(val);
            System.out.println("isThere "+isThere);
            if(!isThere){

                System.out.println("putting val in map");
                map.put(val,i);
                isExist=true;

            }

        }
        int leastValue=-1;
        for(int value:map.values()){
            System.out.println(leastValue+" min calculation value :"+value);
            if(leastValue==-1)
                leastValue=value;
            if(value <= leastValue) {
                leastValue = value;
                System.out.println(" min modified to  :"+leastValue);
            }
        }

        for(int key:map.keySet()){

            if(map.get(key)==leastValue)
                result=key;
        }


        return isExist?result:-1;
    }
}
