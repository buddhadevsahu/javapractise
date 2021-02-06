package bernard.problem;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonSecretCodeWinner {

    @Test
    public void testSecretCodeWin1() {

        List<String> codeGroup1 = Arrays.asList("apple", "anything", "banana");
        List<String> codeGroup2 = Arrays.asList("banana", "guava");
        List<List<String>> codelist = Arrays.asList(codeGroup1, codeGroup2);
        List<String> shoppingCart = Arrays.asList("oranges","apple", "apple", "banana", "banana", "guava");
        int result = isSecretCodeWinner(codelist, shoppingCart);
        Assert.assertEquals("should be 1", 1, result);

        shoppingCart = Arrays.asList("oranges","apple", "apple", "banana", "guava");
        result = isSecretCodeWinner(codelist, shoppingCart);
        Assert.assertEquals("should be 0", 0, result);

        shoppingCart = Arrays.asList("apple", "apple", "banana", "banana");
        result = isSecretCodeWinner(codelist, shoppingCart);
        Assert.assertEquals("should be 0", 0, result);


    }

    public int isSecretCodeWinner(List<List<String>> codelist, List<String> shoppingcart) {

        List<String> codes = codelist.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        int codeSize = codes.size();
        int cartSize = shoppingcart.size();
        if (cartSize < codeSize)
            return 0;
        int noOfIteration = cartSize - codeSize + 1;
        for (int i = 0; i < noOfIteration; i++) {
            boolean isMatched = false;
            for (int j = 0; j < codeSize; j++) {
                String code = codes.get(j);
                String item = shoppingcart.get(i + j);
                if (code.equalsIgnoreCase(item) || "anything".equalsIgnoreCase(code)) {
                    isMatched = true;
                } else {
                    isMatched = false;
                    break;
                }
            }
            if (isMatched)
                return 1;
        }


        return 0;
    }


}
