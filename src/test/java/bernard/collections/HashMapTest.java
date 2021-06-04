package bernard.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class HashMapTest {

    @Test
    public void testNull(){
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

    @Test
    public void testDuplicate(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("A",4);
        System.out.println("map : "+map.size());
        System.out.println("map : "+map.get("A"));
        System.out.println("map : "+map.toString());


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

    @Test
    public void testMapRemove(){
        Map<String,String> map = new HashMap<>();
        map.put("one","one");
        map.put("two","two");
        map.put("three","three");
        map.put("four","four");
        map.put("five","five");
        System.out.println("after "+map);

        List<String> list = new ArrayList<>();
        list.add("two");
        list.add("four");

        for(String key:list){
            map.remove(key);
        }

        System.out.println("after "+map);
    }


    @Test
    public void testHashMapOperationPut(){

        Employee emp1 = new Employee(1, "A");
        Employee emp2 = new Employee(1, "B");

        HashMap<Employee,Integer> map = new HashMap<>();

        map.put(emp1,emp1.id);
        map.put(emp2,emp2.id);

        map.clear();

        map.put(null,1);
        map.put(null,2);

        map.get(new Employee(1,"C"));


        Assert.assertEquals("not matched",2,map.size());

    }


    static class Employee{
        private int id;
        private String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object obj) {
            Employee emp = (Employee) obj;
            return this.name.equals(emp.name);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
