package bernard.problem;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SherlockAnagram {

    @Test
    public void testAnagram(){
        assertEquals(4,sherlockAndAnagrams("abba"));
    }

    static int sherlockAndAnagrams(String s) {
        int count=0;
        Integer length = s.length();
        Map<String,Integer> map = new HashMap<>();
        for(Integer i =0; i < length ; i++){
            for(Integer j=length; j >=i ;j--){
                String word = s.substring(i,j);
                //reverse the string and check
                String rev_str= new StringBuffer(word).reverse().toString();
                Integer value = map.get(rev_str);
                if(value == null){
                    //put in the map
                    map.put(rev_str,1);
                }
                else{
                    System.out.println(word);
                    count = count +1;
                }
            }
        }
        return count;
    }
}
