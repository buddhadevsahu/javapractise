package bernard.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMultiple {



    public void sort(List<Person> list, String[] sortBy){
        String[] comp;

        Collections.sort(list,new NameComparator());
        list.stream().sorted(new AgeComparator()).sorted(new NameComparator());
        //Collections.sort(list);
    }

}

class AgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
/*        if(o1 ==null){
            if(o2 == null)
                return 0;
            else
                return -1;
        }*/
/*Person p1=(Person)o1;
Person p2=(Person)o2;*/
return o1.getName().compareTo(o2.getName());
    }
}

class NameComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
/*        if(o1 ==null){
            if(o2 == null)
                return 0;
            else
                return -1;
        }*/
        Person p1=(Person)o1;
        Person p2=(Person)o2;
        return p1.getName().compareTo(p2.getName());
    }
}

 class Person{

    String name;
    String city;

     public Person(String name, String city) {
         this.name = name;
         this.city = city;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getCity() {
         return city;
     }

     public void setCity(String city) {
         this.city = city;
     }
 }
