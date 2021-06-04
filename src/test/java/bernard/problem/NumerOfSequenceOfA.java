package bernard.problem;

import java.util.HashMap;

public class NumerOfSequenceOfA {

    public static void main(String[] args) {
        System.out.println("out put"+repeatedString1("aab",882787));
    }


    static long repeatedString(String s, long n) {

        if(s==null)
            return 0;

        long count=0;
        HashMap<Long,Long> map = new HashMap<>();
        for(int i=0;i< s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a')
                count=count+1;
            map.put(new Long(i),count);
        }
        long remainder = n % s.length();
        long q = n / s.length();
        long total =  q * map.get((long)s.length() -1);
        if(remainder ==0)
            return total;
        else
            return total+map.get(remainder);


    }


    static long repeatedString1(String s, long n) {
        long count =0;
        for(char c : s.toCharArray())
            if(c == 'a')
                count++;

        long factor = (n/s.length());
        long rem = (n%s.length());
        count =  factor*count  ;
        for(int i=0;i<rem;i++)
            if(s.charAt(i)=='a')
                count++;
        return count;
    }
}
