package bernard.collections;

import java.util.HashSet;

public class SetTest {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.addAll(null);
        System.out.println("result : "+set.toString());
    }
}
