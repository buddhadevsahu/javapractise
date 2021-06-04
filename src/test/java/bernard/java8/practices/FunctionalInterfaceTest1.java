package bernard.java8.practices;

import org.junit.Test;

import java.util.*;

public class FunctionalInterfaceTest1<T,V> {

    private Converter<T,V> logic;
    private V data;

    public FunctionalInterfaceTest1(V data,Converter<T,V> func){
        this.data=data;
        this.logic =func;
    }
    public T convert(){
        return logic.convert(data);
    }
    public void setConverterLogic(Converter<T,V> func){
        this.logic =func;
    }




     @Test
     public void testWordCount(){
            List<String> input = Arrays.asList(new String[]{"SOM", "BUDDHA", "SOM", "MONIKA"});
            Map<String,Integer> map = new HashMap<>();

            Converter<Map<String,Integer>,List<String>> logic=(x)->{


                for (String value:input) {
                    Integer  val=map.computeIfAbsent(value,(k)->{ return 0;});
                    val=val+1;
                }

                //input input :
                //input.stream().


                return null;
            };


         FunctionalInterfaceTest1<Map<String,Integer>,List<String>> obj= new FunctionalInterfaceTest1<>(input,logic);
         obj.convert();

    /*
            WordCount<String> word= x -> {
                //boolean isThere = Stream.of(x).findAny().equals("SOM");
                Stream.of(x).forEach((y)->{
                    System.out.println("foreach : "+y);
                });

                return null;
            };
    */

      /*      FunctionalInterfaceTest1<String> obj = new FunctionalInterfaceTest1<>(input,word);
            obj.getWordCount();*/

     }

 //requiremnt


 @FunctionalInterface
 static interface Converter<T,V>{
        T convert(V value);
 }

}
