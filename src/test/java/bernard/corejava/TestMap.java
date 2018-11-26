package bernard.corejava;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        List<String> input = Arrays.asList(new String[]{"SOM", "BUDDHA", "SOM", "MONIKA"});
        Map<String, BigDecimal> map = new HashMap<>();


        for (String value : input) {
            BigDecimal val = map.computeIfAbsent(value, (k) -> {
                return new BigDecimal(1);
            });
            val.add(new BigDecimal(1));
        }

        System.out.println(map.toString());
    }
}
