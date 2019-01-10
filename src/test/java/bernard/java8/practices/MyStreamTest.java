package bernard.java8.practices;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStreamTest {

    private final static List<Dish> menu= Arrays.asList(
            new Dish("pork",false,800,Dish.Type.MEAT),
            new Dish("beef",false,700,Dish.Type.MEAT),
            new Dish("chicken",false,400,Dish.Type.MEAT),
            new Dish("rice",true,350,Dish.Type.OTHER),
            new Dish("french fries",true,530,Dish.Type.OTHER),
            new Dish("season fruits",true,120,Dish.Type.OTHER),
            new Dish("pizza",true,550,Dish.Type.OTHER),
            new Dish("prawns",false,300,Dish.Type.FISH),
            new Dish("salmon",false,450,Dish.Type.FISH)
    );



    @Test
    public void testStreamIfAny(){

        List<String> list = Arrays.asList(new String[]{"jems","nick","aldrin","rocky","daniel"});
        boolean result = list.stream().findAny().equals("ram");
       // boolean result = list.stream().findAny();
        System.out.println("result : "+result);

    }

    @Test
    public void testStreamGrouping(){
        Map<Dish.Type, List<Dish>> result = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println("result : "+result.toString());
    }
    @Test
    public void testFilterThreeHighestCalories(){
        List<String> result = menu.stream()
                .filter(x -> x.getCalories() > 400)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("result : "+result.toString());
    }

    @Test
    public void testNoOfIterationForStream(){
        List<String> result = menu.stream()
                .filter(x -> {
                    System.out.println("filter name : "+x.getName());
                    return x.getCalories() > 400;}
                )
                .map(x->{
                    System.out.println("mapping name : "+x.getName());
                    return x.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("result : "+result.toString());
    }

    @Test
    public void testFlatMap1(){
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(7, 8, 9);

        List<List<Integer>> re = list1.stream().flatMap(x -> {
            System.out.println("value : " + x);

            return list2.stream()
                    .filter(y -> x + y == 10)
                    //.map(y -> new int[]{x, y});
                    .map(y -> Arrays.asList(x, y));
        }).collect(Collectors.toList());

        System.out.println("result "+re);
    }


    //get distinct character from  given array of String
    @Test
    public void testStringArrayStream(){

        String[] words= new String[]{"Goodbye", "World"};
        List<String> res = Arrays.stream(words)
                .flatMap(x -> Arrays.stream(x.split("")))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("result "+res);
    }

    //get duplicate character from  given array of String
    @Test
    public void givenaStringArrayfindDuplicateCharacter(){

        String[] words= new String[]{"Goodbye", "World","W",""};
        Set<String> set = new HashSet<>();
        Set<String> res = Arrays.stream(words)
                .flatMap(x -> Arrays.stream(x.split("")))
                .filter(x -> !set.add(x))
                .collect(Collectors.toSet());
        System.out.println("result "+res);
    }

    //finding an
    @Test
    public void givenMenuFindAnyVegiterianFood(){

        //Optional<Dish> res = menu.stream().filter(x -> x.isVegiterian()).findAny();
        Optional<Dish> res = menu.stream().filter(x->false).findAny();
        if(res.isPresent()) {
            System.out.println("result : "+res.get());
        }
        else {
            System.out.println("result : no value found");
        }
        Optional<Dish> res2 = menu.stream().filter(x->false).findAny();
    }


    //finding an
    @Test
    public void givenMenuFinMaximumCaloriesFood(){

        Optional<Integer> r = menu.stream().map(x -> x.getCalories()).reduce(Integer::min);

        System.out.println(r.orElse(0));

    }

    public <T> void method(A<? extends T> a){

    }

    static class A<R>{
        List<R> list = new ArrayList<>();

        void add(R r){
            list.add(r);
        }
        void print(){
            System.out.println(list.toString());
        }

    }

}
