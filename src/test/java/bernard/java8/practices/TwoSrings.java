package bernard.java8.practices;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TwoSrings {

    @Test
    public void testSubString(){
        assertEquals("YES",twoStrings("hello","world"),"not matched");
        assertEquals("NO",twoStrings("hi","world"),"not matched");

        assertEquals("NO",twoStrings("wouldyoulikefries","abcabcabcabcabcabc"),"not matched");
        assertEquals("YES",twoStrings("hackerrankcommunity","cdecdecdecde"),"not matched");
        assertEquals("YES",twoStrings("jackandjill","wentupthehill"),"not matched");
        assertEquals("NO",twoStrings("writetoyourparents","fghmqzldbc"),"not matched");
    }

    static String twoStrings1(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            for(int j=0; j < s2.length();j++){
                char ch2=s2.charAt(j);
                if(ch==ch2){
                    return "YES";
                }
            }
        }
        return "NO";
    }

    static String twoStrings(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            Integer count=map.get(ch);
            if(count==null){
                map.put(ch,1);
            }
            else{
                map.put(ch,++count);
            }
        }

        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            Integer count=map2.get(ch);
            if(count==null){
                map2.put(ch,1);
            }
            else{
                map2.put(ch,++count);
            }
        }

        for(Character ch : map.keySet()){
            if(map2.containsKey(ch)){
                return "YES";
            }
        }
        return "NO";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
