package bernard.collections;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LinkedHashMapTest {

    // insertion order test os linked hash map
    @Test
    public void testInsertionOderOfLinkedHashMap(){

        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("Z","value Z");
        map.put("X","value X");
        map.put("Y","value Y");
        String[] expected={"value Z","value X","value Y"};
        assertArrayEquals(expected,map.values().toArray());
    }
    // insertion order test os linked hash map
    @Test
    public void testInsertionOderOfLinkedHashMapWithCollision(){

        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("Z","value Z");
        map.put("X","value X");
        map.put("Y","value Y");
        map.put("X","value A");
        String[] expected={"value Z","value A","value Y"};
        assertEquals(3,map.size());
        assertArrayEquals(expected,map.values().toArray());

    }
  /*  LinkedHashMap has special constructor to create the access order map.

    Keys are sorted on the basis of access order e.g Invoking the put, putIfAbsent, get,
     getOrDefault, compute, computeIfAbsent, computeIfPresent, or merge methods results
      in an access to the corresponding entry.

    The keys are sorted from least recently accessed used to most recently accessed.

    */
    // by default linked hash map maintain insertion order
    //access order need to be specify explicitly
    //access Order test
    @Test
    public void testAccessOrder(){
        LinkedHashMap<String,String> map = new LinkedHashMap<>(10,0.75f,true);
        map.put("A","value A");
        map.put("B","value B");
        map.put("C","value C");
        map.put("D","value D");

        String[] expected={"value A","value B","value C","value D"};
        assertArrayEquals(expected,map.values().toArray());


        map.get("B");
        String[] expected1={"value A","value C","value D","value B"};
        assertArrayEquals(expected1,map.values().toArray());


        //print list after modification
        map.forEach((k,v)->{System.out.println(k+" "+v);});
    }

    //test LRU impleentation using linkedlist
     public void testLRUusingLinkedList(){


     }



}
