package bernard.java8.practices;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairClassTest {

    @Test
    public void testPair(){
        ArrayList<Pair<Integer,Integer>> list = new ArrayList<>();
        list.add(new Pair<>(0,6));
        list.add(new Pair<>(3,4));
        list.add(new Pair<>(8,9));
        list.add(new Pair<>(5,9));
        list.add(new Pair<>(1,2));
        list.add(new Pair<>(5,7));

        List<Pair<Integer, Integer>> sortedList = list.stream().sorted((x, y) -> x.getKey() - y.getKey()).collect(Collectors.toList());
        sortedList.stream().forEach(x-> System.out.println(x.toString()));

    }
}
