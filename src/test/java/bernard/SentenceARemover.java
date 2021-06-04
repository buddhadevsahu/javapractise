package bernard;

import org.junit.Assert;
import org.junit.Test;

public class SentenceARemover {


    public static String removeaFromString(String str){

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < str.length(); i++){
            Character ch = str.charAt(i);
            if(!(ch.equals('a') || ch.equals('A'))){
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    @Test
    public void testString(){
        String input ="welcome to tiaa india family";
        Assert.assertEquals("welcome to ti indi fmily",removeaFromString(input));
    }
}
