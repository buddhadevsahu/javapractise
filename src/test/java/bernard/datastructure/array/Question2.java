package bernard.datastructure.array;

import java.util.LinkedHashSet;
import java.util.Set;

public class Question2 {


    public static void main(String[] args) {
        
        String[] name={"hari","shyam","ram","hari","hari","radha"};
        String[] surname={"sahu","reddy","saste","sahu","sahu","madhav"};

        Set<String> finallist=generaMyProducerteEmail(name,surname);

        System.out.println("values "+ finallist.toString());

        
        
    }

    private static Set<String> generaMyProducerteEmail(String[] name, String[] surname) {

        Set<String> set = new LinkedHashSet<>();

        for(int i =0 ; i< name.length;i++){

            String email=name[i]+"_"+surname[i];

            System.out.println(" befores while "+email);
            boolean isThere = false;
            int inc=0;
            while((isThere=set.contains(email+"@gmail.com"))==true){
                email=increaseEmailVersion(email);
                //System.out.println(" in while "+email);
            }
            System.out.println(" after while "+email);
            set.add(email+"@gmail.com");
        }
        return set;
    }

    private static String increaseEmailVersion(String name) {
        String value=null;

        String[] split= name.split("@");
        String firstStr=split[0];
        String digit = split[0].replaceAll("[^0-9]","");
        Integer inc = Integer.getInteger(digit);
        String actual=split[0].replaceAll("[0-9]",(++inc).toString());
        return actual;
    }


}
