package bernard.collections;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("RAM","ramachandra sahu");
        map.put(null,null);
        map.put(null,"RAM");
        map.put("RAM",null);
        System.out.println("map : "+map.toString());

        Hashtable<String,String> table = new Hashtable<>();

        table.put("RAM","ramachandra sahu");
        //null in the hashmap table will not work.
       // table.put(null,null);
        //table.put(null,"RAM");
        //table.put("RAM",null);
        System.out.println("table : "+table.toString());

    }

    static class A{
        public A(){
            System.out.println("const A() ");
        }

        static{
            System.out.println("static A() ");
        }

        {
            System.out.println("IIB A() ");
        }
    }
    static class B extends A{
        String   s;

        public  B(){
            System.out.println("const B() ");
            //super();
            //this("buddha");
            s="pranit";
        }
        public B(String s){
            this();
            System.out.println("const B( string ) ");
        }

        static {
            System.out.println("static B() ");
        }

        {
            System.out.println("IIB B() ");
        }
    }

    @Test
    public void testInheritance(){

        new B("SOM"); //1) const A() ,const B() , const B( string )
       new B("BUDDHA");
        //
    }
}
